package com.daw2.aprende04.auth.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Acceso público";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('EMPLEADO')")
  public String userAccess() {
    return "Acceso a usuarios y empleados";
  }

  @GetMapping("/empleado")
  @PreAuthorize("hasRole('EMPLEADO')")
  public String empleadoAccess() {
    return "Acceso de empleado.";
  }

  @GetMapping("/admin")
  //@PreAuthorize("hasRole('ADMIN')")
  @Secured("ROLE_ADMIN")
  public String adminAccess() {
    return "Acceso de administrador";
  }
}
