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

/**
 *
 * @author Zeldorine
 */
public class CorrelationTests extends MathTests {

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
        CalculationResult result = MathHelper.CalculateCorrelation(null);
        assertNotNull(result);
        assertNull(result.getCorrelation());
        assertNull(result.getEcartType());
        assertNull(result.getMoyenne());
        assertNull(result.getVariance());
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = MathHelper.CalculateCorrelation(new ArrayList(0));
        assertNotNull(result);
        assertNull(result.getCorrelation());
        assertNull(result.getEcartType());
        assertNull(result.getMoyenne());
        assertNull(result.getVariance());

        List<List<Double>> data = new ArrayList(2);
        data.add(new ArrayList(0));
        data.add(new ArrayList(0));

        result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertNotNull(result.getCorrelation());
        assertEquals(new Double(Double.NaN), result.getCorrelation());
        assertNull(result.getEcartType());
        assertNull(result.getMoyenne());
        assertNull(result.getVariance());
    }

    @Test
    @Override
    public void testBorneInferieure() {
        // Min Value
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<Double>(1);
        column1.add(Double.MIN_VALUE);

        List<Double> column2 = new ArrayList<Double>(1);
        column2.add(Double.MIN_VALUE);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getCorrelation());

        // Negative Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<Double>(1);
        column1.add(Double.NEGATIVE_INFINITY);

        column2 = new ArrayList<Double>(1);
        column2.add(Double.NEGATIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getCorrelation());
        
        CalculationResult testAbs = new CalculationResult(Double.NEGATIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), testAbs.getCorrelation());
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        // Max Value
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<Double>(1);
        column1.add(Double.MAX_VALUE);

        List<Double> column2 = new ArrayList<Double>(1);
        column2.add(Double.MAX_VALUE);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getCorrelation());

        // Positive Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<Double>(1);
        column1.add(Double.POSITIVE_INFINITY);

        column2 = new ArrayList<Double>(1);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getCorrelation());
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = MathHelper.CalculateCorrelation(getListTwoColumn());
        assertNotNull(result);
        assertEquals(new Double(0.9559205282352726), result.getCorrelation());
    }

    @Test
    @Override
    public void testNotANumberValue() {
        // NaN * NaN
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<Double>(1);
        column1.add(Double.NaN);

        List<Double> column2 = new ArrayList<Double>(1);
        column2.add(Double.NaN);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getCorrelation());

        // Nan * number
        data = new ArrayList(2);

        column1 = new ArrayList<Double>(1);
        column1.add(Double.NaN);

        column2 = new ArrayList<Double>(1);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getCorrelation());
    }
}
