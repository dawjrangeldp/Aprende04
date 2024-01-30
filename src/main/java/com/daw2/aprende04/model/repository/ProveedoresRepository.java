package com.daw2.aprende04.model.repository;

import com.daw2.aprende04.model.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedoresRepository extends JpaRepository<Proveedor, Long> {
}
