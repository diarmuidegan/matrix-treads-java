package io.github.diarmuidegan;

import java.util.concurrent.Callable;

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
     * @return
     * @throws Exception
     */
    @Override
    public Double call() throws Exception {
        return 0.0;
    }
}
