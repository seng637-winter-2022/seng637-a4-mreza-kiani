package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ConstructorTest {
    @Test
    public void aCorrectConstructor() {
        Range r1 = new Range(-1, -0.5);
        assertEquals(r1.getLength(), 0.5, 0.05);
    }

    @Test(expected = IllegalArgumentException.class)
    public void anIllegalConstructor() {
        new Range(1, -1);
    }

    @Test
    public void aComparison() {
        Range r1 = new Range(-1, -0.5);
        assertNotEquals(r1, 5);
    }

    @Test
    public void aFalseComparison() {
        Range r1 = new Range(-1, -0.5);
        Range r2 = new Range(-2, -0.5);
        assertNotEquals(r1, r2);
    }

    @Test
    public void hashCodeCheck() {
        Range r1 = new Range(-1, -0.5);
        Assert.assertEquals(r1.hashCode(), 2114977792);
    }

    @Test
    public void toStringCheck() {
        Range r1 = new Range(1, 1);
        Assert.assertEquals(r1.toString(), "Range[1.0,1.0]");
    }
}