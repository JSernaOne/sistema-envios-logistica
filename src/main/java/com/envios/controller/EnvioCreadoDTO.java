package com.envios.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvioCreadoDTO {
    private Integer numGuia;
    private  String estado;
    private Integer cedulaEmpleado;

    public EnvioCreadoDTO(Integer numGuia, String estado) {
        this.numGuia = numGuia;
        this.estado = estado;
    }
}
