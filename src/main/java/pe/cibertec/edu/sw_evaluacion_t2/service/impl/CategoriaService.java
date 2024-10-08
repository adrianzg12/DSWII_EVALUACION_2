package pe.cibertec.edu.sw_evaluacion_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.dto.CategoriaDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Categoria;
import pe.cibertec.edu.sw_evaluacion_t2.repository.CategoriaRepository;
import pe.cibertec.edu.sw_evaluacion_t2.service.ICategoriaService;
import pe.cibertec.edu.sw_evaluacion_t2.util.convert.ConvertCategoria;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoriaService implements ICategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final ConvertCategoria convertCategoria;


    @Override
    public List<CategoriaDTO> findByNombre(String nombre) {
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();
        for (Categoria categoria : categoriaRepository.findByNombre(nombre)){
            categoriaDTOS.add(convertCategoria.convertirCategoriaADTO(categoria));
        }
        return categoriaDTOS;
    }

    @Override
    public List<CategoriaDTO> findyByDescripcion(String descipcion) {
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();
        for (Categoria categoria : categoriaRepository.findByDescripcion(descipcion)){
            categoriaDTOS.add(convertCategoria.convertirCategoriaADTO(categoria));
        }
        return categoriaDTOS;
    }

    @Override
    public List<Categoria> listAllCategoria() {
        return categoriaRepository.findAll();
    }


    @Override
    public void registrarCategoria(CategoriaDTO categoriaDTO) {
            categoriaRepository.registrarCategoria(categoriaDTO.getNombre(),categoriaDTO.getDescripcion());
    }
}
