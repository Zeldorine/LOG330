package ets.log330.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Zeldorine
 */
public class DistanceTests extends MathTests {

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
        List<Double> resultNull = MathHelper.calculateDistance(null, null);
        assertNull(resultNull);

        List<Double> resultNull1 = MathHelper.calculateDistance(Collections.EMPTY_LIST, null);
        assertNull(resultNull1);

        List<Double> resultNull2 = MathHelper.calculateDistance(null, 6.124);
        assertNull(resultNull2);
    }

    @Test
    @Override
    public void testEmptyValue() {
        List<Double> result = MathHelper.calculateDistance(Collections.EMPTY_LIST, 6.623);
        assertNotNull(result);
        assertEquals(0, result.size());

        List<Double> resultEmpty = MathHelper.calculateDistance(Collections.EMPTY_LIST, new Double(0));
        assertNotNull(resultEmpty);
        assertEquals(0, result.size());
    }

    @Test
    @Override
    public void testNotANumberValue() {
        List<Double> nan = new ArrayList<Double>(1);
        nan.add(Double.NaN);

        List<Double> result = MathHelper.calculateDistance(nan, Double.NaN);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(new Double(Double.NaN), result.get(0));

        result = MathHelper.calculateDistance(nan, 3.1252);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(new Double(Double.NaN), result.get(0));

        nan.add(Double.parseDouble("3.162"));
        result = MathHelper.calculateDistance(nan, Double.NaN);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(new Double(Double.NaN), result.get(0));

        result = MathHelper.calculateDistance(nan, 5142.125);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(new Double(Double.NaN), result.get(0));
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

        List<Double> result = MathHelper.calculateDistance(data, 1.0);
        assertNotNull(result);
        assertEquals(5, result.size());
        for (Double distance : result) {
            assertEquals(new Double(0), distance);
        }

        List<Double> infinityNegative = new ArrayList<Double>(1);
        infinityNegative.add(Double.NEGATIVE_INFINITY);
        infinityNegative.add(Double.NEGATIVE_INFINITY);
        infinityNegative.add(Double.NEGATIVE_INFINITY);

        List<Double> resultInfinityNeg = MathHelper.calculateDistance(infinityNegative, Double.NEGATIVE_INFINITY);
        assertNotNull(resultInfinityNeg);
        assertEquals(3, resultInfinityNeg.size());
        for (Double distance : resultInfinityNeg) {
            assertEquals(new Double(Double.NaN), distance);
        }

        List<Double> minValue = new ArrayList<Double>(1);
        minValue.add(Double.MIN_VALUE);
        minValue.add(Double.MIN_VALUE);
        minValue.add(Double.MIN_VALUE);
        List<Double> resultMinValue = MathHelper.calculateDistance(minValue, Double.MIN_VALUE);
        assertNotNull(resultMinValue);
        assertEquals(3, resultMinValue.size());
        for (Double distance : resultMinValue) {
            assertEquals(new Double(0), distance);
        }
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        List<Double> data = getData();
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);
        data.addAll(data);

        Double[] resultExpected = {
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

        List<Double> result = MathHelper.calculateDistance(data, 638.9000000000001);
        assertNotNull(result);
        assertEquals(5120, result.size());
        int index = 0;
        for (Double distance : result) {
            assertEquals(resultExpected[index++], distance);
            if (index == 10) {
                index = 0;
            }
        }

        List<Double> maxValues = new ArrayList<Double>(1);
        maxValues.add(Double.MAX_VALUE);
        List<Double> resultInfinity = MathHelper.calculateDistance(maxValues, Double.MAX_VALUE);
        assertNotNull(resultInfinity);
        assertEquals(1, resultInfinity.size());
        for (Double distance : resultInfinity) {
            assertEquals(new Double(0), distance);
        }

        List<Double> infinity = new ArrayList<Double>(1);
        infinity.add(Double.POSITIVE_INFINITY);
        resultInfinity = MathHelper.calculateDistance(infinity, Double.POSITIVE_INFINITY);
        assertNotNull(resultInfinity);
        assertEquals(1, resultInfinity.size());
        for (Double distance : resultInfinity) {
            assertEquals(new Double(Double.NaN), distance);
        }
    }

    @Test
    @Override
    public void testValide() {
        List<Double> data = getData();
        Double[] resultExpected = {
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

        List<Double> result = MathHelper.calculateDistance(data, 638.9000000000001);
        assertNotNull(result);
        assertEquals(10, result.size());
        int index = 0;
        for (Double distance : result) {
            assertEquals(resultExpected[index++], distance);
            if (index == 10) {
                index = 0;
            }
        }
    }
}
