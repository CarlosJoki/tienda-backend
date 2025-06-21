package com.example.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    private String dni;

    private String nombre;

    private String apellidos;

    private String telefono;

    private String direccion;
}
