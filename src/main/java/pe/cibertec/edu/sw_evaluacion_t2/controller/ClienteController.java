package pe.cibertec.edu.sw_evaluacion_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ClienteDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.GenericResponseDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.service.impl.ClienteService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {
    private final ClienteService clienteService;
    @GetMapping("/ciudad-pais")
    public ResponseEntity<GenericResponseDTO<List<ClienteDTO>>> listarProductosPorCiudadPais(@RequestParam("ciudad") String ciudad , @RequestParam("pais") String pais) {
        List<ClienteDTO> clienteDTOList = clienteService.buscarClientesXCiudadPais(ciudad,pais);

        if (clienteDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<ClienteDTO>>builder()
                    .correcto(false)
                    .mensaje("No se han encontrado Clientes con la Ciudad "+ ciudad + "y Pais "+ pais)
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<ClienteDTO>>builder()
                    .correcto(true)
                    .mensaje("Clientes  encontrados con la Ciudad " + ciudad + " y el Pais "+ pais)
                    .respuesta(clienteDTOList)
                    .build(), HttpStatus.OK);
        }
    }

    @GetMapping("/nombre-asc")
    public ResponseEntity<GenericResponseDTO<List<ClienteDTO>>> odenarNombreASC() {
        List<ClienteDTO> clienteDTOList = clienteService.ordernarClientePorNombreASC();

        if (clienteDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<ClienteDTO>>builder()
                    .correcto(false)
                    .mensaje("No se han encontrado Clientes")
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<ClienteDTO>>builder()
                    .correcto(true)
                    .mensaje("Clientes  Ordenados Correctamente ")
                    .respuesta(clienteDTOList)
                    .build(), HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDTO<String>> registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {

            clienteService.registrarCliente(clienteDTO);

            return new ResponseEntity<>(GenericResponseDTO.<String>builder()
                    .correcto(true)
                    .mensaje("Cliente Registrado Correctamente")
                    .build(), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(GenericResponseDTO.<String>builder()
                    .correcto(false)
                    .mensaje("Cliente NO Registrado: " + exception.getMessage())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
