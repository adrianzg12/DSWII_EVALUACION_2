package pe.cibertec.edu.sw_evaluacion_t2.util.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ClienteDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Cliente;
import pe.cibertec.edu.sw_evaluacion_t2.repository.ClienteRepository;

@Component
public class ConvertCliente {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO convertClienteADto(Cliente cliente){
        return ClienteDTO.builder()
                .idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .email(cliente.getEmail())
                .telefono(cliente.getTelefono())
                .direccion(cliente.getDireccion())
                .pais(cliente.getPais())
                .ciudad(cliente.getCiudad())
                .build();
    }
}
