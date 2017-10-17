package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Zeldorine
 */
public class MoyenneTests extends MathTests {

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
        Double result = MathHelper.calculateMoyenne(null);
        assertNotNull(result);
        assertEquals(new Double(0), result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateMoyenne(new ArrayList<Double>(0));
        assertNotNull(result);
        assertEquals(new Double(0), result);
    }

    @Test
    @Override
    public void testNotANumberValue() {
        List<Double> nan = new ArrayList<Double>(1);
        nan.add(Double.NaN);

        Double result = MathHelper.calculateMoyenne(nan);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
        
        nan.add(Double.parseDouble("3.162"));
        result = MathHelper.calculateMoyenne(nan);
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

        Double result = MathHelper.calculateMoyenne(data);
        assertNotNull(result);
        assertEquals(new Double(1), result);

        List<Double> infinityNegative = new ArrayList<Double>(1);
        infinityNegative.add(Double.NEGATIVE_INFINITY);
        Double resultInfinityNeg = MathHelper.calculateMoyenne(infinityNegative);
        assertNotNull(resultInfinityNeg);
        assertEquals(new Double(Double.NEGATIVE_INFINITY), resultInfinityNeg);

        List<Double> minValue = new ArrayList<Double>(1);
        minValue.add(Double.MIN_VALUE);
        Double resultMinValue = MathHelper.calculateMoyenne(minValue);
        assertNotNull(resultMinValue);
        assertEquals(new Double(Double.MIN_VALUE), resultMinValue);
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

        Double result = MathHelper.calculateMoyenne(data);
        assertNotNull(result);
        assertEquals(5120, data.size());
        assertEquals(new Double(638.9000000000001), result);

        List<Double> maxValues = new ArrayList<Double>(1);
        maxValues.add(Double.MAX_VALUE);
        Double resultMax = MathHelper.calculateMoyenne(maxValues);
        assertNotNull(resultMax);
        assertEquals(new Double(Double.MAX_VALUE), resultMax);

        List<Double> infinity = new ArrayList<Double>(1);
        infinity.add(Double.POSITIVE_INFINITY);
        Double resultInfinity = MathHelper.calculateMoyenne(infinity);
        assertNotNull(resultInfinity);
        assertEquals(new Double(Double.POSITIVE_INFINITY), resultInfinity);
    }

    @Test
    @Override
    public void testValide() {
        Double result = MathHelper.calculateMoyenne(data);
        assertNotNull(result);
        assertEquals(new Double(638.9000000000001), result);
    }
}
