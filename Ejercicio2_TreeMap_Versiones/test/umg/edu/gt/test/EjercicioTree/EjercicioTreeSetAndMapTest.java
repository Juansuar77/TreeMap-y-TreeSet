package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;

import static org.junit.jupiter.api.Assertions.*;

class EjercicioTreeSetAndMapTest {

    @Test
    void testAgregarYObtenerVersiones() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();

        int v1 = gestor.agregarVersion("System.out.println('Hola Mundo');");
        int v2 = gestor.agregarVersion("System.out.println('Hola Java');");

        assertEquals("System.out.println('Hola Mundo');", gestor.obtenerVersion(v1));
        assertEquals("System.out.println('Hola Java');", gestor.obtenerVersion(v2));
        assertEquals("System.out.println('Hola Java');", gestor.obtenerUltimaVersion());
    }

    @Test
    void testEliminarVersion() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();

        int v1 = gestor.agregarVersion("v1");
        int v2 = gestor.agregarVersion("v2");

        gestor.eliminarVersion(v1);
        assertNull(gestor.obtenerVersion(v1));
        assertEquals("v2", gestor.obtenerVersion(v2));
    }

    @Test
    void testFalloVersionIncorrecta() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();

        int v1 = gestor.agregarVersion("v1");
        // Esta afirmación está hecha para fallar
        assertEquals("v2", gestor.obtenerVersion(v1));
    }
}