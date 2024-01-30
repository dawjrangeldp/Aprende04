package com.daw2.aprende04.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data//equiale a los metodos get set y to string
@Slf4j
@Builder//
@Entity
@Table(name = "proveedores")
public class Proveedor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nif;

    @Column(name = "razon_social")
    private String razonSocial;

    private String nombre;

    private String apellidos;

    private String telefono;

    private String direccion;

    private String imagen;

    //@JsonIgnore//indicamos que esto no sera ignorado por JSON
    @JsonBackReference
    @OneToMany(mappedBy = "proveedor")
    private List<Articulo> articulos;
}
