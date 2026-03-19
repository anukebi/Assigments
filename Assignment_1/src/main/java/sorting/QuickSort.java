package sorting;

import java.util.Random;

public class QuickSort {

    private static final Random RANDOM = new Random();

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // 1. Helper partition function for shuffling pivot to avoid stack overflows in case of large arrays (>100K)
    static int randomPartition(int[] arr, int low, int high) {
        // Generate random index between low and high
        int randomIdx = low + RANDOM.nextInt(high - low + 1);

        // Swap the random element with the last element (the pivot position)
        swap(arr, randomIdx, high);

        // Now call the standard partition (which uses arr[high])
        return partition(arr, low, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomPartition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}