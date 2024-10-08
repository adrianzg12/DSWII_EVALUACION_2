package pe.cibertec.edu.sw_evaluacion_t2.util.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.edu.sw_evaluacion_t2.dto.OrdenCompraDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.OrdenCompra;
import pe.cibertec.edu.sw_evaluacion_t2.repository.OrdenCompraRepository;

@Component
public class ConvertOrdenCompra {
    @Autowired
    private  OrdenCompraRepository ordenCompraRepository;
     public OrdenCompraDTO convertOrdenCompraDto(OrdenCompra ordenCompra){
         return OrdenCompraDTO.builder()
                 .idOrden(ordenCompra.getIdOrden())
                 .fecha(ordenCompra.getFecha())
                 .total(ordenCompra.getTotal())
                 .cliente(ordenCompra.getCliente()).build();
     }

}
