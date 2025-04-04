package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class EjercicioTreeSetAndMap {

    public static Map<String, Integer> contarFrecuenciaPalabras(String pathArchivo) {
        Map<String, Integer> frecuencia = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.toLowerCase().replaceAll("[^a-záéíóúüñ\s]", "");
                String[] palabras = linea.split("\s+");
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return frecuencia;
    }
}