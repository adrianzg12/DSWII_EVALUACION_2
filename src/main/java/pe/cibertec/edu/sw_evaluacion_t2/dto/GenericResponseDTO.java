package pe.cibertec.edu.sw_evaluacion_t2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericResponseDTO<T>{
    private boolean correcto;
    private String mensaje;
    private T respuesta;
    private String codigoError;
}
