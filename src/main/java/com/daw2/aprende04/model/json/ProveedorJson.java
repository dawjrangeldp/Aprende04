package com.daw2.aprende04.model.json;

import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Proveedor;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class ProveedorJson {

    private Long id;
    private String nif;
    private String razonSocial;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String imagen;
    private List<Articulo> articulos;

//    public static ProveedorJson from(Proveedor proveedor){
//        ProveedorJson json = ProveedorJson.builder()
//                .id(proveedor.getId())
//                .nif(proveedor.getNif())
//                .razonSocial(proveedor.getRazonSocial())
//                .nombre(proveedor.getNombre())
//                .apellidos(proveedor.getApellidos())
//                .telefono(proveedor.getTelefono())
//                .direccion(proveedor.getDireccion())
//                .imagen(proveedor.getImagen())
//                .articulos(proveedor.getArticulos())
//                .build();
//        return json;
 //   }
    public static ProveedorJson from(Proveedor entity) {
        ModelMapper modelMapper = new ModelMapper();
        ProveedorJson json = modelMapper.map(entity, ProveedorJson.class);
        return json;
    }

    public static List<ProveedorJson> from(List<Proveedor> list){
        List<ProveedorJson> listJson = new ArrayList<>();
        for (Proveedor entity : list){
            listJson.add(ProveedorJson.from(entity));
        }
        return listJson;
    }

    public Proveedor to(){
        ModelMapper modelMapper = new ModelMapper();
        Proveedor entity = modelMapper.map(this, Proveedor.class);
        return entity;
    }

}
