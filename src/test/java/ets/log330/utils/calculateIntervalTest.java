package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class calculateIntervalTest extends MathTests {

    @Test
    @Override
    public void testNullValue() {
        assertEquals(null, MathHelper.calculateInterval(null, 0.0));
    }

    @Test
    @Override
    public void testEmptyValue() {
        assertEquals(null, MathHelper.calculateInterval(new ArrayList(), 0.0));

        List<List<Double>> listWithOneElement = new ArrayList<>(1);
        listWithOneElement.add(new ArrayList());
        List<List<Double>> listWithTooMuchElements = new ArrayList<>(3);
        listWithTooMuchElements.add(new ArrayList());
        listWithTooMuchElements.add(new ArrayList());
        listWithTooMuchElements.add(new ArrayList());

        assertEquals(null, MathHelper.calculateInterval(listWithOneElement, 0.0));
        assertEquals(null, MathHelper.calculateInterval(listWithTooMuchElements, 0.0));

        List<List<Double>> listWithTwoElements = new ArrayList<>(2);
        listWithTwoElements.add(new ArrayList());
        listWithTwoElements.add(new ArrayList());

        assertEquals(null, MathHelper.calculateInterval(listWithTwoElements, 0.0));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            column1.add(Double.NaN);
            column2.add(Double.NaN);
        }

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.calculateInterval(data, Double.NaN);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getIntervalValue(70));
        assertEquals(new Double(Double.NaN), result.getIntervalValue(90));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            column1.add(Double.MIN_VALUE);
            column2.add(Double.MIN_VALUE);
        }

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.calculateInterval(data, Double.MIN_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getIntervalValue(70));
        assertEquals(new Double(Double.NaN), result.getIntervalValue(90));

        data = new ArrayList();
        column1 = new ArrayList();
        column2 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            column1.add(Double.NEGATIVE_INFINITY);
            column2.add(Double.NEGATIVE_INFINITY);
        }

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateInterval(data, Double.NEGATIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getIntervalValue(70));
        assertEquals(new Double(Double.NaN), result.getIntervalValue(90));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            column1.add(Double.MAX_VALUE);
            column2.add(Double.MAX_VALUE);
        }

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.calculateInterval(data, Double.MAX_VALUE);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getIntervalValue(70));
        assertEquals(new Double(Double.NaN), result.getIntervalValue(90));

        data = new ArrayList();
        column1 = new ArrayList();
        column2 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            column1.add(Double.POSITIVE_INFINITY);
            column2.add(Double.POSITIVE_INFINITY);
        }

        data.add(column1);
        data.add(column2);

        result = MathHelper.calculateInterval(data, Double.POSITIVE_INFINITY);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getIntervalValue(70));
        assertEquals(new Double(Double.NaN), result.getIntervalValue(90));
    }

    @Test
    @Override
    public void testValide() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/TP6-DonneesTestValide.csv");
        CalculationResult result = MathHelper.calculateInterval(data, 1119);
        assertNotNull(result);
        assertEquals(new Double(261.8366771222584), result.getIntervalValue(70));
        assertEquals(new Double(439.54532441101134), result.getIntervalValue(90));
    }

}
