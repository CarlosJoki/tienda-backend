package com.example.tienda.controller;

import com.example.tienda.model.Cliente;
import com.example.tienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{dni}")
    public Cliente obtenerClientePorDni(@PathVariable String dni) {
        return clienteRepository.findById(dni).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{dni}")
    public Cliente actualizarCliente(@PathVariable String dni, @RequestBody Cliente cliente) {
        cliente.setDni(dni);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{dni}")
    public void eliminarCliente(@PathVariable String dni) {
        clienteRepository.deleteById(dni);
    }
}
