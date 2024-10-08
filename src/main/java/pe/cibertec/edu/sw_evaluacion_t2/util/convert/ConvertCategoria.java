package pe.cibertec.edu.sw_evaluacion_t2.util.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.edu.sw_evaluacion_t2.dto.CategoriaDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Categoria;
import pe.cibertec.edu.sw_evaluacion_t2.repository.CategoriaRepository;

@Component
public class ConvertCategoria {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO convertirCategoriaADTO(Categoria categoria){
        return CategoriaDTO.builder().idcategoria(categoria.getIdcategoria())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build();
    }
}
