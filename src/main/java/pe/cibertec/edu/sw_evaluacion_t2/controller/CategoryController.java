package pe.cibertec.edu.sw_evaluacion_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.sw_evaluacion_t2.dto.CategoriaDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.GenericResponseDTO;
import pe.cibertec.edu.sw_evaluacion_t2.dto.ProductoDTO;
import pe.cibertec.edu.sw_evaluacion_t2.model.Categoria;
import pe.cibertec.edu.sw_evaluacion_t2.service.impl.CategoriaService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/categoria")
public class CategoryController {
    private final CategoriaService categoriaService;
    @GetMapping("/list")
    public List<Categoria> listAll() {
        return categoriaService.listAllCategoria();
    }
    @GetMapping("")
    public ResponseEntity<GenericResponseDTO<List<CategoriaDTO>>> listarCategoriaPorNombre(@RequestParam("nombre") String nombre) {
        List<CategoriaDTO> categoriaDTOList = categoriaService.findByNombre(nombre);

        if (categoriaDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<CategoriaDTO>>builder()
                    .correcto(false)
                    .mensaje("No se a encontrado categoría con el nombre :" + nombre)
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<CategoriaDTO>>builder()
                    .correcto(true)
                    .mensaje("Categoría encontradas")
                    .respuesta(categoriaDTOList)
                    .build(), HttpStatus.OK);
        }
    }

    @GetMapping("descripcion")
    public ResponseEntity<GenericResponseDTO<List<CategoriaDTO>>> listarCategoriaPorDescripcion(@RequestParam("descripcion") String descripcion) {
        List<CategoriaDTO> categoriaDTOList = categoriaService.findyByDescripcion(descripcion);

        if (categoriaDTOList.isEmpty()) {

            return new ResponseEntity<>(GenericResponseDTO.<List<CategoriaDTO>>builder()
                    .correcto(false)
                    .mensaje("No se a encontrado categoría con la Descripcion :" + descripcion)
                    .respuesta(null)
                    .build(), HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(GenericResponseDTO.<List<CategoriaDTO>>builder()
                    .correcto(true)
                    .mensaje("Categoría encontradas")
                    .respuesta(categoriaDTOList)
                    .build(), HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDTO<String>>registrarCategoria(@RequestBody CategoriaDTO categoriaDTO){
        categoriaService.registrarCategoria(categoriaDTO);
        try {
            return new ResponseEntity<>(GenericResponseDTO.<String>
                            builder()
                    .correcto(true)
                    .mensaje("Categoria Registrada Correctamente")
                    .build(),HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(GenericResponseDTO.<String>
                            builder()
                    .correcto(true)
                    .mensaje("Categoria NO Registrada")
                    .build(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }








}
