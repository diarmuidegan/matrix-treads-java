package io.github.diarmuidegan;

import java.util.concurrent.Callable;

public class Task3MatrixMultiplyCallable implements Callable <int[][]> {


    private final int[][] matrixArrayLhs;
    private final int[][] matrixArrayRhs;

    public Task3MatrixMultiplyCallable(int[][] matrixArrayLhs, int[][] matrixArrayRhs)
    {
        // matrixArray.length is the row count of a matrix
        // matrixArray[0].length is the column count of a matrix
        if (matrixArrayLhs[0].length != matrixArrayRhs.length)
            throw new IllegalArgumentException("The row count of the left matrix does not equal the column count of the right matrix");

        this.matrixArrayLhs = matrixArrayLhs;
        this.matrixArrayRhs = matrixArrayRhs;
    }
    /**
     * Multiplies two matrices together and returns the product matrix
     * @return The product matrix
     * @throws Exception if an error occurs
     */
    @Override
    public int[][] call() throws Exception {
        return MatrixUtility.multiplyMatrices(matrixArrayLhs, matrixArrayRhs);
    }
}
