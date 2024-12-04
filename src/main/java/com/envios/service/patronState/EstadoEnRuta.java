package com.envios.service.patronState;

import com.envios.controller.EnvioEstadoDTO;
import com.envios.service.EstadoEnvio;

public class EstadoEnRuta implements Estado {
    @Override
    public String cambiarEstado(EnvioEstadoDTO envioEstadoDTO) {
        envioEstadoDTO.setEstado(new EstadoEntregado());
        return EstadoEnvio.ENTREGADO.getEstado();
    }
}
