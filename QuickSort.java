import java.io.File;
import java.io.IOException;
import java.util.*;

public class QuickSort {

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(arr, inicio, fin);
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Entrada.txt"));
            List<Integer> lista = new ArrayList<>();

            while (sc.hasNextInt()) {
                lista.add(sc.nextInt());
            }
            sc.close();

            int[] numeros = lista.stream().mapToInt(Integer::intValue).toArray();

            System.out.println("Arreglo original:");
            imprimirArreglo(numeros);

            quickSort(numeros, 0, numeros.length - 1);

            System.out.println("Arreglo ordenado:");
            imprimirArreglo(numeros);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}






