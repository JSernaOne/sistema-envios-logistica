package com.envios.controller;

import com.envios.model.Paquete;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PaqueteDTO {

    private Integer id;
    private String tipo;
    private double peso;
    private double valorDeclarado;

    public Paquete toEntity() {
        return Paquete.builder()
                .id(this.id)
                .tipo(this.tipo)
                .peso(this.peso)
                .valorDeclarado(this.valorDeclarado)
                .build();
    }
}
