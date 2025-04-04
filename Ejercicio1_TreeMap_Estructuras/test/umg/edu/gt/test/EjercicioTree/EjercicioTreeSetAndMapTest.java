package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EjercicioTreeSetAndMapTest {

    private Path crearArchivoTemporal(String contenido) throws IOException {
        Path tempFile = Files.createTempFile("texto", ".txt");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write(contenido);
        }
        return tempFile;
    }

    @Test
    void testFrecuenciaCorrecta() throws IOException {
        String texto = "Hola mundo, hola Java. Java es divertido.";
        Path archivo = crearArchivoTemporal(texto);

        Map<String, Integer> resultado = EjercicioTreeSetAndMap.contarFrecuenciaPalabras(archivo.toString());

        assertEquals(2, resultado.get("hola"));
        assertEquals(2, resultado.get("java"));
        assertEquals(1, resultado.get("mundo"));
        assertEquals(1, resultado.get("es"));
        assertEquals(1, resultado.get("divertido"));
    }

    @Test
    void testForzarFallo() throws IOException {
        String texto = "Hola hola hola";
        Path archivo = crearArchivoTemporal(texto);

        Map<String, Integer> resultado = EjercicioTreeSetAndMap.contarFrecuenciaPalabras(archivo.toString());

        assertEquals(2, resultado.get("hola")); // Este test fallará
    }
}