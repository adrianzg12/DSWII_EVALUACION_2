package pe.cibertec.edu.sw_evaluacion_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.model.OrdenCompra;

import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra , Integer> {
    @Query(value = "select * from orden_compra oc" , nativeQuery = true)
    List<OrdenCompra>listAllOrdenCompra();

}
