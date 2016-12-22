package com.hinge.arrayproblems;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


/**
 * Created by snehanagrikar on 12/19/16.
 */
public class MaximumSumSubMatrixTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private MaximumSumSubMatrix maximumSumSubMatrix;

    @Before
    public void setup() {
        maximumSumSubMatrix = new MaximumSumSubMatrix();
    }

    @Test
    public void testMaxSumSubSeq() {
        assertEquals(new MatrixResult(0, 2, 1, 2, 22),
                maximumSumSubMatrix.maxSumSubMatrix(new int[][]{
                        {-1, 2, -9},
                        {2, 7, 5},
                        {3, -3, 8},
                        {-5, -7, -10}
                }));
    }

    @Test
    public void testMaxSumSubSeq2() {
        assertEquals(new MatrixResult(1, 3, 1, 3, 18),
                maximumSumSubMatrix.maxSumSubMatrix(new int[][]{
                        {2, 0, 2, -3},
                        {1, 6, -2, 3},
                        {-3, 3, -1, 1},
                        {-4, 4, 4, 0},
                        {5, 1, -5, 3}
                }));
    }

    @Test
    public void testMaxSumSubSeq3() {
        assertEquals(new MatrixResult(2, 2, 4, 4, -1),
                maximumSumSubMatrix.maxSumSubMatrix(new int[][]{
                        {-1, -1, -1},
                        {-1, -1, -1},
                        {-1, -1, -1},
                        {-1, -1, -1},
                        {-1, -1, -1}
                }));
    }

    @Test
    public void testMaxSumSubSeqSingleColumnMatrix() {
        assertEquals(new MatrixResult(0, 0, 1, 3, 10),
                maximumSumSubMatrix.maxSumSubMatrix(new int[][]{
                        {-1},
                        {5},
                        {-1},
                        {6},
                        {-8}
                }));
    }

    @Test
    public void testMaxSumSubSeqSingleRowMatrix() {
        assertEquals(new MatrixResult(5, 5, 0, 0, 12),
                maximumSumSubMatrix.maxSumSubMatrix(new int[][]{
                        {-1, 3, 4, -5, -2, 12, -2},
                }));
    }

    @Test
    public void testNullMatrix() {
        expectedException.expect(IllegalArgumentException.class);
        maximumSumSubMatrix.maxSumSubMatrix(null);
    }

    @Test
    public void testSingletonMatrix() {
        assertEquals(new MatrixResult(0, 0, 0, 0, 4),
                maximumSumSubMatrix.maxSumSubMatrix(new int[][]{{4}}));
    }
}
