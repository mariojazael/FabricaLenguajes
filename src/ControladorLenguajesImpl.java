import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControladorLenguajesImpl implements ControladorLenguajes{
    private static final UnaryOperator<Integer> DECREMENT = (i) -> i - 1;
    static final BiConsumer<String, Integer> SUBSTRINGS_PRINTER = (value, i) -> System.out.println(value.substring(0, i)
            .concat("   ")
            .concat(value.substring(i - 1)));

    @Override
    public List<String> obtenerInterseccion(List<String> lenguaje1, final List<String> lenguaje2){
        List<String> lenguaje2Mutable = new ArrayList<>(lenguaje2);
        return lenguaje1.stream()
                .filter(lenguaje2Mutable::remove)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerDiferencia(List<String> lenguaje1, final List<String> lenguaje2){
        Set<String> resultado = obtenerNoDuplicados(lenguaje1, lenguaje2);
        resultado.addAll(obtenerNoDuplicados(lenguaje2, lenguaje1));
        return new ArrayList<>(resultado);
    }


    @Override
    public List<String> obtenerConcatenacion(List<String> lenguaje1, List<String> lenguaje2){
        List<String> list1 = new ArrayList<>(lenguaje1.stream()
                .flatMap(s1 -> lenguaje2.stream().map(s2 -> s1.concat(s2).concat(" ")))
                .toList());
        list1.addAll(lenguaje2.stream()
                .flatMap(s1 -> lenguaje1.stream().map(s2 -> s1.concat(s2).concat(" ")))
                .toList());
        return list1;
    }

    @Override
    public void obtenerPrefijosYSufijos(String palabra){
        final int LENGTH = palabra.length();
        Stream.iterate(LENGTH, DECREMENT)
                .limit(LENGTH)
                .forEach(i -> SUBSTRINGS_PRINTER.accept(palabra, i));
    }
    private Set<String> obtenerNoDuplicados(List<String> lenguaje1, List<String> lenguaje2) {
        Set<String> resultado = new HashSet<>();
        for(String s1: lenguaje1){
            int counter = 0;
            for(String s2: lenguaje2){
                if(s1.equals(s2)) counter++;
            }
            if(counter == 0) resultado.add(s1);
        }
        return resultado;
    }
}


