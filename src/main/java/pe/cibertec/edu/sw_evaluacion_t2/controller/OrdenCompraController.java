package pe.cibertec.edu.sw_evaluacion_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ClienteDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.GenericResponseDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.OrdenCompraDTO;
import pe.cibertec.edu.sw_evaluacion_t2.service.impl.OrdenCompraService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/orden-compra")
public class OrdenCompraController {
    private final OrdenCompraService ordenCompraService;

    @GetMapping("")
    public ResponseEntity<GenericResponseDTO<List<OrdenCompraDTO>>> listarOrdenesDeCompra() {
        List<OrdenCompraDTO> ordenCompraDTOList = ordenCompraService.listAllOrdenCompra();

        if (ordenCompraDTOList.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDTO.<List<OrdenCompraDTO>>builder()
                    .correcto(false)
                    .mensaje("No se han encontrado Ordenes de Compra ")
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<OrdenCompraDTO>>builder()
                    .correcto(true)
                    .mensaje("Ordenes de Compra encontrados")
                    .respuesta(ordenCompraDTOList)
                    .build(), HttpStatus.OK);
        }
    }
}
