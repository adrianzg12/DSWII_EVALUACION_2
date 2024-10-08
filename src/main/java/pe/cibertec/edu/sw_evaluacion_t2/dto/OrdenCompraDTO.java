package pe.cibertec.edu.sw_evaluacion_t2.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import pe.cibertec.edu.sw_evaluacion_t2.model.Cliente;

import java.util.Date;
@Data
@Builder
public class OrdenCompraDTO {
    private Integer idOrden;
    private Date fecha;
    private Double total;
    private Cliente cliente;

}
