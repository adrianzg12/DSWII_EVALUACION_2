package pe.cibertec.edu.sw_evaluacion_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.dto.OrdenCompraDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.OrdenCompra;
import pe.cibertec.edu.sw_evaluacion_t2.model.Producto;
import pe.cibertec.edu.sw_evaluacion_t2.repository.OrdenCompraRepository;
import pe.cibertec.edu.sw_evaluacion_t2.service.IOrdenCompraService;
import pe.cibertec.edu.sw_evaluacion_t2.util.convert.ConvertOrdenCompra;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrdenCompraService implements IOrdenCompraService {
    private final OrdenCompraRepository ordenCompraRepository;
    private final ConvertOrdenCompra convertOrdenCompra;


    @Override
    public List<OrdenCompraDTO> listAllOrdenCompra() {
        List<OrdenCompraDTO> ordenCompraDTOS = new ArrayList<>();
        for (OrdenCompra ordenCompra : ordenCompraRepository.listAllOrdenCompra()){
            ordenCompraDTOS.add(convertOrdenCompra.convertOrdenCompraDto(ordenCompra));
        }
        return ordenCompraDTOS;
    }
}
