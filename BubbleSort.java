import java.util.*;
class BubbleSort{
    public static void Bubble(int[] arr){
        int n=arr.length;
        int temp;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
class Main{
    public static void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int[] arr={12,45,10,30,2};
        System.out.println("Original Array");
        printArray(arr);
        BubbleSort.Bubble(arr);
        System.out.println("Sorted Array");
        printArray(arr);
    }
}

// Output
// Original Array
// 12 45 10 30 2 
// Sorted Array
// 2 10 12 30 45 
