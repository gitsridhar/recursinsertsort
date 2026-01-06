import java.util.Arrays;

public class RecursiveInsertionSort {

    /**
     * Recursively sorts an array using Insertion Sort logic.
     * @param arr The array to be sorted.
     * @param n   The current number of elements to process.
     */
    public static void insertionSortRecursive(int[] arr, int n) {
        // Base case: An array of size 1 or less is already sorted
        if (n <= 1) {
            return;
        }

        // 1. Recursively sort the first n-1 elements
        insertionSortRecursive(arr, n - 1);

        // 2. Insert the last element (arr[n-1]) into its correct
        //    position in the sorted portion (arr[0..n-2])
        int last = arr[n - 1];
        int j = n - 2;

        /* Move elements of arr[0..n-2] that are greater than 'last'
           to one position ahead of their current position */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6};
        
        System.out.println("Original Array: " + Arrays.toString(data));

        // Start recursion with the full length of the array
        insertionSortRecursive(data, data.length);

        System.out.println("Sorted Array:   " + Arrays.toString(data));
    }
}
