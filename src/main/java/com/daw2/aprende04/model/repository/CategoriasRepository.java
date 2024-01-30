package com.daw2.aprende04.model.repository;

import com.daw2.aprende04.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
    Categoria findByReferencia(String referencia);
}
