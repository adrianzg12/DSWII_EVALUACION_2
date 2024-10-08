package pe.cibertec.edu.sw_evaluacion_t2.util.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Categoria;
import pe.cibertec.edu.sw_evaluacion_t2.model.Producto;
import pe.cibertec.edu.sw_evaluacion_t2.repository.ProductoRepository;

@Component
public class ConvertProducto {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoDTO convertirProductoADto(Producto producto) {
        return ProductoDTO.builder()
                .idproducto(producto.getIdproducto())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .descripcion(producto.getDescripcion())
                .categoria(producto.getCategoria())
                .build();
    }

    public Producto convertirDtoAProducto(ProductoDTO productoDTO) {

        Producto producto = new Producto();


        producto.setIdproducto(productoDTO.getIdproducto());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setDescripcion(productoDTO.getDescripcion());

        Categoria categoria = new Categoria();
        categoria.setIdcategoria(productoDTO.getCategoria().getIdcategoria());
        producto.setCategoria(categoria);

        return producto;
    }
}
