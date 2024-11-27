package com.envios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cliente")
public class ClienteEntity {
    @Id
//    @Column(name = "cedula")
    private Integer cedula;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="celular")
    private String celular;

    @Column(name="email")
    private String email;

    @Column(name="dirResidencia")
    private String dirResidencia;

    @Column(name="ciudad")
    private String ciudad;


}