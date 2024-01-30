package com.daw2.aprende04.model.repository;

import com.daw2.aprende04.model.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticulosRepository extends JpaRepository<Articulo, Long> {

    Articulo findByReferencia(String referencia);
}
