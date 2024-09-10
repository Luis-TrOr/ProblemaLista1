import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<Integer> mezclar(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Recuerda poner dos listas de numeros entre comillas y separados por comas como argumentos de linea de comandos");
            return;
        }

        List<Integer> lista1 = parsearEntrada(args[0]);
        List<Integer> lista2 = parsearEntrada(args[1]);

        List<Integer> listaMezclada = mezclar(lista1, lista2);

        System.out.println(listaMezclada);
    }

    private static List<Integer> parsearEntrada(String entrada) {
        return Arrays.stream(entrada.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}
