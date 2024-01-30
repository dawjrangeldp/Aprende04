package com.daw2.aprende04.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data//equiale a los metodos get set y to string
@Slf4j
@Builder//
@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 25)
    private String referencia;

    @Column(nullable = false, unique = true,length = 100)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column
    private double iva;

    @Column(length = 200)
    private String imagen;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Articulo> articulos;
}
