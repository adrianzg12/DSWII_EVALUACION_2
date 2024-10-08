package pe.cibertec.edu.sw_evaluacion_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ClienteDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Cliente;
import pe.cibertec.edu.sw_evaluacion_t2.model.Producto;
import pe.cibertec.edu.sw_evaluacion_t2.repository.ClienteRepository;
import pe.cibertec.edu.sw_evaluacion_t2.repository.ProductoRepository;
import pe.cibertec.edu.sw_evaluacion_t2.service.IClienteService;
import pe.cibertec.edu.sw_evaluacion_t2.util.convert.ConvertCliente;

import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class ClienteService implements IClienteService {
    private final ClienteRepository clienteRepository;
    private final ConvertCliente convertCliente;

    @Override
    public List<ClienteDTO> buscarClientesXCiudadPais(String ciudad, String pais) {
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        for (Cliente cliente : clienteRepository.buscarClientesXCiudadPais(ciudad,pais)){
            clienteDTOS.add(convertCliente.convertClienteADto(cliente));
        }
        return clienteDTOS;
    }

    @Override
    public List<ClienteDTO> ordernarClientePorNombreASC() {
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        for (Cliente cliente : clienteRepository.ordernarClientePorNombreASC()){
            clienteDTOS.add(convertCliente.convertClienteADto(cliente));
        }
        return clienteDTOS;
    }

    @Override
    public void registrarCliente(ClienteDTO clienteDTO) {
        clienteRepository.registrarCliente(
                clienteDTO.getNombre(),
                clienteDTO.getEmail(),
                clienteDTO.getTelefono(),
                clienteDTO.getDireccion(),
                clienteDTO.getPais(),
                clienteDTO.getCiudad()
        );
    }
}
