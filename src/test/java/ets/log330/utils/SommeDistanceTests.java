package ets.log330.utils;

import static ets.log330.utils.MathTests.data;
import java.util.ArrayList;
import java.util.Collections;
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
public class SommeDistanceTests extends MathTests {

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
        Double result = MathHelper.calculateSommeDistance(null);
        assertNull(result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateSommeDistance(new ArrayList<Double>(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);
    }

    @Test
    @Override
    public void testNotANumberValue() {
        List<Double> nan = new ArrayList<Double>(1);
        nan.add(Double.NaN);

        Double result = MathHelper.calculateSommeDistance(nan);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        nan.add(Double.parseDouble("3.162"));
        result = MathHelper.calculateSommeDistance(nan);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }

    @Test
    @Override
    public void testBorneInferieure() {
        List data = new ArrayList<Double>(5);
        data.add(new Double(1));
        data.add(new Double(1));
        data.add(new Double(1));
        data.add(new Double(1));
        data.add(new Double(1));

        Double result = MathHelper.calculateSommeDistance(data);
        assertNotNull(result);
        assertEquals(new Double(5), result);

        List<Double> infinityNegative = new ArrayList<Double>(1);
        infinityNegative.add(Double.NEGATIVE_INFINITY);
        infinityNegative.add(Double.NEGATIVE_INFINITY);
        Double resultInfinityNeg = MathHelper.calculateSommeDistance(infinityNegative);
        assertNotNull(resultInfinityNeg);
        assertEquals(new Double(Double.NEGATIVE_INFINITY), resultInfinityNeg);

        List<Double> infinityNegative2 = new ArrayList<Double>(0);
        infinityNegative2.add(Double.NEGATIVE_INFINITY);
        infinityNegative2.add(Double.NEGATIVE_INFINITY);
        Double resultInfinityNeg2 = MathHelper.calculateSommeDistance(infinityNegative2);
        assertNotNull(resultInfinityNeg2);
        assertEquals(new Double(Double.NEGATIVE_INFINITY), resultInfinityNeg2);

        List<Double> minValue = new ArrayList<Double>(2);
        minValue.add(Double.MIN_VALUE);
        minValue.add(Double.MIN_VALUE);
        Double resultMinValue = MathHelper.calculateSommeDistance(minValue);
        assertNotNull(resultMinValue);
        assertEquals(new Double(Double.MIN_VALUE * 2), resultMinValue);
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);

        Double result = MathHelper.calculateSommeDistance(data);
        assertNotNull(result);
        assertEquals(5120, data.size());
        assertEquals(new Double(3271168.0), result);

        List<Double> maxValues = new ArrayList<Double>(1);
        maxValues.add(Double.MAX_VALUE);
        maxValues.add(Double.MAX_VALUE);
        Double resultMax = MathHelper.calculateSommeDistance(maxValues);
        assertNotNull(resultMax);
        assertEquals(new Double(Double.MAX_VALUE * 2), resultMax);

        List<Double> infinityPositive = new ArrayList<Double>(1);
        infinityPositive.add(Double.POSITIVE_INFINITY);
        infinityPositive.add(Double.POSITIVE_INFINITY);
        Double resultInfinityNeg2 = MathHelper.calculateSommeDistance(infinityPositive);
        assertNotNull(resultInfinityNeg2);
        assertEquals(new Double(Double.POSITIVE_INFINITY), resultInfinityNeg2);

        List<Double> infinity = new ArrayList<Double>(1);
        infinity.add(Double.POSITIVE_INFINITY);
        infinity.add(Double.POSITIVE_INFINITY);
        Double resultInfinity = MathHelper.calculateSommeDistance(infinity);
        assertNotNull(resultInfinity);
        assertEquals(new Double(Double.POSITIVE_INFINITY), resultInfinity);
    }

    @Test
    @Override
    public void testValide() {
        Double[] distances = {
            205118.4100000001,
            3612.009999999989,
            256947.6100000001,
            134615.61000000007,
            121034.41000000006,
            94802.41000000006,
            193512.01000000007,
            1565251.2099999997,
            22230.809999999972,
            925636.4099999998
        };
        
        List<Double> data = new ArrayList<Double>();
        Collections.addAll(data, distances);
        
        Double result = MathHelper.calculateSommeDistance(data);
        assertNotNull(result);
        assertEquals(new Double(3522760.9), result);
    }
}
