package com.daw2.aprende04;

import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Categoria;
import com.daw2.aprende04.model.entity.Proveedor;
import com.daw2.aprende04.service.ArticulosService;
import com.daw2.aprende04.service.CategoriasService;
import com.daw2.aprende04.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Aprende04Application implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ProveedoresService proveedoresService;
	@Autowired
	private ArticulosService articulosService;
	@Autowired
	private CategoriasService categoriasService;


	public static void main(String[] args) {
		SpringApplication.run(Aprende04Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		datosIniciales();;

		for (int i = 0; i < 5; i++) {
			String passBCript = passwordEncoder.encode("1234");
			System.out.println("Contraseña encriptada inicial de admin (1234): " + passBCript);
		}

	}

	public void datosIniciales(){
		//El builder es un constructor muy comodo que funciona como una inicializacion+setters
		Proveedor proveedor1 = Proveedor.builder()
				.razonSocial("Proveedor 1")
				.nombre("Pepito")
				.apellidos("Perez")
				.telefono("1111")
				.direccion("C/ Falsa 123")
				.build();
		proveedoresService.save(proveedor1);

		Categoria categoria1 = Categoria.builder()
				.referencia("MONITOR")
				.titulo("Monitores")
				.descripcion("Monitores para Pc")
				.iva(21)
				.build();
		categoriasService.save(categoria1);

		Articulo articulo = Articulo.builder()
				.nombre("Monitor Asus 27\"")
				.referencia("WWADDD23")
				.proveedor(proveedor1)
				.categoria(categoria1)
				.build();
		articulosService.save(articulo);

		articulo = Articulo.builder()
				.nombre("Monitor Xiaomi 19\"")
				.referencia("PPP300")
				.proveedor(proveedor1)
				.categoria(categoria1)
				.build();
		articulosService.save(articulo);
		articulosService.findAll().forEach(art-> System.out.println(art.getProveedor().getNombre()));
	}
}
