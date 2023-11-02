import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static int swapCount = 0;
    public static int iterationCount = 0;

    public static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);

            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
            iterationCount+=2;
        }
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        swapCount++;
    }

    private static int partition(int[] list, int low, int high) {
        int pivot = list[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list[j] < pivot) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    public static void printList(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos elementos na lista: ");
        int n = scanner.nextInt();
        scanner.close();

        int[] list = new int[n];
        Random random = new Random(321);
        for (int i = 0; i < n; i++) {
            list[i] = random.nextInt(100);
        }

        System.out.println("Lista não ordenada:");
        QuickSort.printList(list);

        long startTime = System.nanoTime();

        QuickSort.quickSort(list, 0, n - 1);

        long endTime = System.nanoTime();

        System.out.println("\nLista ordenada:");
        QuickSort.printList(list);

        long duration = endTime - startTime;

        System.out.println("\nTempo de execução (nanosegundos): " + duration);
        System.out.println("Número de trocas: " + QuickSort.swapCount);
        System.out.println("Número de iterações: " + QuickSort.iterationCount);
    }
}