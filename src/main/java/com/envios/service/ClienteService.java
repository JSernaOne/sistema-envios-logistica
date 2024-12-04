package com.envios.service;

import com.envios.entity.ClienteEntity;
import com.envios.model.Cliente;
import com.envios.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente crear(Cliente cliente) {

        if (cliente == null) {
            /* throw new ApiRequestException("El cliente no puede ser nulo ");*/
            System.out.println("El cliente no puede ser nulo");

        }
        if (cliente.getCedula() == null || cliente.getApellido() == null || cliente.getNombre() == null) {
            /* throw new ApiRequestException("la cedula, el apellido o el nombre son invalidos");*/
            System.out.println("la cedula, el apellido o el nombre son invalidos");
        }

        ClienteEntity clienteEntity = new ClienteEntity(
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCelular(),
                cliente.getEmail(),
                cliente.getDirResidencia(),
                cliente.getCiudad()
        );

        clienteRepository.save(clienteEntity);
        return cliente;
    }

    public Cliente buscar(Integer cc) {
        ClienteEntity clienteEntity = clienteRepository.findById(cc).orElse(null);
        if (clienteEntity == null) {
            return null;
        }
        return Cliente.builder()
                .cedula(clienteEntity.getCedula())
                .nombre(clienteEntity.getNombre())
                .apellido(clienteEntity.getApellido())
                .celular(clienteEntity.getCelular())
                .email(clienteEntity.getEmail())
                .dirResidencia(clienteEntity.getDirResidencia())
                .ciudad(clienteEntity.getCiudad())
                .build();
    }

    public Cliente actualizar(Cliente cliente) {
        ClienteEntity clienteEntity = clienteRepository.findById(cliente.getCedula()).orElse(null);
        if (clienteEntity == null) {
            return null;
        }
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setApellido(cliente.getApellido());
        clienteEntity.setCelular(cliente.getCelular());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setDirResidencia(cliente.getDirResidencia());
        clienteEntity.setCiudad(cliente.getCiudad());
        clienteRepository.save(clienteEntity);
        return cliente;
    }

    public void eliminar(Integer cc) {
        ClienteEntity clienteEntity = clienteRepository.findById(cc).orElse(null);
        if (clienteEntity == null) {
            return;
        }
        clienteRepository.delete(clienteEntity);
    }

}
