import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of Objects:");
        int n = sc.nextInt();
        
        int[] p = new int[n];
        int[] w = new int[n];
        
        System.out.println("Enter profits:");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        
        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        
        System.out.println("Enter knapsack capacity:");
        int m = sc.nextInt();
        
        knapsack(m, w, p, n);
        sc.close();
    }

    public static void knapsack(int m, int[] w, int[] p, int n) {
        int[][] k = new int[n + 1][m + 1];

        // Build the DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    k[i][j] = Math.max(k[i - 1][j], k[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }

        // Print selected items
        System.out.println("Selected items (1 = taken, 0 = not taken):");
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (k[i][j] == k[i - 1][j]) {
                System.out.println("Item " + i + " : 0");
                i--;
            } else {
                System.out.println("Item " + i + " : 1");
                j -= w[i - 1];
                i--;
            }
        }

        System.out.println("Maximum profit: " + k[n][m]);
    }
}

// Output
// Enter number of Objects:
// 4
// Enter profits:
// 1 3 5 6
// Enter weights:
// 1 2 3 5
// Enter knapsack capacity:
// 8
// Selected items (1 = taken, 0 = not taken):
// Item 4 : 1
// Item 3 : 1
// Maximum profit: 11
