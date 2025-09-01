package io.github.diarmuidegan;

import java.util.*;

public class Task1FrequencyDistributionAltRunnable implements Runnable {
    private final int[][] matrixArray;

    public Task1FrequencyDistributionAltRunnable(int[][] matrixArray) {
        this.matrixArray = matrixArray;
    }

    /**
     * Runs the frequency distribution
     */
    @Override
    public void run() {
        HashMap<Integer, Integer> frequencyHashMap = getFrequencyHashMap(matrixArray);
        printFrequencyMap(frequencyHashMap);
    }

    /**
     * Prints a frequency Map values count;
     * @param frequencyMap the map to print.
     */
    private static void printFrequencyMap(Map<Integer, Integer> frequencyMap) {
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int countValue = entry.getValue();
            String timePlural = countValue == 1 ? "time" : "times";

            System.out.printf("%d appears %d %s in the matrix.%n", entry.getKey(), countValue, timePlural);
        }
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
}
