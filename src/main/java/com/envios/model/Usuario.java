package com.envios.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Usuario {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String dirResidencia;
    private String ciudad;
}
