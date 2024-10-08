package pe.cibertec.edu.sw_evaluacion_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Producto;
import pe.cibertec.edu.sw_evaluacion_t2.repository.CategoriaRepository;
import pe.cibertec.edu.sw_evaluacion_t2.repository.ProductoRepository;
import pe.cibertec.edu.sw_evaluacion_t2.service.IProductoService;
import pe.cibertec.edu.sw_evaluacion_t2.util.convert.ConvertProducto;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Repository
public class ProductoService implements IProductoService {
    private final ProductoRepository productoRepository;
    private final ConvertProducto convertProducto;

    @Override
    public List<ProductoDTO> findByNombre(String nombre) {
        List<ProductoDTO> productoDTOS = new ArrayList<>();
        for (Producto producto : productoRepository.findByNombre(nombre)){
            productoDTOS.add(convertProducto.convertirProductoADto(producto));
        }
        return productoDTOS;
    }

    @Override
    public List<ProductoDTO> findByStockBetween(Integer stockInicial, Integer stockFinal) {
        List<ProductoDTO> productoDTOS = new ArrayList<>();
        for (Producto producto : productoRepository.findByStockBetween(stockInicial,stockFinal)){
            productoDTOS.add(convertProducto.convertirProductoADto(producto));
        }
        return productoDTOS;
    }

    @Override
    public List<ProductoDTO> buscarProductosPorCategoria(Integer idCategoria) {
        List<ProductoDTO> productoDTOS = new ArrayList<>();
        for (Producto producto : productoRepository.buscarProductosPorCategoria(idCategoria)){
            productoDTOS.add(convertProducto.convertirProductoADto(producto));
        }
        return productoDTOS;
    }

    @Override
    public List<ProductoDTO> buscarProductoPorPrecio(Double precio) {
        List<ProductoDTO> productoDTOS = new ArrayList<>();
        for (Producto producto : productoRepository.buscarProductoPorPrecio(precio)){
            productoDTOS.add(convertProducto.convertirProductoADto(producto));
        }
        return productoDTOS;
    }

    @Override
    public void registrarProducto(ProductoDTO productoDTO) {
        productoRepository.registrarProducto(productoDTO.getNombre(),
                productoDTO.getPrecio() , productoDTO.getStock() ,
                productoDTO.getDescripcion() ,
                productoDTO.getCategoria().getIdcategoria());
    }


}
