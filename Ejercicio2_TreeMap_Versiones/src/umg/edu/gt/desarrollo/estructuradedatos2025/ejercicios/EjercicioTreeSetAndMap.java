package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.Map;
import java.util.TreeMap;

public class EjercicioTreeSetAndMap {

    private TreeMap<Integer, String> versiones = new TreeMap<>();
    private int versionActual = 0;

    public int agregarVersion(String contenido) {
        versionActual++;
        versiones.put(versionActual, contenido);
        return versionActual;
    }

    public String obtenerVersion(int numeroVersion) {
        return versiones.get(numeroVersion);
    }

    public String obtenerUltimaVersion() {
        return versiones.isEmpty() ? null : versiones.lastEntry().getValue();
    }

    public void eliminarVersion(int numeroVersion) {
        versiones.remove(numeroVersion);
    }

    // Método para exponer mapa (solo para test)
    public Map<Integer, String> obtenerMapaVersiones() {
        return versiones;
    }
}