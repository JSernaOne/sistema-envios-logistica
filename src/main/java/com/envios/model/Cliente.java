package com.envios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cliente{
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String dirResidencia;
    private String ciudad;
}
