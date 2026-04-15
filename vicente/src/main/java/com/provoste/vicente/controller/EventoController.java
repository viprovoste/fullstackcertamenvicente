package com.provoste.vicente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.provoste.vicente.model.Evento;
import com.provoste.vicente.service.EventoService;


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
    public ResponseEntity<Evento> agregarEvento(@Valid @RequestBody Evento evento) {
        Evento nuevoEvento = eventoService.saveEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEvento); 
    }

    @GetMapping("{id}")
    public ResponseEntity<Evento> buscarEvento(@PathVariable int id){
        Evento evento = eventoService.getEventoId(id);

        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(evento);
    }
    
    @GetMapping(("/tipo_evento/{tipo_evento}"))
    public ResponseEntity<List<Evento>> buscarPorTipoEvento(@PathVariable String tipo_evento) {
        List<Evento> eventos = eventoService.getEventoTipoEvento(tipo_evento);
        return ResponseEntity.ok(eventos);
    }

    @PutMapping("{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable int id,@Valid @RequestBody Evento evento){
        Evento eventoExistente = eventoService.getEventoId(id);
        if (eventoExistente == null) {
            return ResponseEntity.notFound().build();
        }
    eventoService.updateEvento(evento);
        return ResponseEntity.ok(evento);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarEvento(@PathVariable int id) {
        Evento eventoExistente = eventoService.getEventoId(id);
        if (eventoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        eventoService.deleteEvento(id);
        return ResponseEntity.ok("Evento Eliminado");
    }
    
}
