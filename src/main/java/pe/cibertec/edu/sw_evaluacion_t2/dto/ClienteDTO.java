package pe.cibertec.edu.sw_evaluacion_t2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {
    private Integer idCliente;
    private String nombre;
    private String email;
    private String telefono;

    private String direccion;
    private String pais;

    private String ciudad;
}
