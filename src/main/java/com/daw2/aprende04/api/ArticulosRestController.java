package com.daw2.aprende04.api;

import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Proveedor;
import com.daw2.aprende04.service.ArticulosService;
import com.daw2.aprende04.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")//Se usa cuando las peticiones vienen de otra ip u otro puerto(ej. cuando usamos angular)
@RestController
@RequestMapping("/api/articulos")
public class ArticulosRestController {
    @Autowired
    private ArticulosService articulosService;

    @GetMapping("")
    public List<Articulo> getAll(){
        List<Articulo> articulos = articulosService.findAll();
        return articulos;
    }

    @PostMapping("")
    public ResponseEntity<?> save(Articulo articulo
    , @RequestParam("file_imagen")MultipartFile imagen
    , @RequestParam("file_ficha_tecnica") MultipartFile ficha) {
        try{
            articulosService.save(articulo);
            articulosService.saveImagen(articulo, imagen);
            articulosService.saveFichaTecnica(articulo, ficha);
            articulosService.save(articulo);
            return new ResponseEntity<>(articulo, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("articulo no guardado", HttpStatus.BAD_REQUEST);
        }
    }
}
