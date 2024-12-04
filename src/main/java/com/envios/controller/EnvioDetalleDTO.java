package com.envios.controller;

import lombok.Data;

@Data
public class EnvioDetalleDTO {

    private Integer numGuia;
    private Integer cedulaCliente;
    private String nombreCliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String dirDestino;
    private String nombreRecibe;
    private String celularRecibe;
    private double valorDeclarado;
    private double peso;
    private double valorEnvio;

    public EnvioDetalleDTO(Integer  numGuia,  String ciudadOrigen, String ciudadDestino, String dirDestino, String nombreRecibe, String celularRecibe, double valorEnvio,double valorDeclarado, double peso,  Integer cedulaCliente, String nombreCliente) {
        this.numGuia = numGuia;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.dirDestino = dirDestino;
        this.nombreRecibe = nombreRecibe;
        this.celularRecibe = celularRecibe;
        this.valorEnvio = valorEnvio;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.valorDeclarado = valorDeclarado;
        this.peso = peso;
    }

}
