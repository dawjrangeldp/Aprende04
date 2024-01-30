package com.daw2.aprende04.service.impl;

import com.daw2.aprende04.model.entity.Categoria;
import com.daw2.aprende04.model.repository.CategoriasRepository;
import com.daw2.aprende04.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriasServiceImpl implements CategoriasService {
    @Autowired
    private CategoriasRepository categoriasRepository;
    @Transactional(readOnly = true)
    @Override
    public Categoria findById(long id) {
        return categoriasRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Categoria> findAll() {
        return categoriasRepository.findAll();
    }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return categoriasRepository.save(categoria);
    }
}
