package com.hinge.arrayproblems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by snehanagrikar on 12/19/16.
 */
public class MaximumSumSubMatrixTest {
    MaximumSumSubMatrix tester;
    MatrixResult expectedResult;

    @Before
    public void setup() {
        tester = new MaximumSumSubMatrix();
        expectedResult = new MatrixResult();
    }
    @Test
    public void testMaxSumSubSeq() {
        expectedResult.setLeftIndex(1);
        expectedResult.setRightIndex(2);
        expectedResult.setUpIndex(0);
        expectedResult.setDownIndex(2);
        expectedResult.setSum(22);
        Assert.assertEquals(expectedResult,
                tester.maxSumSubMatrix(new int[][]{{-1,2,-9},{2,7,5},{3,-3,8},{-5,-7,-10}}));
    }

    @Test
    public void testMaxSumSubSeq2() {
        expectedResult.setLeftIndex(1);
        expectedResult.setRightIndex(3);
        expectedResult.setUpIndex(1);
        expectedResult.setDownIndex(3);
        expectedResult.setSum(18);
        Assert.assertEquals(expectedResult,
                tester.maxSumSubMatrix(new int[][]{{2,0,2,-3},{1,6,-2,3},{-3,3,-1,1},{-4,4,4,0},{5,1,-5,3}}));
    }
}
