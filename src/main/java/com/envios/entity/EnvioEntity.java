package com.envios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "envio")
public class EnvioEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numGuia;

    @Column(name = "ciudadOrigen")
    private String ciudadOrigen;
    @Column(name = "ciudadDestino")
    private String ciudadDestino;
    @Column(name = "dirDestino")
    private String dirDestino;
    @Column(name = "nombreRecibe")
    private String nombreRecibe;
    @Column(name = "celularRecibe")
    private String celularRecibe;
    @Column(name = "horaEntrega")
    private String horaEntrega;
    @Column(name = "estado")
    private String estado;
    @Column(name = "valorEnvio")
    private double valorEnvio;

    @OneToOne
    @JoinColumn(name = "cliente")
    private ClienteEntity cliente;

    @OneToOne
    @JoinColumn(name = "paquete")
    private PaqueteEntity paquete;

    public EnvioEntity(String ciudadOrigen, String ciudadDestino, String dirDestino, String nombreRecibe, String celularRecibe, String horaEntrega, String estado, double valorEnvio, ClienteEntity cliente, PaqueteEntity paquete) {

        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.dirDestino = dirDestino;
        this.nombreRecibe = nombreRecibe;
        this.celularRecibe = celularRecibe;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.valorEnvio = valorEnvio;
        this.cliente = cliente;
        this.paquete = paquete;

    }
}


