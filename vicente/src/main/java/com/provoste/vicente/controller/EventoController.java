package com.provoste.vicente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provoste.vicente.model.Evento;
import com.provoste.vicente.service.EventoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento>listarEventos(){
        return eventoService.getEventos();
    }
    
    @PostMapping
    public Evento agregarEvento(@Valid @RequestBody Evento evento) {
        return eventoService.saveEvento(evento);
    }

    @GetMapping("{id}")
    public Evento buscarEvento(@PathVariable int id){
        return eventoService.getEventoId(id);
    }
    
    @GetMapping(("/tipo_evento/{tipo_evento}"))
    public Evento buscarPorTipoEvento(@PathVariable String tipo_evento) {
        return eventoService.getEventoTipoEvento(tipo_evento);
    }

    @PutMapping("{id}")
    public Evento actualizarEvento(@PathVariable int id,@Valid @RequestBody Evento evento){
        return eventoService.updateEvento(evento);
    }
    
    @DeleteMapping("{id}")
    public String eliminarEvento(@PathVariable int id) {
        return eventoService.deleteEvento(id);
    }
    
}
