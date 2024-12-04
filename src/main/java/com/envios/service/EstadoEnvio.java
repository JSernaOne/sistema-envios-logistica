package com.envios.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoEnvio {
    ENTREGADO("ENTREGADO"),
    EN_RUTA("EN_RUTA"),
    RECIBIDO("RECIBIDO");

    private String estado;

}
