package sorting;

import java.util.Random;
import java.util.function.Function;

public class DataGenerator {

    /**
     * Generated an array based on the sort type
     * @param n        number of array elements
     * @param sortType sort type
     * @return         generated array
     */
    public static int[] generate(int n, SortType sortType) {
        return sortType.generator.apply(n);
    }

    public enum SortType {
        RANDOM(DataGenerator::uniformRandom),
        ASCENDING(DataGenerator::ascending),
        DESCENDING(DataGenerator::descending),
        NEARLY(DataGenerator::nearlySorted);

        SortType(Function<Integer, int[]> generator) {
            this.generator = generator;
        }

        private final Function<Integer, int[]> generator;
    }

    private static int[] uniformRandom(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt();
        return arr;
    }

    private static int[] ascending(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        return arr;
    }

    private static int[] descending(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    private static int[] nearlySorted(int n) {
        Random rand = new Random();
        int[] arr = ascending(n);
        int swaps = n / 100; // 1% random swaps
        for (int i = 0; i < swaps; i++) {
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
        }
        return arr;
    }

}