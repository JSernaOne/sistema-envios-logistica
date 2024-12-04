package com.envios.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Paquete {

    private Integer id;
    private String tipo;
    private double peso;
    private double valorDeclarado;

    public Paquete(double peso, double valorDeclarado) {
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tipo = asignarTipoPaquete(peso);
    }

    @Override
    public String toString() {
        return "Paquete{" +
                ",  tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", valorDeclarado=" + valorDeclarado +
                '}';
    }

    public String asignarTipoPaquete (Double peso){
        if(peso < 2.0){
            return "LIVIANO";
        }else if( peso > 5){
            return "GRANDE";
        }else {
            return "MEDIANO";
        }
    }
}
