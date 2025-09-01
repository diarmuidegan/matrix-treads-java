package io.github.diarmuidegan;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Task 1: Frequency Distribution Runnable
 * This class implements Runnable to calculate and print the frequency distribution of elements in a 2D matrix.
 */
public class Task1FrequencyDistributionRunnable implements Runnable {
    /**
     * The matrix to get frequency distribution of
     */
    private final int[][] matrixArray;

    /**
     * Constructor
     * @param matrixArray the matrix to get frequency distribution of
     */
    public Task1FrequencyDistributionRunnable(int[][] matrixArray) {
        this.matrixArray = matrixArray;
    }
    /**
     * Runs the frequency distribution
     */
    @Override
    public void run() {
        Map<Integer, Long> frequency = Arrays.stream(matrixArray)
                .flatMapToInt((Arrays::stream))
                .boxed()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));

        printFrequencyMap(frequency);
    }

    /**
     * Prints a frequency Map values count;
     * @param frequencyMap the map to print.
     */
    private static void printFrequencyMap(Map<Integer, Long> frequencyMap)
    {
        var keys = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(keys);

        for (int key : keys) {
            long value = frequencyMap.get(key);
            String timePlural = (value == 1) ? "time" : "times";
            System.out.printf("%d appears %d %s in the matrix.%n", key, value, timePlural);
        }
    }
}
