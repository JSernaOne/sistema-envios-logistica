package com.envios.service;

import com.envios.controller.*;
import com.envios.entity.ClienteEntity;
import com.envios.entity.EmpleadoEntity;
import com.envios.entity.EnvioEntity;
import com.envios.entity.PaqueteEntity;
import com.envios.model.Envio;
import com.envios.model.Paquete;
import com.envios.repository.ClienteRepository;
import com.envios.repository.EmpleadoRepository;
import com.envios.repository.EnvioRepository;
import com.envios.repository.PaqueteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository envioRepository;
    private final PaqueteRepository paqueteRepository;
    private final ClienteRepository clienteRepository;
    private final EmpleadoRepository empleadoRepository;
    private final PaqueteService paqueteService;
    private final EnvioEstadoDTO envioEstadoDTO = new EnvioEstadoDTO();

    // Crear un nuevo envío
    @Transactional // es para que si una de las operaciones falla, se haga un rollback de todas las operaciones
    public EnvioCreadoDTO crear(EnvioDTO envioDTO) {
        // Validaciones previas
        validarEnvioDTO(envioDTO);

        // Buscar cliente
        ClienteEntity cliente = clienteRepository.findById(envioDTO.getCedulaCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // Crear modelo lógico Paquete
        Paquete paquete = new Paquete(envioDTO.getPeso(), envioDTO.getValorDeclarado());

        // Convertir a entidad y guardar en base de datos
        PaqueteEntity paqueteEntity = new PaqueteEntity(
                paquete.getTipo(),
                paquete.getPeso(),
                paquete.getValorDeclarado()
        );
        paqueteEntity = paqueteRepository.save(paqueteEntity); // Guardar en la BD

        // Crear entidad Envio
        EnvioEntity envioEntity = new EnvioEntity(
                envioDTO.getCiudadOrigen(),
                envioDTO.getCiudadDestino(),
                envioDTO.getDirDestino(),
                envioDTO.getNombreRecibe(),
                envioDTO.getCelularRecibe(),
                calcularHoraEntrega(),
                envioEstadoDTO.getEstadoInicial(),
                new Envio().calcularValorEnvio(paqueteEntity.getTipo()),
                cliente,
                paqueteEntity
        );
        envioEntity = envioRepository.save(envioEntity); // Guardar en la BD

        // Crear respuesta DTO
        return new EnvioCreadoDTO(envioEntity.getNumGuia(), envioEntity.getEstado());
    }


    // Cambiar estado de un envío
    public EnvioCreadoDTO cambiarEstado(EnvioCambiarEstadoDTO envioCambiarEstadoDTO) {
        EnvioEntity envio = envioRepository.findById(envioCambiarEstadoDTO.getNumGuia())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el envío con número de guía: " + envioCambiarEstadoDTO.getNumGuia()));

        EmpleadoEntity empleado = empleadoRepository.findById(envioCambiarEstadoDTO.getCedulaEmpleado())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el empleado con cédula: " + envioCambiarEstadoDTO.getCedulaEmpleado()));

        validarPermisosEmpleado(empleado);

        String nuevoEstado = validarYObtenerEstado(envioCambiarEstadoDTO.getEstado());
        envio.setEstado(nuevoEstado);
        envioRepository.save(envio);

        return new EnvioCreadoDTO(envio.getNumGuia(), envio.getEstado());
    }

    // Buscar un envío por su número de guía
    public EnvioDetalleDTO buscar(Integer numGuia) {
        if (numGuia == null) {
            throw new IllegalArgumentException("El número de guía no puede ser nulo.");
        }

        EnvioEntity envio = envioRepository.findById(numGuia)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el envío con número de guía: " + numGuia));

        return new EnvioDetalleDTO(
                envio.getNumGuia(),
                envio.getCiudadOrigen(),
                envio.getCiudadDestino(),
                envio.getDirDestino(),
                envio.getNombreRecibe(),
                envio.getCelularRecibe(),
                envio.getValorEnvio(),
                envio.getPaquete().getValorDeclarado(),
                envio.getPaquete().getPeso(),
                envio.getCliente().getCedula(),
                envio.getCliente().getNombre()
        );
    }

    // Filtrar envíos por estado
    public List<EnvioEntity> filtrar(String estado) {
        String estadoValidado = validarYObtenerEstado(estado);

        List<EnvioEntity> resultado = envioRepository.filtrarPorEstado(estadoValidado);

        if (resultado.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron envíos con el estado: " + estadoValidado);
        }

        return resultado;
    }

    // Calcular hora estimada de entrega
    public String calcularHoraEntrega() {
        LocalDateTime horaEntrega = LocalDateTime.now().plusHours(72);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(horaEntrega);
    }

    // Métodos auxiliares

    private void validarEnvioDTO(EnvioDTO envioDTO) {
        if (envioDTO.getCedulaCliente() == null ||
                envioDTO.getCiudadOrigen() == null ||
                envioDTO.getCiudadDestino() == null ||
                envioDTO.getDirDestino() == null ||
                envioDTO.getNombreRecibe() == null ||
                envioDTO.getCelularRecibe() == null ||
                envioDTO.getPeso() <= 0 ||
                envioDTO.getValorDeclarado() <= 0) {
            throw new IllegalArgumentException("Todos los campos del envío deben estar completos y ser válidos.");
        }
    }

    private EnvioEntity guardarEnvio(EnvioDTO envioDTO, ClienteEntity cliente, PaqueteEntity paqueteEntity) {
        EnvioEntity envio = new EnvioEntity(
                envioDTO.getCiudadOrigen(),
                envioDTO.getCiudadDestino(),
                envioDTO.getDirDestino(),
                envioDTO.getNombreRecibe(),
                envioDTO.getCelularRecibe(),
                calcularHoraEntrega(),
                envioEstadoDTO.getEstadoInicial(),
                new Envio().calcularValorEnvio(paqueteEntity.getTipo()),
                cliente,
                paqueteEntity
        );
        return envioRepository.save(envio);
    }

    private void validarPermisosEmpleado(EmpleadoEntity empleado) {
        if (!"REPARTIDOR".equals(empleado.getTipo()) && !"COORDINADOR".equals(empleado.getTipo())) {
            throw new IllegalArgumentException("El empleado no tiene permisos para cambiar el estado del envío.");
        }
    }

    private String validarYObtenerEstado(String estado) {
        List<String> estadosValidos = List.of("RECIBIDO", "EN_RUTA", "ENTREGADO");
        String estadoUpperCase = estado.toUpperCase();

        if (!estadosValidos.contains(estadoUpperCase)) {
            throw new IllegalArgumentException("Estado inválido. Estados válidos: " + estadosValidos);
        }
        return estadoUpperCase;
    }
}
