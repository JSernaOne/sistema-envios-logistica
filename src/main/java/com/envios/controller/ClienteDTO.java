package com.envios.controller;

import com.envios.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClienteDTO {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String dirResidencia;
    private String ciudad;

    public Cliente toEntity() {
        return Cliente.builder()
                .cedula(this.cedula)
                .nombre(this.nombre)
                .apellido(this.apellido)
                .celular(this.celular)
                .email(this.email)
                .dirResidencia(this.dirResidencia)
                .ciudad(this.ciudad)
                .build();
    }
}
