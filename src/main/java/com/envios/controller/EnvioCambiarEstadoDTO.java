package com.envios.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvioCambiarEstadoDTO {
    private Integer numGuia;
    private  String estado;
    private Integer cedulaEmpleado;
}
