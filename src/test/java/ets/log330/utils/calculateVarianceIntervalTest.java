package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class calculateVarianceIntervalTest extends MathTests {

    @Test
    @Override
    public void testNullValue() {
        assertEquals(null, MathHelper.calculateVarianceInterval(null, null));
    }

    @Test
    @Override
    public void testEmptyValue() {
        assertEquals(null, MathHelper.calculateVarianceInterval(new ArrayList(), null));
        assertEquals(null, MathHelper.calculateVarianceInterval(new ArrayList(), new CalculationResult()));
        
        List<List<Double>> listWithOneElement = new ArrayList<>(1);
        listWithOneElement.add(new ArrayList());
        List<List<Double>> listWithTooMuchElements = new ArrayList<>(3);
        listWithTooMuchElements.add(new ArrayList());
        listWithTooMuchElements.add(new ArrayList());
        listWithTooMuchElements.add(new ArrayList());
        
        assertEquals(null, MathHelper.calculateVarianceInterval(listWithOneElement, new CalculationResult()));
        assertEquals(null, MathHelper.calculateVarianceInterval(listWithTooMuchElements, new CalculationResult()));
        
        List<List<Double>> listWithTwoElements = new ArrayList<>(2);
        listWithTwoElements.add(new ArrayList());
        listWithTwoElements.add(new ArrayList());
        CalculationResult result = new CalculationResult();
        result.setRegressionB0(Double.NaN);
        
        assertEquals(null, MathHelper.calculateVarianceInterval(listWithTwoElements, result));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        column1.add(Double.NaN);
        column2.add(Double.NaN);

        data.add(column1);
        data.add(column2);
        
        CalculationResult result = new CalculationResult();
        result.setRegressionB0(Double.NaN);
        result.setRegressionB1(Double.NaN);
        
        assertEquals(new Double(Double.NaN), MathHelper.calculateVarianceInterval(data, result));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        column1.add(Double.MIN_VALUE);
        column2.add(Double.MIN_VALUE);

        data.add(column1);
        data.add(column2);
        
        CalculationResult result = new CalculationResult();
        result.setRegressionB0(Double.MIN_VALUE);
        result.setRegressionB1(Double.MIN_VALUE);
        
        assertEquals(new Double(Double.NaN), MathHelper.calculateVarianceInterval(data, result));
        
        
        data = new ArrayList();
        column1 = new ArrayList();
        column2 = new ArrayList();
        column1.add(Double.NEGATIVE_INFINITY);
        column2.add(Double.NEGATIVE_INFINITY);

        data.add(column1);
        data.add(column2);
        
        result = new CalculationResult();
        result.setRegressionB0(Double.NEGATIVE_INFINITY);
        result.setRegressionB1(Double.NEGATIVE_INFINITY);
        
        assertEquals(new Double(Double.NaN), MathHelper.calculateVarianceInterval(data, result));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        column1.add(Double.MAX_VALUE);
        column2.add(Double.MAX_VALUE);

        data.add(column1);
        data.add(column2);
        
        CalculationResult result = new CalculationResult();
        result.setRegressionB0(Double.MAX_VALUE);
        result.setRegressionB1(Double.MAX_VALUE);
        
        assertEquals(new Double(Double.POSITIVE_INFINITY), MathHelper.calculateVarianceInterval(data, result));
        
        
        data = new ArrayList();
        column1 = new ArrayList();
        column2 = new ArrayList();
        column1.add(Double.POSITIVE_INFINITY);
        column2.add(Double.POSITIVE_INFINITY);

        data.add(column1);
        data.add(column2);
        
        result = new CalculationResult();
        result.setRegressionB0(Double.POSITIVE_INFINITY);
        result.setRegressionB1(Double.POSITIVE_INFINITY);
        
        assertEquals(new Double(Double.NaN), MathHelper.calculateVarianceInterval(data, result));
    }

    @Test
    @Override
    public void testValide() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/TP6-DonneesTestValide.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        
        assertEquals(new Double(34811.253898006195), MathHelper.calculateVarianceInterval(data, result));
    }
}
