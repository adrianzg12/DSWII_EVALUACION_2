package pe.cibertec.edu.sw_evaluacion_t2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.model.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Integer> {
    @Query(value = "SELECT c FROM Cliente c WHERE c.ciudad=:ciudad " +
            "and c.pais=:pais")
    List<Cliente> buscarClientesXCiudadPais(
            @Param("ciudad") String ciudad,
            @Param("pais") String pais);

    @Query("SELECT c FROM Cliente c ORDER BY c.nombre ASC")
    List<Cliente> ordernarClientePorNombreASC();
    @Transactional
    @Modifying
    @Procedure(procedureName = "GenerateAndInsertClient")
    void registrarCliente(
            @Param("nombre") String nombre,
            @Param("email") String email,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("pais") String pais,
            @Param("ciudad") String ciudad);
}
