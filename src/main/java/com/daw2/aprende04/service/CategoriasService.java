package com.daw2.aprende04.service;

import com.daw2.aprende04.model.entity.Categoria;

import java.util.List;

public interface CategoriasService {
    Categoria findById(long id);
    List<Categoria> findAll();
    Categoria save(Categoria categoria);
}
