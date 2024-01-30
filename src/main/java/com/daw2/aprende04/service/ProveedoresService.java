package com.daw2.aprende04.service;

import com.daw2.aprende04.model.entity.Proveedor;

import java.util.List;

public interface ProveedoresService {
    Proveedor findById(long id);
    List<Proveedor> findAll();
    Proveedor save(Proveedor proveedor);
}
