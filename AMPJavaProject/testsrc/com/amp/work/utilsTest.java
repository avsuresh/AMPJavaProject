package com.amp.work;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class utilsTest {
    private utils utilsUnderTest;
    @Before
    public void setUp() {
        utilsUnderTest = new utils();
    }

    @org.junit.Test
    public void testIsArgumentsValid() {
        String[] source={"New York", "Boston", "cities.txt"};
        assertTrue(utilsUnderTest.isArgumentsValid(source));
    }

    @org.junit.Test
    public void testIsArgumentsNotValid() {
        String[] source={"New York", "Boston"};
        assertFalse(utilsUnderTest.isArgumentsValid(source));
    }

    @org.junit.Test
    public void testIsArgumentsEmpty() {
        String[] source={};
        assertFalse(utilsUnderTest.isArgumentsValid(source));
    }
}