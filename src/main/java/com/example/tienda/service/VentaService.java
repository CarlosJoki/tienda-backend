package com.example.tienda.service;

import com.example.tienda.model.Venta;
import com.example.tienda.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
}