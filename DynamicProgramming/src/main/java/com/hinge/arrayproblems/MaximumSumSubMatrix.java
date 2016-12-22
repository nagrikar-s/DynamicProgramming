package com.hinge.arrayproblems;

/**
 * Given an 2D matrix of integers (positive and/or negative) find the sub matrix with maximum sum.
 * L=R          arr[]
 * | -5  2  3 |  |-5 |
 * |  7 -3  5 |  | 7 |
 * |  1  3 -8 |  | 1 |
 * <p>
 * Send the arr[] to the algo that finds max sum subsequence in an array.
 * Set the maxLeft = L, maxRight=R, maxTop = start index of max sum sub-sequence
 * and maxDown = end index of max sum sub-sequence
 * maxSum is assigned the maxSum of subsequence if it is greater than previous maxSum.
 * <p>
 * In the next step, increment R and add the column into arr[] and repeat above.
 * L  R       arr[] + R
 * | -5  2  3 |  |-5+2 |
 * |  7 -3  5 |  | 7-3 |
 * |  1  3 -8 |  | 1+3 |
 * <p>
 * Keep incrementing R for all columns.
 * Then increment L and repeat the process from start until L reaches the last column.
 * L=R      arr[]
 * | -5  2  3 |  | 2 |
 * |  7 -3  5 |  |-3 |
 * |  1  3 -8 |  | 3 |
 * <p>
 * Time complexity = O(n^3)
 *
 * @author snehanagrikar
 */
public class MaximumSumSubMatrix {

    private final MaximumSumSubSequence arrSubSeq = new MaximumSumSubSequence();

    public MatrixResult maxSumSubMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Provided matrix should not be null");
        }

        int maxSum = matrix[0][0];
        int maxLeftCol = -1, maxRightCol = -1, maxTopRow = -1, maxDownRow = -1;
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        if (numRows == 1) { // avoid calling maxSumSubsequence on single number array. instead just pass the whole array.
            SumResult result = arrSubSeq.maxSumSubSequenceResult(matrix[0]);
            maxSum = result.sum;
            maxLeftCol = result.startIndex;
            maxRightCol = result.endIndex;
            maxTopRow = 0;
            maxDownRow = 0;
        } else {
            int[] array = new int[numRows];
            for (int leftCol = 0; leftCol < numCols; leftCol++) {
                for (int rightCol = leftCol; rightCol < numCols; rightCol++) {
                    for (int i = 0; i < numRows; i++) {
                        array[i] = rightCol == leftCol ? matrix[i][rightCol] : array[i] + matrix[i][rightCol];
                    }
                    SumResult result = arrSubSeq.maxSumSubSequenceResult(array);
                    if (result.sum >= maxSum) {
                        maxSum = result.sum;
                        maxLeftCol = leftCol;
                        maxRightCol = rightCol;
                        maxTopRow = result.startIndex;
                        maxDownRow = result.endIndex;
                    }
                }
            }
        }
        return new MatrixResult(maxLeftCol, maxRightCol, maxTopRow, maxDownRow, maxSum);
    }
}

class MatrixResult {
    private final int leftIndex;
    private final int rightIndex;
    private final int upIndex;
    private final int downIndex;
    private final int sum;

    public MatrixResult(int leftIndex, int rightIndex, int upIndex, int downIndex, int sum) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.upIndex = upIndex;
        this.downIndex = downIndex;
        this.sum = sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MatrixResult)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        MatrixResult thatResult = (MatrixResult) obj;
        if (this.leftIndex == thatResult.leftIndex &&
                this.rightIndex == thatResult.rightIndex &&
                this.upIndex == thatResult.upIndex &&
                this.downIndex == thatResult.downIndex &&
                this.sum == thatResult.sum) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MatrixResult{" +
                "leftIndex=" + leftIndex +
                ", rightIndex=" + rightIndex +
                ", upIndex=" + upIndex +
                ", downIndex=" + downIndex +
                ", sum=" + sum +
                '}';
    }
}
