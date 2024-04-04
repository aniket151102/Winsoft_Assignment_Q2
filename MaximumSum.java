package sumpath;

import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the first array (m): ");
        int m = scanner.nextInt();

        System.out.println("Enter the elements of the first array: ");
        int[] X = new int[m];
        for (int i = 0; i < m; i++) {
            X[i] = scanner.nextInt();
        }

        System.out.println("Enter the size of the second array (n): ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the second array: ");
        int[] Y = new int[n];
        for (int i = 0; i < n; i++) {
            Y[i] = scanner.nextInt();
        }

        int[] maxPath = findMaxSumPath(X, Y);

        System.out.println("Maximum sum path: ");
        for (int i = 0; i < maxPath.length; i++) {
            System.out.print(maxPath[i] + " ");
        }
    }

    public static int[] findMaxSumPath(int[] X, int[] Y) {
        int[] maxPath = new int[X.length + Y.length];
        int i = 0, j = 0, k = 0;

        int max = Integer.MIN_VALUE;
        while (i < X.length && j < Y.length) {
            if (X[i] <= Y[j]) {
                if (X[i] > max) {
                    max = X[i];
                    maxPath[k++] = X[i++];
                } else {
                    i++;
                }
            } else {
                if (Y[j] > max) {
                    max = Y[j];
                    maxPath[k++] = Y[j++];
                } else {
                    j++;
                }
            }
        }

        while (i < X.length) {
            if (X[i] > max) {
                max = X[i];
                maxPath[k++] = X[i++];
            } else {
                i++;
            }
        }

        while (j < Y.length) {
            if (Y[j] > max) {
                max = Y[j];
                maxPath[k++] = Y[j++];
            } else {
                j++;
            }
        }

        return maxPath;
    }
}