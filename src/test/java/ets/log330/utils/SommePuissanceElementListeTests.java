package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;
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
public class SommePuissanceElementListeTests extends MathTests {

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
        Double result = MathHelper.calculateSumPowElementList(null, 0);
        assertNull(result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateSumPowElementList(new ArrayList<Double>(0), 0);
        assertNotNull(result);
        assertEquals(new Double(0), result);
    }

    @Test
    @Override
    public void testBorneInferieure() {
        List<Double> data = new ArrayList<Double>(1);
        data.add(Double.MIN_VALUE);
        Double result = MathHelper.calculateSumPowElementList(data, 0);
        assertNotNull(result);
        assertEquals(new Double(1), result);

        result = MathHelper.calculateSumPowElementList(data, 1);
        assertNotNull(result);
        assertEquals(new Double(Double.MIN_VALUE), result);

        result = MathHelper.calculateSumPowElementList(data, -1);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);

        result = MathHelper.calculateSumPowElementList(data, Integer.MIN_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);

        data = new ArrayList<Double>(1);
        data.add(Double.NEGATIVE_INFINITY);
        result = MathHelper.calculateSumPowElementList(data, 0);
        assertNotNull(result);
        assertEquals(new Double(1), result);

        result = MathHelper.calculateSumPowElementList(data, -1);
        assertNotNull(result);
        assertEquals(new Double(0), result);

        result = MathHelper.calculateSumPowElementList(data, 1);
        assertNotNull(result);
        assertEquals(new Double(Double.NEGATIVE_INFINITY), result);

        result = MathHelper.calculateSumPowElementList(data, 2);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        List<Double> data = new ArrayList<Double>(1);
        data.add(Double.MAX_VALUE);
        Double result = MathHelper.calculateSumPowElementList(data, 0);
        assertNotNull(result);
        assertEquals(new Double(1), result);

        result = MathHelper.calculateSumPowElementList(data, 1);
        assertNotNull(result);
        assertEquals(new Double(Double.MAX_VALUE), result);

        result = MathHelper.calculateSumPowElementList(data, -1);
        assertNotNull(result);
        assertEquals(new Double("5.562684646268003E-309"), result);

        result = MathHelper.calculateSumPowElementList(data, Integer.MAX_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);

        data = new ArrayList<Double>(1);
        data.add(Double.POSITIVE_INFINITY);
        result = MathHelper.calculateSumPowElementList(data, 0);
        assertNotNull(result);
        assertEquals(new Double(1), result);

        result = MathHelper.calculateSumPowElementList(data, -1);
        assertNotNull(result);
        assertEquals(new Double(0), result);

        result = MathHelper.calculateSumPowElementList(data, 1);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result);
    }

    @Test
    @Override
    public void testValide() {
        List<List<Double>> data = getListTwoColumnCorrelation();
        Double result = MathHelper.calculateSumPowElementList(data.get(0), 1);
        assertNotNull(result);
        assertEquals(new Double(6389.0), result);

        result = MathHelper.calculateSumPowElementList(data.get(0), 2);
        assertNotNull(result);
        assertEquals(new Double(7604693.0), result);

        result = MathHelper.calculateSumPowElementList(data.get(1), 1);
        assertNotNull(result);
        assertEquals(new Double(594.2), result);

        result = MathHelper.calculateSumPowElementList(data.get(1), 2);
        assertNotNull(result);
        assertEquals(new Double(67771.51999999999), result);
    }

    @Test
    @Override
    public void testNotANumberValue() {
        List<Double> data = new ArrayList<Double>(1);
        data.add(Double.NaN);
        Double result = MathHelper.calculateSumPowElementList(data, 0);
        assertNotNull(result);
        assertEquals(new Double(1), result);

        result = MathHelper.calculateSumPowElementList(data, -1);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        result = MathHelper.calculateSumPowElementList(data, 1);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }
}
