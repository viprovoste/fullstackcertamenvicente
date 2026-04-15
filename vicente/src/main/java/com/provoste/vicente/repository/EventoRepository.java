package com.provoste.vicente.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.provoste.vicente.model.Evento;

@Repository
public class EventoRepository {
    
    //Guarda Eventos
    private List<Evento> listaEventos = new ArrayList<>();

    //Retorna Eventos
    public List<Evento> obtenerEventos(){
        return listaEventos;
    }

    //Buscar Evento por Id
    public Evento buscarPorId(int id) {
        for (Evento evento : listaEventos){
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }

    //Buscar por tipo evento (informacion especifica)
    public List<Evento> buscarPorTipoEvento(String tipo_evento) {
        List<Evento> resultados = new ArrayList<>();

        for (Evento evento : listaEventos){
            if (evento.getTipo_evento().equals(tipo_evento)) {
                resultados.add(evento);
            }
        }
        return resultados;
    }

    //Guardarr
    public Evento guardar(Evento eve) {
        listaEventos.add(eve);
        return eve;
    }

    //Actualizar
    public Evento actualizar(Evento eve) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i <listaEventos.size(); i++) {
            if (listaEventos.get(i).getId() == eve.getId()) {
                id =eve.getId();
                idPosicion = i;
            }
        }

        Evento evento1 = new Evento();
        evento1.setId(id);
        evento1.setNombre(eve.getNombre());
        evento1.setTipo_evento(eve.getTipo_evento());
        evento1.setFecha_realizacion(eve.getFecha_realizacion());
        evento1.setUbicacion(eve.getUbicacion());
        evento1.setCantidad_participantes(eve.getCantidad_participantes());

        listaEventos.set(idPosicion, evento1);
        return evento1;
    }

    //Eliminar
    public void eliminar(int id) {
        listaEventos.removeIf(x -> x.getId() == id);
    }

}
