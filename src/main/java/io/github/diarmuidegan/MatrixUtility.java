package io.github.diarmuidegan;

import java.util.*;
import java.util.stream.Collectors;

public class MatrixUtility {

    /**
     * Calculates and prints the frequency distribution of elements in a 2D matrix using an alternative method.
     * @param matrixArray the matrix to get frequency distribution of
     */
    public static void elementsFrequencyDistributionAlt(int[][] matrixArray) {

        HashMap<Integer, Integer> frequencyHashMap = getFrequencyHashMap(matrixArray);
        printIntegerFrequencyMap(frequencyHashMap);
    }


    /**
     * Creates a Frequency Hash Map of 2D Matrix (int[][])
     * @param matrixArray 2D The Matrix to get frequency HashMap of.
     * @return The frequency Hashmap
     */
    public static HashMap<Integer, Integer> getFrequencyHashMap(int[][] matrixArray) {
        var frequencyHashMap = new HashMap<Integer, Integer>();
        for (int[] row : matrixArray) {
            for (int value : row) {
                frequencyHashMap.put(value, frequencyHashMap.getOrDefault(value, 0) + 1);
            }
        }
        return frequencyHashMap;
    }
    /**
     * Calculates and prints the frequency distribution of elements in a 2D matrix.
     * @param matrixArray the matrix to get frequency distribution of
     */
    public static void elementsFrequencyDistribution(int[][] matrixArray) {
        Map<Integer, Long> frequency = Arrays.stream(matrixArray)
                .flatMapToInt((Arrays::stream))
                .boxed()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));

        printLongFrequencyMap(frequency);
    }
    /**
     * Prints a frequency Map values count;
     * @param frequencyMap the map to print.
     */
    public static void printIntegerFrequencyMap(Map<Integer, Integer> frequencyMap) {
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int countValue = entry.getValue();
            String timePlural = countValue == 1 ? "time" : "times";

            System.out.printf("%d appears %d %s in the matrix.%n", entry.getKey(), countValue, timePlural);
        }
    }
    /**
     * Prints a frequency Map values count;
     * @param frequencyMap the map to print.
     */
    public static void printLongFrequencyMap(Map<Integer, Long> frequencyMap) {
        var keys = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(keys);

        for (int key : keys) {
            long value = frequencyMap.get(key);
            String timePlural = (value == 1) ? "time" : "times";
            System.out.printf("%d appears %d %s in the matrix.%n", key, value, timePlural);
        }
    }
    /**
     * Calculates the percentage of elements in the matrix that are less than or equal to the specified number.
     * @return The percentage of elements less than or equal to the specified number.
     * @throws Exception if an error occurs.
     */
    public static Double elementsPcStat(int[][] matrixArray, int element) throws Exception {
        int total = matrixArray.length * matrixArray[0].length;
        int count = countLessOrEqual(matrixArray, element);
        return count/(double)total;
    }

    /**
     * Counts the number of elements in the matrix that are less than or equal to the specified test value.
     * @param matrixArray the matrix to search
     * @param testValue the value to compare against
     * @return the count of elements less than or equal to the test value
     */
    public static int countLessOrEqual(int[][] matrixArray, int testValue) {
        return (int) Arrays.stream(matrixArray)            // Stream<int[]>
                .flatMapToInt(Arrays::stream)              // Stream all ints
                .filter(number -> number <= testValue) // Keep <= testValue
                .count();                                  // Count them
    }

    /**
     * Multiplies two matrices together and returns the product matrix
     * @param matrixArrayLhs the left hand side matrix
     * @param matrixArrayRhs the right hand side matrix
     * @return The product matrix
     */
    public static int[][] multiplyMatrices(int[][] matrixArrayLhs, int[][] matrixArrayRhs){
        if (matrixArrayLhs[0].length != matrixArrayRhs.length)
            throw new IllegalArgumentException("The row count of the left matrix does not equal the column count of the right matrix");

        int[][] productMatrixArray = new int[matrixArrayLhs.length][matrixArrayRhs[0].length];

        for (int leftRowIndex = 0; leftRowIndex < matrixArrayLhs.length; leftRowIndex++) {
            for (int rightColIndex = 0; rightColIndex < matrixArrayRhs[0].length; rightColIndex++) {
                for (int sharedIndex = 0; sharedIndex < matrixArrayLhs[0].length; sharedIndex++) {
                    productMatrixArray[leftRowIndex][rightColIndex] +=
                            matrixArrayLhs[leftRowIndex][sharedIndex] * matrixArrayRhs[sharedIndex][rightColIndex];
                }
            }
        }
        return productMatrixArray;
    }
    /**
     * Private constructor to prevent instantiation of utility class
     */
    private MatrixUtility() {
        throw new IllegalStateException("Utility class");
    }
}
