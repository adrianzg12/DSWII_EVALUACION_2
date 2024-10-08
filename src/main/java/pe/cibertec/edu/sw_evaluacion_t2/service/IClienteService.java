package pe.cibertec.edu.sw_evaluacion_t2.service;

import org.springframework.data.repository.query.Param;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ClienteDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Cliente;

import java.util.List;

public interface IClienteService {
    List<ClienteDTO> buscarClientesXCiudadPais(
            @Param("ciudad") String ciudad,
            @Param("pais") String pais);
    List<ClienteDTO> ordernarClientePorNombreASC();

    void registrarCliente(ClienteDTO clienteDTO);
}
