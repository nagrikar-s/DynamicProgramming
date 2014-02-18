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
        int[] sumTillIndex = new int[array.length];
        sumTillIndex[0] = array[0];
        for (int i = 1; i < array.length; i++)
        {
            sumTillIndex[i] = max(sumTillIndex[i - 1] + array[i], array[i]);
            maxSum = maxSum > sumTillIndex[i] ? maxSum : sumTillIndex[i];
        }
        return maxSum;
    }

    private SumResult maxSumSubSequenceResult(int[] array)
    {
        SumResult result = new SumResult();
        int maxSum = array[0];
        result.setStartIndex(0);
        result.setEndIndex(0);
        result.setSum(maxSum);
        int[] sumTillIndex = new int[array.length];
        sumTillIndex[0] = array[0];
        for (int i = 1; i < array.length; i++)
        {
            sumTillIndex[i] = max(sumTillIndex[i - 1] + array[i], array[i]);
            if (sumTillIndex[i] == array[i])
            {
                result.setStartIndex(i);
            }
            else
            {
                result.setEndIndex(i);
            }
            maxSum = maxSum < sumTillIndex[i] ? sumTillIndex[i] : maxSum;
            result.setSum(maxSum);
        }
        result.setEndIndex(result.getStartIndex() > result.getEndIndex() ? result.getStartIndex() : result.getEndIndex());
        return result;
    }

    int max(int a, int b)
    {
        return a > b ? a : b;
    }

    public static void main(String[] args)
    {
        int[] array = { 1, 2, -4, 5, -8, -3, 10, -1, 4, 6, -20, 50 };
        MaximumSumSubSequence maxSum = new MaximumSumSubSequence();
        System.out.println("Max sum=" + maxSum.maxSumSubSequenceResult(array));
        System.out.println("Max sum=" + maxSum.maxSumSubSequenceResult(new int[] { -1, 4, 5, -8, 10, -8, 30 }));
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
}