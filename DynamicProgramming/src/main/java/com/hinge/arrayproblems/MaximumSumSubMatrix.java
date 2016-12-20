package com.hinge.arrayproblems;

/**
 * Created by snehanagrikar on 12/19/16.
 */
public class MaximumSumSubMatrix {
    public MatrixResult maxSumSubMatrix(int[][] matrix) {
        int maxSum = matrix[0][0];
        int colLen = matrix[0].length;
        int[] array = new int[colLen];
        MatrixResult matResult = new MatrixResult();
        MaximumSumSubSequence arrSubSeq = new MaximumSumSubSequence();

        for (int left = 0; left < matrix.length; left++) {
            for (int right = left; right < colLen; right++) {
                for (int i = 0; i < colLen; i++) {
                    array[i] = right == left ? matrix[right][i] : array[i] + matrix[right][i];
                }
                SumResult result = arrSubSeq.maxSumSubSequenceResult(array);
                if (result.sum > maxSum) {
                    maxSum = result.sum;
                    matResult.setLeftIndex(left);
                    matResult.setRightIndex(right);
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

    public void setLeftIndex(int LeftIndex) {
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
}
