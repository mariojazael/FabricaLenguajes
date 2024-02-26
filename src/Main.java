import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static final ControladorLenguajesImpl CONTROLADOR_LENGUAJES = new ControladorLenguajesImpl();
    public static void main(String[] args) {
        programHandler(true);
    }

    public static void programHandler(boolean c){
        boolean condition = c;
        List<String> list1 = Main.obtenerLenguaje(1);
        List<String> list2 = Main.obtenerLenguaje(2);
        while(condition){
            switch (Main.obtenerOpcion()){
                case 1: {
                    System.out.println(CONTROLADOR_LENGUAJES.obtenerInterseccion(list1, list2));
                    break;
                }
                case 2: {
                    System.out.println(CONTROLADOR_LENGUAJES.obtenerDiferencia(list1, list2));
                    break;
                }
                case 3: {
                    System.out.println(CONTROLADOR_LENGUAJES.obtenerConcatenacion(list1, list2));
                    break;
                }
                case 4: {
                    CONTROLADOR_LENGUAJES.obtenerPrefijosYSufijos(Main.obtenerCadena());
                    break;
                }
                case 5: {
                    condition = false;
                    break;
                }
            }
        }

    }

    public static List<String> obtenerLenguaje(int number){
        List<String> palabras = new ArrayList<>();
        System.out.println("Cuantas palabras tiene el lenguaje ".concat(String.valueOf(number)));
        int cantidadIteraciones = new Scanner(System.in).nextInt();
        System.out.println("Ingresa las ".concat(String.valueOf(cantidadIteraciones)).concat(" palabras que tiene el lenguaje ".concat(String.valueOf(number))));
        Stream.iterate(0, (i) -> i + 1)
                .limit(cantidadIteraciones)
                .forEach(i -> palabras.add(new Scanner(System.in).next()));

        return palabras;
    }

    public static int obtenerOpcion(){
        System.out.println("Digita el numero de la opcion que deseas elegir: \n\n\n   1. Interseccion\n   2. Diferencia\n   3. Concatenacion\n   4. Sufijos y prefijos\n   5. Salir del programa\n");
        return new Scanner(System.in).nextInt();
    }

    public static String obtenerCadena(){
        System.out.println("Escribe la palabra que desees: \n");
        return new Scanner(System.in).next();
    }
}
