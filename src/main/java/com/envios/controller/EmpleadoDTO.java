package com.envios.controller;

import com.envios.model.Empleado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class EmpleadoDTO {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String dirResidencia;
    private String ciudad;
    private double antiguedad;
    private String rhSangre;
    private String tipo;

    public Empleado toEntity() {
        return Empleado.builder()
                .cedula(this.cedula)
                .nombre(this.nombre)
                .apellido(this.apellido)
                .celular(this.celular)
                .email(this.email)
                .dirResidencia(this.dirResidencia)
                .ciudad(this.ciudad)
                .antiguedad(this.antiguedad)
                .rhSangre(this.rhSangre)
                .tipo(this.tipo)
                .build();
    }
}
