package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.time.LocalDateTime;
import java.util.TreeSet;
import java.util.Iterator;

public class EjercicioTreeSetAndMap {

    public static class Evento implements Comparable<Evento> {
        private LocalDateTime fecha;
        private String nombre;
        private String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public String getNombre() {
            return nombre;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        @Override
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha);
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s", nombre, fecha.toString(), ubicacion);
        }
    }

    private TreeSet<Evento> eventos = new TreeSet<>();

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public TreeSet<Evento> listarEventos() {
        eliminarEventosPasados();
        return new TreeSet<>(eventos);
    }

    public Evento obtenerProximoEvento() {
        eliminarEventosPasados();
        return eventos.isEmpty() ? null : eventos.first();
    }

    private void eliminarEventosPasados() {
        Iterator<Evento> iterator = eventos.iterator();
        LocalDateTime ahora = LocalDateTime.now();
        while (iterator.hasNext()) {
            Evento e = iterator.next();
            if (e.getFecha().isBefore(ahora)) {
                iterator.remove();
            }
        }
    }
}