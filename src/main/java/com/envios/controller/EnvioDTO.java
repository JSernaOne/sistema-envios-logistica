package com.envios.controller;

import com.envios.model.Envio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class EnvioDTO {
    private Integer cedulaCliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String dirDestino;
    private String nombreRecibe;
    private String celularRecibe;
    private double peso;
    private double valorDeclarado;
}
