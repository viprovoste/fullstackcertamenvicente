package com.provoste.vicente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    private int id;
    private String nombre;
    private String tipo_evento;
    private int fecha_realizacion;
    private String ubicacion;
    private String cantidad_participantes;
    
}
