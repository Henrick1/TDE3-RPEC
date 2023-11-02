import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static int bubbleSort(int[] list) {
        int n = list.length;
        boolean trocou;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    trocou = true;
                    trocas++;
                }
            }

            if (!trocou) {
                break;
            }
        }
        return trocas;
    }

    public static int[] gerarListaAleatoria(int n) {
        int[] list = new int[n];
        Random random = new Random(321);

        for (int i = 0; i < n; i++) {
            list[i] = random.nextInt(100);
        }

        return list;
    }

    public static void imprimirLista(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos elementos deseja na list: ");
        int n = scanner.nextInt();
        int[] list = BubbleSort.gerarListaAleatoria(n);

        System.out.println("Lista não ordenada:");
        BubbleSort.imprimirLista(list);

        long startTime = System.nanoTime();

        int trocas = BubbleSort.bubbleSort(list);

        long endTime = System.nanoTime();

        System.out.println("Lista ordenada:");
        BubbleSort.imprimirLista(list);

        long duration = endTime - startTime;

        System.out.println("\nTempo de execução (nanossegundos): " + duration);
        System.out.println("Número de trocas: " + trocas);

        scanner.close();
    }
}