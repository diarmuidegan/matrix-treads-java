package io.github.diarmuidegan;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Task 2: Element Statistics Callable
 * This class implements Callable to calculate the percentage of elements in a matrix that are less than or equal to a specified number.
 */
public class Task2ElementStatsCallable implements Callable<Double>
{
    private final int[][] matrixArray;
    private final int number;

    public Task2ElementStatsCallable(int[][] matrixArray, int number)
    {
        this.matrixArray = matrixArray;
        this.number = number;
    }
    /**
     * Calculates the percentage of elements in the matrix that are less than or equal to the specified number.
     * @return The percentage of elements less than or equal to the specified number.
     * @throws Exception if an error occurs.
     */
    @Override
    public Double call() throws Exception {
        int total = matrixArray.length * matrixArray[0].length;
        int count = countLessOrEqual(matrixArray, number);
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
}
