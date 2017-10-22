package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
public class RegressionLineaireB0Tests extends MathTests {

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
        Double result = MathHelper.calculateRegressionLineaireB0(null, null, null);
        assertNull(result);

        result = MathHelper.calculateRegressionLineaireB0(null, null, 1.0);
        assertNull(result);

        result = MathHelper.calculateRegressionLineaireB0(null, 1.0, null);
        assertNull(result);

        result = MathHelper.calculateRegressionLineaireB0(1.0, null, null);
        assertNull(result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateRegressionLineaireB0(new Double(0), new Double(0), new Double(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);
    }

    @Test
    @Override
    public void testBorneInferieure() {
        // Min Value
        Double result = MathHelper.calculateRegressionLineaireB0(Double.MIN_VALUE, new Double(0), new Double(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), Double.MIN_VALUE, new Double(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), new Double(0), Double.MIN_VALUE);
        assertNotNull(result);
        assertEquals(new Double(4.9E-324), result);

        // Negative Infinity
        result = MathHelper.calculateRegressionLineaireB0(Double.NEGATIVE_INFINITY, new Double(0), new Double(0));
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), Double.NEGATIVE_INFINITY, new Double(0));
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), new Double(0), Double.NEGATIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.NEGATIVE_INFINITY), result);
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        // Max Value
        Double result = MathHelper.calculateRegressionLineaireB0(Double.MAX_VALUE, new Double(0), new Double(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), Double.MAX_VALUE, new Double(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), new Double(0), Double.MAX_VALUE);
        assertNotNull(result);
        assertEquals(new Double(1.7976931348623157E308), result);

        // Positive Infinity
        result = MathHelper.calculateRegressionLineaireB0(Double.POSITIVE_INFINITY, new Double(0), new Double(0));
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), Double.POSITIVE_INFINITY, new Double(0));
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), new Double(0), Double.POSITIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);
    }

    @Test
    @Override
    public void testValide() {
        Double result = MathHelper.calculateRegressionLineaireB0(0.52725656, 382.8, 638.9);
        assertNotNull(result);
        assertEquals(new Double(437.06618883199997), result);
    }

    @Test
    @Override
    public void testNotANumberValue() {
        Double result = MathHelper.calculateRegressionLineaireB0(Double.NaN, new Double(0), new Double(0));
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), Double.NaN, new Double(0));
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        result = MathHelper.calculateRegressionLineaireB0(new Double(0), new Double(0), Double.NaN);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }
}
