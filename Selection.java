import java.util.*;
class SelectionSort {
    public static void Selection(int[] arr) {
        int n = arr.length;
        int min;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
class Main {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(arr);
        SelectionSort.Selection(arr);

        System.out.println("Sorted Array is:");
        printArray(arr);
    }
}

// Output
// Original Array:
// 64 25 12 22 11 
// Sorted Array is:
// 11 12 22 25 64 
