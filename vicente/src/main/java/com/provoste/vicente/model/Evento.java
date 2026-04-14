package com.provoste.vicente.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El Tipo Evento es obligatorio")
    private String tipo_evento;

    @Min(value = 0, message = "La fecha de Realizacion no puede ser mejor a 2020")
    private int fecha_realizacion;

    @Min(value = 50, message = "La cantidad de Participantes no puede ser menor a 50")
    @Max(value = 3000, message = "La cantidad de Participantes no puede ser mayor a 3000")
    private int cantidad_participantes;

    @NotBlank(message = "La ubicacion es obligatoria")
    private String ubicacion;
    
}
