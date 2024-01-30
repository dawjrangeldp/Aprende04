package com.daw2.aprende04.service.impl;

import com.daw2.aprende04.model.entity.Proveedor;
import com.daw2.aprende04.model.repository.ProveedoresRepository;
import com.daw2.aprende04.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    @Transactional(readOnly = true)
    @Override
    public Proveedor findById(long id) {
        return proveedoresRepository.findById(id).orElse(null);
        //return proveedoresRepository.findById(id).get();  Da error si no existe proveedor
    }

    @Transactional(readOnly = true)
    @Override
    public List<Proveedor> findAll() {
        return proveedoresRepository.findAll();
    }

    @Transactional
    @Override
    public Proveedor save(Proveedor proveedor) {
        proveedoresRepository.save(proveedor);
        proveedor.setApellidos("asdasda");
        return proveedor;
    }
}
