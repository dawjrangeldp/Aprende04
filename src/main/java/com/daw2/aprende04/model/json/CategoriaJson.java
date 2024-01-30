package com.daw2.aprende04.model.json;

import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Categoria;
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
public class CategoriaJson {

    private Long id;
    private String referencia;
    private String titulo;
    private String descripcion;
    private double iva;
    private String imagen;
    private List<Articulo> articulos;

    public static CategoriaJson from(Categoria entity) {
        ModelMapper modelMapper = new ModelMapper();
        CategoriaJson json = modelMapper.map(entity, CategoriaJson.class);
        return json;
    }

    public static List<CategoriaJson> from(List<Categoria> list){
        List<CategoriaJson> listJson = new ArrayList<>();
        for (Categoria entity : list){
            listJson.add(CategoriaJson.from(entity));
        }
        return listJson;
    }

    public Categoria to(){
        ModelMapper modelMapper = new ModelMapper();
        Categoria entity = modelMapper.map(this, Categoria.class);
        return entity;
    }
}
