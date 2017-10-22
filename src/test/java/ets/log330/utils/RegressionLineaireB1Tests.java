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
public class RegressionLineaireB1Tests extends MathTests {
    
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
        Double result = MathHelper.calculateRegressionLineaireB1(null, null, null);
        assertNull(result);
        
        result = MathHelper.calculateRegressionLineaireB1(null, new Double(0), new Double(0));
        assertNull(result);
        
        result = MathHelper.calculateRegressionLineaireB1(new ArrayList(0), new Double(0), null);
        assertNull(result);
        
        result = MathHelper.calculateRegressionLineaireB1(new ArrayList(0), new Double(0), null);
        assertNull(result);
    }

    @Test
    @Override
    public void testEmptyValue() {
        Double result = MathHelper.calculateRegressionLineaireB1(new ArrayList(0), new Double(0), new Double(0));
        assertNull(result);
    }
        

    @Test
    @Override
    public void testBorneInferieure() {
        List<List<Double>> listOneColumn = new ArrayList(1);
        listOneColumn.add(new ArrayList(0));
        Double result = MathHelper.calculateRegressionLineaireB1(listOneColumn, new Double(0), new Double(0));
        assertNull(result);
        
        // Min Value
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<>(1);
        column1.add(Double.MIN_VALUE);

        List<Double> column2 = new ArrayList<>(1);
        column2.add(Double.MIN_VALUE);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateRegressionLineaireB1(data, Double.MIN_VALUE, Double.MIN_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        // Negative Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<>(1);
        column1.add(Double.NEGATIVE_INFINITY);

        column2 = new ArrayList<>(1);
        column2.add(Double.NEGATIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateRegressionLineaireB1(data, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        List<List<Double>> listOneColumn = new ArrayList(1);
        listOneColumn.add(new ArrayList(0));
        listOneColumn.add(new ArrayList(0));
        listOneColumn.add(new ArrayList(0));
        Double result = MathHelper.calculateRegressionLineaireB1(listOneColumn, new Double(0), new Double(0));
        assertNull(result);
        
        // Max Value
        List<List<Double>> data = new ArrayList(2);

        List<Double> column1 = new ArrayList<>(1);
        column1.add(Double.MAX_VALUE);

        List<Double> column2 = new ArrayList<>(1);
        column2.add(Double.MAX_VALUE);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateRegressionLineaireB1(data, Double.MAX_VALUE, Double.MAX_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);

        // Positive Infinity
        data = new ArrayList(2);

        column1 = new ArrayList<>(1);
        column1.add(Double.POSITIVE_INFINITY);

        column2 = new ArrayList<>(1);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateRegressionLineaireB1(data, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }

    @Test
    @Override
    public void testValide() {
        Double result = MathHelper.calculateRegressionLineaireB1(getListTwoColumnRegressionLineaire(), 382.8, 638.9);
        assertNotNull(result);
        assertEquals(new Double(1.7279324262069864), result);
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

        Double result = MathHelper.calculateRegressionLineaireB1(data, Double.NaN, Double.NaN);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result);
    }
}
