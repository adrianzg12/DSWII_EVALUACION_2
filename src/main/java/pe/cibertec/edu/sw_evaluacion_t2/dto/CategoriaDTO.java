package pe.cibertec.edu.sw_evaluacion_t2.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaDTO {
    private Integer idcategoria;
    private String nombre;
    private String descripcion;

}
