
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    private static int swapCount = 0;
    private static int recursionCount = 0;

    public static void mergeSort(int[] list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            recursionCount+=2;
            mergeSort(list, left, middle);
            mergeSort(list, middle + 1, right);
            merge(list, left, middle, right);
        }
    }

    public static void merge(int[] list, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = list[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = list[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                list[k] = leftArray[i];
                i++;
            } else {
                list[k] = rightArray[j];
                j++;
            }
            swapCount++;
            k++;
        }

        while (i < n1) {
            list[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            list[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static int[] generateRandomArray(int n) {
        int[] list = new int[n];
        Random rand = new Random(321);
        for (int i = 0; i < n; i++) {
            list[i] = rand.nextInt(100);
        }
        return list;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int getSwapCount() {
        return swapCount;
    }

    public static int getRecursionCount() {
        return recursionCount;
    }

}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos elementos deseja na lista: ");
        int n = scanner.nextInt();

        int[] list = MergeSort.generateRandomArray(n);

        System.out.println("Lista antes da ordenação:");
        MergeSort.printArray(list);

        long startTime = System.nanoTime();

        MergeSort.mergeSort(list, 0, list.length - 1);

        long endTime = System.nanoTime();

        System.out.println("\nLista após a ordenação:");
        MergeSort.printArray(list);

        long duration = endTime - startTime;

        System.out.println("\nTempo de execução (nanosegundos): " + duration);
        System.out.println("Número de trocas: " + MergeSort.getSwapCount());
        System.out.println("Número de iterações: " + MergeSort.getRecursionCount());

    }
}
