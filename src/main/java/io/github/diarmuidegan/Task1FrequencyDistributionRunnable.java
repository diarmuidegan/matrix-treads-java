package io.github.diarmuidegan;

public class Task1FrequencyDistributionRunnable implements Runnable
{
    private final int[][] matrixArray;

    public Task1FrequencyDistributionRunnable(int[][] matrixArray)
    {
        this.matrixArray = matrixArray;
    }
    /**
     * Runs the frequency distribution
     */
    @Override
    public void run() {
        System.out.println("Running Task 1 Frequency Distribution Runnable");
    }
}
