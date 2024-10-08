package pe.cibertec.edu.sw_evaluacion_t2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto , Integer> {
    List<Producto> findByNombre(String nombre);
    List<Producto> findByStockBetween(Integer stockInicial , Integer stockFinal);

    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :idCategoria")
    List<Producto> buscarProductosPorCategoria(@Param("idCategoria") Integer idCategoria);

    @Query("SELECT p FROM Producto p WHERE p.precio = :precio")
    List<Producto> buscarProductoPorPrecio(@Param("precio") Double precio);

    @Transactional
    @Modifying
    @Procedure(procedureName = "GenerateAndInsertProducts")
    void registrarProducto(
            @Param("nombre") String nombre,
            @Param("precio") Double precio,
            @Param("stock") Integer stock,
            @Param("descripcion") String descripcion,
            @Param("idcategoria") Integer idcategoria);


}
