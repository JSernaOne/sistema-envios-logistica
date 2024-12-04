package com.envios.service.patronState;

import com.envios.controller.EnvioEstadoDTO;
import com.envios.service.EstadoEnvio;

public class EstadoRecibido implements Estado {
    @Override
    public String cambiarEstado(EnvioEstadoDTO envioEstadoDTO) {
        envioEstadoDTO.setEstado(new EstadoEnRuta());
        return EstadoEnvio.EN_RUTA.getEstado();
    }
}
