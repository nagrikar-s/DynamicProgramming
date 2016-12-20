package com.hinge.arrayproblems;

/**
 * Given an integer array, find the sub array which has maximum sum. The array
 * would have both negative and positive numbers.
 * 
 * @author naynish
 * 
 */
public class MaximumSumSubSequence
{
    private int maxSumSubSequence(int[] array)
    {
        int maxSum = array[0];
        //int[] sumTillIndex = new int[array.length];
        int sumTillIndex = array[0];
        for (int i = 1; i < array.length; i++)
        {
          //  sumTillIndex[i] = max(sumTillIndex[i - 1] + array[i], array[i]);
            sumTillIndex = max(sumTillIndex + array[i], array[i]);
            maxSum = maxSum > sumTillIndex ? maxSum : sumTillIndex;
        }
        return maxSum;
    }

    protected SumResult maxSumSubSequenceResult(int[] array)
    {
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array cannot be null or empty");
        }
        SumResult result = new SumResult();
        int maxSum = array[0];
        result.setStartIndex(0);
        result.setEndIndex(0);
        result.setSum(maxSum);
        int sumTillIndex = array[0];
        if(array.length == 1){
            return result;
        }
        for (int i = 1; i < array.length; i++)
        {
            sumTillIndex = max(sumTillIndex + array[i], array[i]);
            maxSum = maxSum < sumTillIndex ? sumTillIndex : maxSum;
            if (sumTillIndex == array[i])
            {
                result.setStartIndex(i);
            }
            else if(maxSum == sumTillIndex)
            {
                result.setEndIndex(i);
            }
            result.setSum(maxSum);
        }
        result.setEndIndex(result.getStartIndex() > result.getEndIndex() ? result.getStartIndex() : result.getEndIndex());
        return result;
    }

    int max(int a, int b)
    {
        return a > b ? a : b;
    }
}

class SumResult
{
    int startIndex;
    int endIndex;
    int sum;

    public int getStartIndex()
    {
        return startIndex;
    }

    public int getEndIndex()
    {
        return endIndex;
    }

    public int getSum()
    {
        return sum;
    }

    public void setStartIndex(int startIndex)
    {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex)
    {
        this.endIndex = endIndex;
    }

    public void setSum(int sum)
    {
        this.sum = sum;
    }

    @Override
    public String toString()
    {
        return "SumResult [startIndex=" + startIndex + ", endIndex=" + endIndex + ", sum=" + sum + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SumResult)) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        SumResult thatResult = (SumResult) obj;
        if(this.startIndex == thatResult.startIndex &&
                this.endIndex == thatResult.endIndex &&
                this.sum == thatResult.sum){
            return true;
        }
        return false;
    }
}