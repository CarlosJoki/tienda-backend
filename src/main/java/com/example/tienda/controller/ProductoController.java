package com.example.tienda.controller;

import com.example.tienda.model.Producto;
import com.example.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{cod_producto}")
    public Producto obtenerProductoPorCodigo(@PathVariable String cod_producto) {
        return productoRepository.findById(cod_producto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{cod_producto}")
    public Producto actualizarProducto(@PathVariable String cod_producto, @RequestBody Producto producto) {
        producto.setCod_producto(cod_producto);
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{cod_producto}")
    public void eliminarProducto(@PathVariable String cod_producto) {
        productoRepository.deleteById(cod_producto);
    }
}
