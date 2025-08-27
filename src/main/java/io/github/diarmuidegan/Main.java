package io.github.diarmuidegan;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Initialize two 3x3 matrices with random values between 1 and 50
        int[][] arr1 = generateRandomMatrix(3, 3, 1, 50);
        int[][] arr2 = generateRandomMatrix(3, 3, 1, 50);

        // Print the matrices
        System.out.println("Arr1:");
        printMatrix(arr1);

        System.out.println("Arr2:");
        printMatrix(arr2);
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        //
        // Task 1
        //
        Task1FrequencyDistributionRunnable task1Runnable = new Task1FrequencyDistributionRunnable(arr1);
        executorService.submit(task1Runnable);
    }

    // Method to generate a rows x cols matrix with random values between minValue and maxValue
    public static int[][] generateRandomMatrix(int rows, int cols, int minValue, int maxValue) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Generate random value between minValue and maxValue (inclusive)
                matrix[i][j] = random.nextInt((maxValue - minValue) + 1) + minValue;
            }//end for
        }//end for

        return matrix;
    }//end generateRandomMatrix

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }//end for
            System.out.println();
        }//end for
    }//end printMatrix


}