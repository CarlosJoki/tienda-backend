package com.example.tienda.controller;

import com.example.tienda.model.Cliente;
import com.example.tienda.model.Producto;
import com.example.tienda.model.Venta;
import com.example.tienda.repository.ClienteRepository;
import com.example.tienda.repository.ProductoRepository;
import com.example.tienda.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "http://localhost:5173")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Crear una venta
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venta crearVenta(@RequestBody Venta venta) {
        // Verificar que el cliente exista
        Cliente cliente = clienteRepository.findById(venta.getDni())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Verificar que el producto exista
        Producto producto = productoRepository.findById(venta.getCod_producto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Asignar la fecha de la venta
        venta.setFecha(new Date());

        // Guardar y devolver la venta
        return ventaRepository.save(venta);
    }

    // Obtener todas las ventas
    @GetMapping
    public Iterable<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    // Obtener una venta por código
    @GetMapping("/{cod_venta}")
    public Venta obtenerVentaPorCodigo(@PathVariable String cod_venta) {
        return ventaRepository.findById(cod_venta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
}
