package com.example.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    private String cod_venta;

    private String dni; // Relación con Cliente

    private String cod_producto; // Relación con Producto

    private int cantidad;

    private Date fecha;
}
