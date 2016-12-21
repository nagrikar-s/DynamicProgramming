package com.hinge.arrayproblems;

/**
 * Created by snehanagrikar on 12/19/16.
 */
public class MaximumSumSubMatrix {
    public MatrixResult maxSumSubMatrix(int[][] matrix) {
        int maxSum = matrix[0][0];
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[] array = new int[numRows];
        MatrixResult matResult = new MatrixResult();
        MaximumSumSubSequence arrSubSeq = new MaximumSumSubSequence();

        for (int leftCol = 0; leftCol < numCols; leftCol++) {
            for (int rightCol = leftCol; rightCol < numCols; rightCol++) {
                for (int i = 0; i < numRows; i++) {
                    array[i] = rightCol == leftCol ? matrix[i][rightCol] : array[i] + matrix[i][rightCol];
                }
                SumResult result = arrSubSeq.maxSumSubSequenceResult(array);
                if (result.sum >= maxSum) {
                    maxSum = result.sum;
                    matResult.setLeftIndex(leftCol);
                    matResult.setRightIndex(rightCol);
                    matResult.setUpIndex(result.startIndex);
                    matResult.setDownIndex(result.endIndex);
                    matResult.setSum(maxSum);
                }
            }
        }
        return matResult;
    }
}

class MatrixResult {

    private int leftIndex;
    private int rightIndex;
    private int upIndex;
    private int downIndex;
    private int sum;

    public int getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    public int getUpIndex() {
        return upIndex;
    }

    public void setUpIndex(int upIndex) {
        this.upIndex = upIndex;
    }

    public int getDownIndex() {
        return downIndex;
    }

    public void setDownIndex(int downIndex) {
        this.downIndex = downIndex;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
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
