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
public class SommeProduitElementListeTests extends MathTests {

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
        Double result = MathHelper.calculateSumProductElementBetweenList(null);
        assertNull(result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateSumProductElementBetweenList(new ArrayList(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);
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

        Double result = MathHelper.calculateSumProductElementBetweenList(data);
        assertNotNull(result);
        assertEquals(new Double(Double.MIN_VALUE * Double.MIN_VALUE), result);

        // Negative Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<Double>(1);
        column1.add(Double.NEGATIVE_INFINITY);

        column2 = new ArrayList<Double>(1);
        column2.add(Double.NEGATIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateSumProductElementBetweenList(data);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);
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

        Double result = MathHelper.calculateSumProductElementBetweenList(data);
        assertNotNull(result);
        assertEquals(new Double(Double.MAX_VALUE * Double.MAX_VALUE), result);

        // Positive Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<Double>(1);
        column1.add(Double.POSITIVE_INFINITY);

        column2 = new ArrayList<Double>(1);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateSumProductElementBetweenList(data);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);
    }

    @Test
    @Override
    public void testValide() {
        Double result = MathHelper.calculateSumProductElementBetweenList(getListTwoColumnCorrelation());
        assertNotNull(result);
        assertEquals(new Double(702904.4), result);
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

        Double result = MathHelper.calculateSumProductElementBetweenList(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        // Nan * number
        data = new ArrayList(2);

        column1 = new ArrayList<Double>(1);
        column1.add(Double.NaN);

        column2 = new ArrayList<Double>(1);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateSumProductElementBetweenList(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }
}
