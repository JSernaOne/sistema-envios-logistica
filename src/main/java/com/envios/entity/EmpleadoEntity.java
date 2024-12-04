package com.envios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "empleado")
public class EmpleadoEntity {
    @Id
    @Column(name = "cedula")
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

    @Column (name="antiguedad")
    private double antiguedad;

    @Column(name="rhSangre")
    private String rhSangre;

    @Column(name="tipo")
    private String tipo;
}
