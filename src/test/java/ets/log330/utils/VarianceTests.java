package ets.log330.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Zeldorine
 */
public class VarianceTests extends MathTests {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Override
    public void testNullValue() {
        Double result = MathHelper.calculateVariance(null, -1);
        assertNull(result);
        
        result = MathHelper.calculateVariance(512.0, -1);
        assertNull(result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateVariance(0.0, 2);
        assertNotNull(result);
        assertEquals(new Double(0), result);
        
        result = MathHelper.calculateVariance(0.0, 0);
        assertNull(result);
    }

    @Test
    @Override
    public void testNotANumberValue() {
        Double result = MathHelper.calculateVariance(Double.NaN, 2);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }

    @Test
    @Override
    public void testBorneInferieure() {
        Double result = MathHelper.calculateVariance(Double.MIN_VALUE, 2);
        assertNotNull(result);
        assertEquals(new Double(Double.MIN_VALUE), result);

        Double resultInfinityNeg = MathHelper.calculateVariance(Double.NEGATIVE_INFINITY, 2);
        assertNotNull(resultInfinityNeg);
        assertEquals(new Double(Double.NEGATIVE_INFINITY), resultInfinityNeg);
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        Double resultMax = MathHelper.calculateVariance(Double.MAX_VALUE, 2);
        assertNotNull(resultMax);
        assertEquals(new Double(Double.MAX_VALUE), resultMax);

        Double resultInfinity = MathHelper.calculateVariance(Double.POSITIVE_INFINITY, 2);
        assertNotNull(resultInfinity);
        assertEquals(new Double(Double.POSITIVE_INFINITY), resultInfinity);
    }

    @Test
    @Override
    public void testValide() {
        Double result = MathHelper.calculateVariance(3522760.9, 10);
        assertNotNull(result);
        assertEquals(new Double(391417.8777777777), result);
    }
}
