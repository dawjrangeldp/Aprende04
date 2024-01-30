package com.daw2.aprende04.service.impl;

import com.daw2.aprende04.model.entity.Articulo;
import com.daw2.aprende04.model.entity.Categoria;
import com.daw2.aprende04.model.repository.ArticulosRepository;
import com.daw2.aprende04.service.ArticulosService;
import com.daw2.aprende04.service.CategoriasService;
import com.daw2.aprende04.uploadFile.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ArticulosServiceImpl implements ArticulosService {
    @Autowired
    private ArticulosRepository articulosRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private CategoriasService categoriasService;

    @Transactional(readOnly = true)
    @Override
    public Articulo findById(long id) {
        return articulosRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Articulo findByReferencia(String referencia) {
        return articulosRepository.findByReferencia(referencia);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Articulo> findAll() {
        return articulosRepository.findAll();
    }

    @Transactional
    @Override
    public Articulo save(Articulo articulo) {
        return articulosRepository.save(articulo);
    }

    @Transactional
    @Override
    public void delete(long id) {
        articulosRepository.deleteById(id);
    }
    @Transactional
    @Override
    public Articulo update(long id, Articulo articulo) {
        Articulo articuloBD = articulosRepository.findById(id).get();
        if (articulo!=null) {
            articuloBD.setReferencia(articulo.getReferencia());
            articuloBD.setNombre(articulo.getNombre());
            articuloBD.setDescripcion(articulo.getDescripcion());
            articuloBD.setIva(articulo.getIva());
            articuloBD.setUnidades(articulo.getUnidades());
            articuloBD.setPrecio(articulo.getPrecio());
            articuloBD.setImagen(articulo.getImagen());
            articulosRepository.save(articuloBD);
        }
        return articuloBD;
    }



    // -------------------------
    // Upload/Download Ficheros
    // -------------------------
    @Override
    public void saveImagen(Articulo articulo, MultipartFile fichero) {
        if (!fichero.isEmpty()) {
            Categoria categoria = categoriasService.findById(articulo.getCategoria().getId());
            Map data = new HashMap() {{
                put("categoria", categoria.getReferencia());
            }};
            if (articulo.getId() != null && articulo.getId() > 0 && articulo.getImagen() != null
                    && articulo.getImagen().length() > 0) {
                uploadFileService.delete("articulos-imagenes", data, articulo.getImagen());
            }
            String uniqueFilename = null;
            try {
                uniqueFilename = uploadFileService.copy("articulos-imagenes", data, fichero);
            } catch (IOException e) {
                e.printStackTrace();
            }
            articulo.setImagen(uniqueFilename);
        }
    }

    @Override
    public void saveFichaTecnica(Articulo articulo, MultipartFile fichero) {
        if (!fichero.isEmpty()) {
            Categoria categoria = categoriasService.findById(articulo.getCategoria().getId());
            Map data = new HashMap() {{
                put("categoria", categoria.getReferencia());
            }};
            if (articulo.getId() != null && articulo.getId() > 0 && articulo.getFichaTecnica() != null
                    && articulo.getFichaTecnica().length() > 0) {
                uploadFileService.delete("articulos-fichas", data, articulo.getFichaTecnica());
            }
            String uniqueFilename = null;
            try {
                uniqueFilename = uploadFileService.copy("articulos-fichas", data, fichero);
            } catch (IOException e) {
                e.printStackTrace();
            }
            articulo.setFichaTecnica(uniqueFilename);
        }
    }

    @Override
    public void deleteFiles(long id) {
        Articulo articuloBD = findById(id);
        Map data = new HashMap() {{
            put("categoria", articuloBD.getCategoria().getReferencia());
        }};
        String imagen = articuloBD.getImagen();
        String ficha= articuloBD.getFichaTecnica();
        if (imagen!=null)
            uploadFileService.delete("articulos-imagenes",data,imagen);
        if (ficha!=null)
            uploadFileService.delete("articulos-fichas",data,ficha);
    }

    @Override
    public Resource loadImagen(long id) {
        Resource recurso = null;
        Articulo articulo  = findById(id);
        try {
            Map data = new HashMap() {{
                put("categoria", articulo.getCategoria().getReferencia());
            }};
            String filename = articulo.getImagen();
            recurso = uploadFileService.load("articulos-imagenes", data, filename);
            return recurso;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Resource loadFicha(long id) {
        Resource recurso = null;
        Articulo articulo  = findById(id);
        try {
            Map data = new HashMap() {{
                put("categoria", articulo.getCategoria().getReferencia());
            }};
            String filename = articulo.getFichaTecnica();
            recurso = uploadFileService.load("articulos-fichas", data, filename);
            return recurso;
        } catch (Exception e) {
            return null;
        }
    }
}
