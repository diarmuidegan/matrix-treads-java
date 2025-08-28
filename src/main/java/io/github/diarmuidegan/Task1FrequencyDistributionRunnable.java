package io.github.diarmuidegan;

import java.util.*;
import java.util.stream.Collectors;

public class Task1FrequencyDistributionRunnable implements Runnable {
    private final int[][] matrixArray;

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

        ArrayList<Integer> keys = new ArrayList<>(frequency.keySet());
        Collections.sort(keys);

        for (int key : keys) {
            long value = frequency.get(key);
            String timePlural = (value == 1) ? "time" : "times";
            System.out.printf("%d appears %d %s in the matrix.%n", key, value, timePlural);
        }
    }
}
