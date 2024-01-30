package com.daw2.aprende04.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data//equiale a los metodos get set y to string
@Slf4j
@Builder//
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referencia;

    private String nombre;

    private String descripcion;

    private double precio;

    private double iva;

    private int unidades;

    @Column(length = 200)
    private String imagen;

    @Column(name = "ficha_tecnica", length = 200)
    private String fichaTecnica;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
