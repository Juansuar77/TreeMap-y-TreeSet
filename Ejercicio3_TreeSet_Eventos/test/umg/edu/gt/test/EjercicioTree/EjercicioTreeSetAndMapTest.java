package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.Evento;

import java.time.LocalDateTime;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class EjercicioTreeSetAndMapTest {

    @Test
    void testAgregarYObtenerProximoEvento() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();

        Evento e1 = new Evento(LocalDateTime.of(2025, 4, 15, 14, 0), "Taller de Machine Learning", "Sala 3");
        Evento e2 = new Evento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A");

        gestor.agregarEvento(e1);
        gestor.agregarEvento(e2);

        Evento proximo = gestor.obtenerProximoEvento();
        assertEquals("Taller de Machine Learning", proximo.getNombre());
    }

    @Test
    void testEliminarEventosPasados() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();

        Evento pasado = new Evento(LocalDateTime.now().minusDays(1), "Evento pasado", "Aula vieja");
        Evento futuro = new Evento(LocalDateTime.now().plusDays(1), "Evento futuro", "Aula nueva");

        gestor.agregarEvento(pasado);
        gestor.agregarEvento(futuro);

        TreeSet<Evento> eventos = gestor.listarEventos();
        assertEquals(1, eventos.size());
        assertEquals("Evento futuro", eventos.first().getNombre());
    }

    @Test
    void testForzarFalloProximoEvento() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();

        Evento e = new Evento(LocalDateTime.of(2025, 6, 1, 10, 0), "Evento X", "Lugar X");
        gestor.agregarEvento(e);

        Evento proximo = gestor.obtenerProximoEvento();
        // Esto está hecho para fallar
        assertEquals("Evento Y", proximo.getNombre());
    }
}