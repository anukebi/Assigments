package sorting;

public class LSDRadixSort {

    private static final int BITS = 32;
    private static final int RADIX = 256;
    private static final int MASK = RADIX - 1;

    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];

        for (int shift = 0; shift < BITS; shift += 8) {
            int[] count = new int[RADIX];
            for (int num : arr) {
                int digit = (num >>> shift) & MASK;
                count[digit]++;
            }

            for (int i = 1; i < RADIX; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] >>> shift) & MASK;
                tmp[--count[digit]] = arr[i];
            }

            System.arraycopy(tmp, 0, arr, 0, arr.length);
        }

        // Adjust for negative numbers
        int negCount = 0;
        for (int num : arr) {
            if (num < 0) {
                negCount++;
            }
        }

        int[] finalArr = new int[arr.length];
        System.arraycopy(arr, arr.length - negCount, finalArr, 0, negCount);
        System.arraycopy(arr, 0, finalArr, negCount, arr.length - negCount);
        System.arraycopy(finalArr, 0, arr, 0, arr.length);
    }

}