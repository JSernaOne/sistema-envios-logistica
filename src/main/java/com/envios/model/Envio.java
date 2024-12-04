package com.envios.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Envio {

    private String numGuia;
    private Cliente cliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String dirDestino;
    private String nombreRecibe;
    private String celularRecibe;
    private String horaEntrega;
    private String estado;
    private double valorEnvio;
    private Paquete paquete;
    private double valorDeclarado;


    @Override
    public String toString() {
        return "Envio{" +
                "umGuia='" + numGuia + '\'' +
                ", cliente=" + cliente +
                ", ciudadOrigen='" + ciudadOrigen + '\'' +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                ", dirDestino='" + dirDestino + '\'' +
                ", nombreRecibe='" + nombreRecibe + '\'' +
                ", celularRecibe='" + celularRecibe + '\'' +
                ", horaEntrega='" + horaEntrega + '\'' +
                ", estado='" + estado + '\'' +
                ", valorEnvio=" + valorEnvio +
                ", paquete=" + paquete +
                '}';
    }

    public double calcularValorEnvio(String tipo) {
        if (tipo == null) {
            tipo = "DEFAULT";
        }
        return switch (tipo) {
            case "LIVIANO" -> 30000;
            case "MEDIANO" -> 40000;
            case "GRANDE" -> 50000;
            default -> 0;
        };
    }

}
