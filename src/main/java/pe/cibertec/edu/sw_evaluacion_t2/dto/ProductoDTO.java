package pe.cibertec.edu.sw_evaluacion_t2.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import pe.cibertec.edu.sw_evaluacion_t2.model.Categoria;

@Data
@Builder
public class ProductoDTO {

    private Integer idproducto;
    private String nombre;
    private Double precio;
    private Integer stock;
    private String descripcion;
    private Categoria categoria;
}
