package win.yulongsun.androidsample.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import win.yulongsun.androidsample.test.Calculator;

import static org.junit.Assert.*;

/**
 * @Project AndroidSample
 * @Packate win.yulongsun.androidsample.test
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/29
 * @Version 1.0.0
 * @Description
 */
public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSum() throws Exception {
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void testSubtract() throws Exception {

    }

    @Test
    public void testDivide() throws Exception {

    }

    @Test
    public void testMultiply() throws Exception {

    }
}