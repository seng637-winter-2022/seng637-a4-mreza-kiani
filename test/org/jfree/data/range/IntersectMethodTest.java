package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.*;

import static org.junit.Assert.*;

public class IntersectMethodTest {
    private Range range;

    @BeforeClass
    public static void setUpBeforeClass() {
    }

    @Before
    public void setUp() throws Exception {
        range = new Range(-1, 1);
    }

    @Test
    public void aFullyIntersectionForSmallerNumbers() {
        assertTrue("[-0.5, +0.5] has intersection with [-1, +1]", range.intersects(-0.5, 0.5));
    }

    @Test
    public void aFullyIntersectionForLargerNumbers() {
        assertTrue("[-2, +2] has intersection with [-1, +1]", range.intersects(-2, 2));
    }

    @Test
    public void aPartialIntersectionWhenNumbersAreOnTheLeft() {
        assertTrue("[-1.5, +0.5] has intersection with [-1, +1]", range.intersects(-1.5, 0.5));
    }

    @Test
    public void aPartialIntersectionWhenNumbersAreOnTheRight() {
        assertTrue("[-0.5, +1.5] has intersection with [-1, +1]", range.intersects(-0.5, 1.5));
    }

    @Test
    public void aCloserPartialIntersectionWhenNumbersAreOnTheRight() {
        assertTrue("[0.9999, 1.001] has intersection with [-1, +1]", range.intersects(0.9999999, 1.000001));
    }

    @Test
    public void aCloserPartialIntersectionWhenNumbersAreOnTheLeft() {
        assertTrue("[-1.001, -0.9999] has intersection with [-1, +1]", range.intersects(-1.000001, -0.9999999));
    }

    @Test
    public void noIntersection() {
        assertFalse("[-2, -1.5] has no intersection with [-1, +1]", range.intersects(-2, -1.5));
    }

    @Test
    public void anInvalidIntersection() {
        assertFalse("[0.5, -0.5] is an invalid range", range.intersects(0.5, -0.5));
    }

    @Test
    public void aMarginalIntersection() {
        assertFalse("[-2, -1] has a marginal intersection with [-1, +1]", range.intersects(-2, -1));
    }

    @Test
    public void aRightMarginalIntersection() {
        assertFalse("[1, 2] has a marginal intersection with [-1, +1]", range.intersects(1, 2));
    }

    @Test
    public void aPartialNaNTest() {
        assertFalse("[null, -1] has no intersection with [-1, +1]", range.intersects(Double.NaN, 1));
    }

    @Test
    public void aFullyNaNTest() {
        assertFalse("[null, null] has no intersection with [-1, +1]", range.intersects(Double.NaN, Double.NaN));
    }

    @Test
    public void alternativeIntersectsMethod() {
        assertTrue("[-0.5, 0.5] has no intersection with [-1, +1]", range.intersects(new Range(-0.5, 0.5)));
    }
}