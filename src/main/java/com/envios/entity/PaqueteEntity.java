package com.envios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "paquete")
public class PaqueteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="tipo")
    private String tipo;

    @Column(name="peso")
    private double peso;

    @Column(name="valorDeclarado")
    private double valorDeclarado;

    public PaqueteEntity(String tipo, double peso, double valorDeclarado) {
        this.tipo = tipo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

}
