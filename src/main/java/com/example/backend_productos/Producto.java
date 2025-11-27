package com.example.backend_productos;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // IMPORTANTE: Estos nombres deben coincidir con lo que espera tu App Android
    private String producto;
    private String marca;
    private Double costo;

    @Column(columnDefinition = "TEXT") // Para permitir textos largos
    private String detalle;

    // --- Constructor Vacío (Obligatorio) ---
    public Producto() {}

    // --- Getters y Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }

}
