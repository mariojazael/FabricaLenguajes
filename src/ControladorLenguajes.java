import java.util.List;

public interface ControladorLenguajes {
    List<String> obtenerInterseccion(List<String> lenguaje1, final List<String> lenguaje2);
    List<String> obtenerDiferencia(List<String> lenguaje1, final List<String> lenguaje2);
    List<String> obtenerConcatenacion(List<String> lenguaje1, List<String> lenguaje2);
    void obtenerPrefijosYSufijos(String palabra);
}
