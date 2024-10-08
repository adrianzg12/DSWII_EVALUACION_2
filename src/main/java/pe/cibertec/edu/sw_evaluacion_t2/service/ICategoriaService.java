package pe.cibertec.edu.sw_evaluacion_t2.service;

import pe.cibertec.edu.sw_evaluacion_t2.dto.CategoriaDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaDTO>findByNombre(String nombre);
    List<CategoriaDTO>findyByDescripcion(String descipcion);
    List<Categoria> listAllCategoria();



    void registrarCategoria(CategoriaDTO categoriaDTO);
}
