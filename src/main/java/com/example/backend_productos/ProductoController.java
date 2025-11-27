package com.example.backend_productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repositorio;

    // 1. (R)EAD - Listar todos los productos
    // Esto es lo que llama tu navegador cuando entras al link
    @GetMapping
    public List<Producto> listar() {
        return repositorio.findAll();
    }

    // 2. (R)EAD - Buscar un solo producto por ID
    // Esto lo usa tu botón "Buscar" en Android
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    // 3. (C)REATE - Guardar un nuevo producto
    // Esto lo usa tu botón "Agregar"
    @PostMapping
    public Producto guardar(@RequestBody Producto p) {
        return repositorio.save(p);
    }

    // 4. (U)PDATE - Actualizar un producto existente
    // Esto lo usa tu botón "Editar"
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto p) {
        Producto existente = repositorio.findById(id).orElse(null);
        if (existente != null) {
            existente.setProducto(p.getProducto());
            existente.setMarca(p.getMarca());
            existente.setCosto(p.getCosto());
            return repositorio.save(existente);
        }
        return null;
    }

    // 5. (D)ELETE - Borrar un producto
    // Esto lo usa tu botón "Borrar"
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }
}