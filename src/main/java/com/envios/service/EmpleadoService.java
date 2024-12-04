package com.envios.service;

import com.envios.controller.EmpleadoDTO;
import com.envios.entity.EmpleadoEntity;
import com.envios.model.Empleado;
import com.envios.repository.EmpleadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public Empleado crear(Empleado empleado) {
        if (empleado == null) {
            System.out.println("El empleado no puede ser nulo");
        }
        if (empleado.getCedula() == null || empleado.getApellido() == null || empleado.getNombre() == null) {
            System.out.println("la cedula, el apellido o el nombre son invalidos");
        }
        EmpleadoEntity empleadoEntity = new EmpleadoEntity(
                empleado.getCedula(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getCelular(),
                empleado.getEmail(),
                empleado.getDirResidencia(),
                empleado.getCiudad(),
                empleado.getAntiguedad(),
                empleado.getRhSangre(),
                empleado.getTipo()
        );
        empleadoRepository.save(empleadoEntity);
        return empleado;
    }

    public Empleado buscar(Integer cc) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(cc).orElse(null);
        if (empleadoEntity == null) {
            return null;
        }
        return Empleado.builder()
                .cedula(empleadoEntity.getCedula())
                .nombre(empleadoEntity.getNombre())
                .apellido(empleadoEntity.getApellido())
                .celular(empleadoEntity.getCelular())
                .email(empleadoEntity.getEmail())
                .dirResidencia(empleadoEntity.getDirResidencia())
                .ciudad(empleadoEntity.getCiudad())
                .antiguedad(empleadoEntity.getAntiguedad())
                .rhSangre(empleadoEntity.getRhSangre())
                .tipo(empleadoEntity.getTipo())
                .build();
    }

    public List<Empleado> listar() {
        List<EmpleadoEntity> empleadoEntities = empleadoRepository.findAll();
        List<Empleado> empleados = new ArrayList<>();
        for (EmpleadoEntity empleadoEntity : empleadoEntities) {
            empleados.add(Empleado.builder()
                    .cedula(empleadoEntity.getCedula())
                    .nombre(empleadoEntity.getNombre())
                    .apellido(empleadoEntity.getApellido())
                    .celular(empleadoEntity.getCelular())
                    .email(empleadoEntity.getEmail())
                    .dirResidencia(empleadoEntity.getDirResidencia())
                    .ciudad(empleadoEntity.getCiudad())
                    .antiguedad(empleadoEntity.getAntiguedad())
                    .rhSangre(empleadoEntity.getRhSangre())
                    .tipo(empleadoEntity.getTipo())
                    .build());
        }
        return empleados;
    }

    public Empleado actualizar(Integer cedula, EmpleadoDTO empleadoActualizado){
        if(cedula == null){
            return null;
        }

        Optional<EmpleadoEntity> empleadoActual = empleadoRepository.findById(cedula);

        if(!empleadoActual.isPresent()){
            return null;
        }

        EmpleadoEntity empleado = empleadoActual.get();
        empleadoActual.get().setAntiguedad(empleadoActualizado.getAntiguedad());
        empleadoActual.get().setApellido(empleadoActualizado.getApellido());
        empleadoActual.get().setCelular(empleadoActualizado.getCelular());
        empleadoActual.get().setCiudad(empleadoActualizado.getCiudad());
        empleadoActual.get().setEmail(empleadoActualizado.getEmail());
        empleadoActual.get().setDirResidencia(empleadoActualizado.getDirResidencia());
        empleadoActual.get().setNombre(empleadoActualizado.getNombre());
        empleadoActual.get().setRhSangre(empleadoActualizado.getRhSangre());
        empleadoActual.get().setTipo(empleadoActualizado.getTipo());

        empleadoRepository.save(empleado);

        return new EmpleadoDTO(
                empleadoActual.get().getCedula(),
                empleadoActual.get().getNombre(),
                empleadoActual.get().getApellido(),
                empleadoActual.get().getCelular(),
                empleadoActual.get().getEmail(),
                empleadoActual.get().getDirResidencia(),
                empleadoActual.get().getCiudad(),
                empleadoActual.get().getAntiguedad(),
                empleadoActual.get().getRhSangre(),
                empleadoActual.get().getTipo()).toEntity();

    }

    public void eliminar(Integer cc) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(cc).orElse(null);
        if (empleadoEntity == null) {
            return;
        }
        empleadoRepository.delete(empleadoEntity);
    }
}
