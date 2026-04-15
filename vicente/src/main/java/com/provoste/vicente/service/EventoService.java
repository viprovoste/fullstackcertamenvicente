package com.provoste.vicente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provoste.vicente.model.Evento;
import com.provoste.vicente.repository.EventoRepository;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getEventos() {
        return eventoRepository.obtenerEventos();
    }

    public Evento saveEvento(Evento evento) {
        return eventoRepository.guardar(evento);
    }
    
    public Evento getEventoId(int id) {
        return eventoRepository.buscarPorId(id);
    }

    public List<Evento> getEventoTipoEvento(String tipo_evento) {
        return eventoRepository.buscarPorTipoEvento(tipo_evento);
    }

    public Evento updateEvento(Evento evento) {
        return eventoRepository.actualizar(evento);
    }

    public String deleteEvento(int id) {
        eventoRepository.eliminar(id);
        return "Evento Eliminado";
    }

}
