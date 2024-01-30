package com.daw2.aprende04.model.json;


import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Proveedor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data//equiale a los metodos get set y to string
@Slf4j
@Builder//
public class ArticuloJson {
    private Long id;
    private String referencia;
    private String nombre;
    private String descripcion;
    private double precio;
    private double iva;
    private int unidades;
    private Proveedor proveedor;

    public static ArticuloJson from(Articulo entity) {
        ModelMapper modelMapper = new ModelMapper();
        ArticuloJson json = modelMapper.map(entity, ArticuloJson.class);
        return json;
    }

    public static List<ArticuloJson> from(List<Articulo> list){
        List<ArticuloJson> listJson = new ArrayList<>();
        for (Articulo entity : list){
            listJson.add(ArticuloJson.from(entity));
        }
        return listJson;
    }

    public Articulo to(){
        ModelMapper modelMapper = new ModelMapper();
        Articulo entity = modelMapper.map(this, Articulo.class);
        return entity;
    }
}
