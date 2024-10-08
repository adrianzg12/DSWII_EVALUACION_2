package pe.cibertec.edu.sw_evaluacion_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.sw_evaluacion_t2.dto.GenericResponseDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.service.impl.ProductoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {
    private final ProductoService productoService;
    @GetMapping("/nombre")
    public ResponseEntity<GenericResponseDTO<List<ProductoDTO>>> listarProductosPorNombre(@RequestParam("nombre") String nombre) {
        List<ProductoDTO> productoDTOList = productoService.findByNombre(nombre);

        if (productoDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(false)
                    .mensaje("No se han encontrado productos con el nombre: " + nombre)
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(true)
                    .mensaje("Productos encontrados con el nombre: " + nombre)
                    .respuesta(productoDTOList)
                    .build(), HttpStatus.OK);
        }
    }
    @GetMapping("/stock")
    public ResponseEntity<GenericResponseDTO<List<ProductoDTO>>> listarProductosPorStock(@RequestParam("stockInicial") Integer stockInicial , @RequestParam("stockFinal") Integer stockFinal) {
        List<ProductoDTO> productoDTOList = productoService.findByStockBetween(stockInicial,stockFinal);

        if (productoDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(false)
                    .mensaje("No se han encontrado stocks con esas cantidades ")
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(true)
                    .mensaje("Productos encontrados con el stock " + stockInicial +" y " +  stockFinal)
                    .respuesta(productoDTOList)
                    .build(), HttpStatus.OK);
        }
    }
    @GetMapping("/nombre-categoria")
    public ResponseEntity<GenericResponseDTO<List<ProductoDTO>>> buscarProductoPorCategoria(@RequestParam("idCategoria") Integer idCategoria ) {
        List<ProductoDTO> productoDTOList = productoService.buscarProductosPorCategoria(idCategoria);

        if (productoDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(false)
                    .mensaje("No se han encontrado productos con la Categoria " + idCategoria)
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(true)
                    .mensaje("Productos encontrados con la Categoria ")
                    .respuesta(productoDTOList)
                    .build(), HttpStatus.OK);
        }
    }

    @GetMapping("/producto-precio")
    public ResponseEntity<GenericResponseDTO<List<ProductoDTO>>> buscarProductoPorPrecio(@RequestParam("precio") Double precio ) {
        List<ProductoDTO> productoDTOList = productoService.buscarProductoPorPrecio(precio);

        if (productoDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(false)
                    .mensaje("No se han encontrado productos con el Precio :  " + precio)
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<ProductoDTO>>builder()
                    .correcto(true)
                    .mensaje("Productos encontrados con el precio " + precio)
                    .respuesta(productoDTOList)
                    .build(), HttpStatus.OK);
        }
    }
    @PostMapping("")
    public ResponseEntity<GenericResponseDTO<String>> registrarProducto(@RequestBody ProductoDTO productoDTO) {
        try {

            if (productoDTO.getCategoria() == null || productoDTO.getCategoria().getIdcategoria() == null) {
                return new ResponseEntity<>(GenericResponseDTO.<String>builder()
                        .correcto(false)
                        .mensaje("La categoría no puede ser nula.")
                        .build(), HttpStatus.BAD_REQUEST);
            }

            productoService.registrarProducto(productoDTO);
            return new ResponseEntity<>(GenericResponseDTO.<String>builder()
                    .correcto(true)
                    .mensaje("Producto Registrado Correctamente")
                    .build(), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(GenericResponseDTO.<String>builder()
                    .correcto(false)
                    .mensaje("Error al registrar el producto: " + exception.getMessage())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
