package com.envios.service.patronState;

import com.envios.controller.EnvioEstadoDTO;

public interface Estado {
    String cambiarEstado(EnvioEstadoDTO envioEstadoDTO);
}
