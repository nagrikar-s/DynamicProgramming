package com.hinge.arrayproblems;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by snehanagrikar on 12/19/16.
 */
public class MaximumSumSubSequenceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    MaximumSumSubSequence tester;
    SumResult expectedResult;

    @Before
    public void setup() {
        tester = new MaximumSumSubSequence();
        expectedResult = new SumResult();
    }

    @Test
    public void testMaxSumSubSeq() {
        int[] array = {1, 2, -4, 5, -8, -3, 10, -1, 4, 6, -20, 50};
        expectedResult.setStartIndex(11);
        expectedResult.setEndIndex(11);
        expectedResult.setSum(50);
        assertEquals(expectedResult, tester.maxSumSubSequenceResult(array));
    }

    @Test
    public void testMaxSumSubSeq2() {
        expectedResult.setStartIndex(1);
        expectedResult.setEndIndex(6);
        expectedResult.setSum(33);
        assertEquals(expectedResult, tester.maxSumSubSequenceResult(new int[]{-1, 4, 5, -8, 10, -8, 30}));
    }

    @Test
    public void testMaxSumSubSeq3() {
        expectedResult.setStartIndex(1);
        expectedResult.setEndIndex(4);
        expectedResult.setSum(20);
        assertEquals(expectedResult, tester.maxSumSubSequenceResult(new int[]{-5, 2, 7, -1, 12}));
    }

    @Test
    public void testNullInput() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("array cannot be null or empty");
        tester.maxSumSubSequenceResult(null);
    }

    @Test
    public void testEmptyArray() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("array cannot be null or empty");
        tester.maxSumSubSequenceResult(new int[]{});
    }

    @Test
    public void testSingleIntArray() {
        expectedResult.setStartIndex(0);
        expectedResult.setEndIndex(0);
        expectedResult.setSum(1);
        assertEquals(expectedResult, tester.maxSumSubSequenceResult(new int[]{1}));
    }

    @Test
    public void testNegativeArray() {
        expectedResult.setStartIndex(4);
        expectedResult.setEndIndex(4);
        expectedResult.setSum(-1);
        assertEquals(expectedResult, tester.maxSumSubSequenceResult(new int[]{-5, -1, -2, -8, -1}));
    }

    @Test
    public void testZerosArray() {
        expectedResult.setStartIndex(2);
        expectedResult.setEndIndex(2);
        expectedResult.setSum(0);
        assertEquals(expectedResult, tester.maxSumSubSequenceResult(new int[]{0, 0, 0}));
    }

    @Test
    public void testNegativeOneArray() {
        expectedResult.setStartIndex(2);
        expectedResult.setEndIndex(2);
        expectedResult.setSum(-1);
        assertEquals(expectedResult, tester.maxSumSubSequenceResult(new int[]{-1, -1, -1}));
    }
}
