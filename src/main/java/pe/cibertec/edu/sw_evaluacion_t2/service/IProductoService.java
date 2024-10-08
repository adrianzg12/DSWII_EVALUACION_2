package pe.cibertec.edu.sw_evaluacion_t2.service;

import org.springframework.data.repository.query.Param;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Producto;


import java.util.List;

public interface IProductoService {
    List<ProductoDTO> findByNombre(String nombre);
    List<ProductoDTO> findByStockBetween(Integer stockInicial , Integer stockFinal);
    List<ProductoDTO> buscarProductosPorCategoria(@Param("idCategoria") Integer idCategoria);
    List<ProductoDTO> buscarProductoPorPrecio(@Param("precio") Double precio);

    void registrarProducto(ProductoDTO productoDTO);


}
