package com.daw2.aprende04.api;

import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Proveedor;
import com.daw2.aprende04.model.json.ProveedorJson;
import com.daw2.aprende04.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")//Se usa cuando las peticiones vienen de otra ip u otro puerto(ej. cuando usamos angular)
@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresRestController {
    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping("")
    public List<Proveedor> getAll(){
        List<Proveedor> proveedores = proveedoresService.findAll();
        return proveedores;
    }

    @GetMapping("/v2")
    public List<ProveedorJson> getAllV2(){
        List<Proveedor> proveedores = proveedoresService.findAll();
        List<ProveedorJson> proveedoresJson = new ArrayList<>();
        for (Proveedor proveedor: proveedores){
           ProveedorJson json = ProveedorJson.builder()
                   .nif(proveedor.getNif())
                   .nombre(proveedor.getNombre())
                   .build();
           proveedoresJson.add(json);
        }
        return proveedoresJson;
    }
}
