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
public class RegressionLineaireTests extends MathTests {
    
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
        CalculationResult result = MathHelper.calculateRegresionLineaire(null);
        assertNotNull(result);
        assertNull(result.getRegressionB0());
        assertNull(result.getRegressionB1());
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = MathHelper.calculateRegresionLineaire(new ArrayList(0));
        assertNotNull(result);
        assertNull(result.getRegressionB0());
        assertNull(result.getRegressionB1());

        List<List<Double>> data = new ArrayList(2);
        data.add(new ArrayList(0));
        data.add(new ArrayList(0));

        result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertNull(result.getRegressionB0());
        assertNull(result.getRegressionB1());
    }
        

    @Test
    @Override
    public void testBorneInferieure() {
        // Min Value
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<>(1);
        column1.add(Double.MIN_VALUE);

        List<Double> column2 = new ArrayList<>(1);
        column2.add(Double.MIN_VALUE);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getRegressionB0());
        assertEquals(new Double(Double.NaN), result.getRegressionB1());

        // Negative Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<>(1);
        column1.add(Double.NEGATIVE_INFINITY);

        column2 = new ArrayList<>(1);
        column2.add(Double.NEGATIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getRegressionB0());
        assertEquals(new Double(Double.NaN), result.getRegressionB1());
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        // Max Value
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<>(1);
        column1.add(Double.MAX_VALUE);

        List<Double> column2 = new ArrayList<>(1);
        column2.add(Double.MAX_VALUE);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getRegressionB0());
        assertEquals(new Double(Double.NaN), result.getRegressionB1());

        // Positive Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<>(1);
        column1.add(Double.POSITIVE_INFINITY);

        column2 = new ArrayList<>(1);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getRegressionB0());
        assertEquals(new Double(Double.NaN), result.getRegressionB1());
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = MathHelper.calculateRegresionLineaire(getListTwoColumnRegressionLineaire());
        assertNotNull(result);
        assertEquals(new Double(-22.552532752034153), result.getRegressionB0());
        assertEquals(new Double(1.727932426206986), result.getRegressionB1());
    }

    @Test
    @Override
    public void testNotANumberValue() {
        // NaN * NaN
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<>(1);
        column1.add(Double.NaN);

        List<Double> column2 = new ArrayList<>(1);
        column2.add(Double.NaN);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getRegressionB0());
        assertEquals(new Double(Double.NaN), result.getRegressionB1());

        // Nan * number
        data = new ArrayList(2);

        column1 = new ArrayList<>(1);
        column1.add(Double.NaN);

        column2 = new ArrayList<>(1);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getRegressionB0());
        assertEquals(new Double(Double.NaN), result.getRegressionB1());
    }
}
