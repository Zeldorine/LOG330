/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ets.log330.utils;

import ets.log330.utils.FileReader;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        assertEquals(Double.NaN, result);
        
        nan.add(Double.parseDouble("3.162"));
        result = MathHelper.calculateMoyenne(nan);
        assertNotNull(result);
        assertEquals(Double.NaN, result);
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
        assertEquals(Double.NEGATIVE_INFINITY, resultInfinityNeg);

        List<Double> minValue = new ArrayList<Double>(1);
        minValue.add(Double.MIN_VALUE);
        Double resultMinValue = MathHelper.calculateMoyenne(minValue);
        assertNotNull(resultMinValue);
        assertEquals(Double.MIN_VALUE, resultMinValue);
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
        assertEquals(638.9000000000001, result);

        List<Double> maxValues = new ArrayList<Double>(1);
        maxValues.add(Double.MAX_VALUE);
        Double resultMax = MathHelper.calculateMoyenne(maxValues);
        assertNotNull(resultMax);
        assertEquals(Double.MAX_VALUE, resultMax);

        List<Double> infinity = new ArrayList<Double>(1);
        infinity.add(Double.POSITIVE_INFINITY);
        Double resultInfinity = MathHelper.calculateMoyenne(infinity);
        assertNotNull(resultInfinity);
        assertEquals(Double.POSITIVE_INFINITY, resultInfinity);
    }

    @Test
    @Override
    public void testValide() {
        Double result = MathHelper.calculateMoyenne(data);
        assertNotNull(result);
        assertEquals(638.9000000000001, result);
    }
}
