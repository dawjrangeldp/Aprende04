package com.daw2.aprende04.auth.repository;

import com.daw2.aprende04.auth.models.Role;
import com.daw2.aprende04.auth.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleEnum name);
}
