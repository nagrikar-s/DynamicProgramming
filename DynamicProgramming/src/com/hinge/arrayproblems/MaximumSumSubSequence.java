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
        for (int i = 1; i < array.length; i++) {
            sumTillIndex[i] = max(sumTillIndex[i - 1] + array[i], array[i]);
            maxSum = maxSum > sumTillIndex[i] ? maxSum : sumTillIndex[i];
        }
        return maxSum;
    }

    int max(int a, int b)
    {
        return a > b ? a : b;
    }

    public static void main(String[] args)
    {
        int[] array = { 1, 2, -4, 5, -8, -3, 10, -1, 4, 6, -20 };
        MaximumSumSubSequence maxSum = new MaximumSumSubSequence();
        System.out.println("Max sum=" + maxSum.maxSumSubSequence(array));
    }
}
