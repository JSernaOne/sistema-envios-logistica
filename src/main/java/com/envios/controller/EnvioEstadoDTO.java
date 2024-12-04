package com.envios.controller;



import com.envios.service.patronState.Estado;
import com.envios.service.patronState.EstadoRecibido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class EnvioEstadoDTO {
    private static final String ESTADO_INICIAL = "RECIBIDO";
    private Estado estado;

    public EnvioEstadoDTO() {
        this.estado = new EstadoRecibido();
    }


    public String cambiarEstado(){
        return estado.cambiarEstado(this);
    }


    public String getEstadoInicial() {
        //  return  EstadoEnvio.RECIBIDO.getEstado();
        return ESTADO_INICIAL;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
