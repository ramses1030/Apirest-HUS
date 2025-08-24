package com.example.apisrest_hus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "cantidad")
    private int cantidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_producto")
    private Estado_Producto estadoProducto;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "calificacion")
    private int calificacion;


}