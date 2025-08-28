package io.github.diarmuidegan;

import java.util.concurrent.Callable;

public class Task3MatrixMultiplyCallable implements Callable <int[][]> {


    private final int[][] matrixArrayLhs;
    private final int[][] matrixArrayRhs;

    public Task3MatrixMultiplyCallable(int[][] matrixArrayLhs, int[][] matrixArrayRhs)
    {
        if (matrixArrayLhs[0].length != matrixArrayRhs.length)
            throw new IllegalArgumentException("The row count of the left matrix does not equal the column count of the right matrix");

        this.matrixArrayLhs = matrixArrayLhs;
        this.matrixArrayRhs = matrixArrayRhs;
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public int[][] call() throws Exception {

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
}
