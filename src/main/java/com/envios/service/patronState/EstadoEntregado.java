package com.envios.service.patronState;

import com.envios.controller.EnvioEstadoDTO;

public class EstadoEntregado implements Estado {
    @Override
    public String cambiarEstado(EnvioEstadoDTO envioEstadoDTO) {
        return "Error: El envio ya fue entregado";
    }
}
