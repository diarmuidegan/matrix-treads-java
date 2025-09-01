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
        MatrixUtility.elementsFrequencyDistribution(matrixArray);
        MatrixUtility.elementsFrequencyDistributionAlt(matrixArray);
    }
}
