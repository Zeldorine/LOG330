package ets.log330.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Zeldorine
 */
public class EcartTypeTests extends MathTests {

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
        Double result = MathHelper.calculateEcartType(null);
        assertNull(result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateEcartType(0.0);
        assertNotNull(result);
        assertEquals(new Double(0), result);
    }

    @Test
    @Override
    public void testBorneInferieure() {
        Double result = MathHelper.calculateEcartType(Double.MIN_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Math.sqrt(Double.MIN_VALUE)), result);

        result = MathHelper.calculateEcartType(Double.NEGATIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        Double result = MathHelper.calculateEcartType(Double.MAX_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Math.sqrt(Double.MAX_VALUE)), result);

        result = MathHelper.calculateEcartType(Double.POSITIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);
    }

    @Test
    @Override
    public void testValide() {
        Double result = MathHelper.calculateEcartType(Double.NaN);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }

    @Test
    @Override
    public void testNotANumberValue() {
        Double result = MathHelper.calculateEcartType(new Double(391417.8777777777));
        assertNotNull(result);
        assertEquals(new Double(625.6339806770231), result);
    }
}
