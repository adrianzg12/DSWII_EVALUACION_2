package pe.cibertec.edu.sw_evaluacion_t2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.model.Categoria;
import pe.cibertec.edu.sw_evaluacion_t2.model.Producto;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Integer> {
    List<Categoria>findByNombre(String nombre);
    List<Categoria>findByDescripcion(String descipcion);

    @Transactional
    @Modifying
    @Procedure(procedureName = "GenerateAndInsertCategory")
    void registrarCategoria(
            @Param("nombre") String nombre,
            @Param("descripcion") String descripcion);

}
