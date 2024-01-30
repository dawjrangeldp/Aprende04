package com.daw2.aprende04.service;

import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Proveedor;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticulosService {
    Articulo findById(long id);
    Articulo findByReferencia(String referencia);
    List<Articulo> findAll();
    Articulo save(Articulo articulo);
    void delete(long id);

    Articulo update(long id, Articulo articulo);

    // -------------------------
    // Upload/Download Ficheros
    // -------------------------
    void saveImagen(Articulo articulo, MultipartFile fichero);

    void saveFichaTecnica(Articulo articulo, MultipartFile fichero);

    void deleteFiles(long id);

    Resource loadImagen(long id);

    Resource loadFicha(long id);
}
