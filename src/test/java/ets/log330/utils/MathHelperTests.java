package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Zeldorine
 */
public class MathHelperTests {

    public MathHelperTests() {
    }

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
    public void testCalculateVarianceNullList() {
        assertNull(MathHelper.calculate(null));
    }

    @Test
    public void testCalculateCorrelationNullList() {
        assertNull(MathHelper.CalculateCorrelation(null).getCorrelation());
    }

    @Test
    public void testCalculateRegressionLineaireNullList() {
        assertNull(MathHelper.calculateRegresionLineaire(null).getCorrelation());
    }

    @Test
    public void testCalculateVarianceZeroValue() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        CalculationResult result = MathHelper.calculate(data.get(0));
        assertNotNull(result);
        assertEquals(new Double(0), result.getMoyenne());
        assertEquals(new Double(0), result.getVariance());
        assertEquals(new Double(0), result.getEcartType());
    }

    @Test
    public void testCalculateCorrelationZeroValue() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(null, result.getCorrelation());
    }

    @Test
    public void testCalculateRegressionLineaireZeroValue() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(null, result.getRegressionB0());
        assertEquals(null, result.getRegressionB1());
    }

    @Test
    public void testCalculateVarianceMaxValue() {
        List<Double> data = new ArrayList();
        data.add(Double.MAX_VALUE);
        data.add(Double.MAX_VALUE);
        data.add(Double.MAX_VALUE);

        CalculationResult result = MathHelper.calculate(data);
        assertNotNull(result);
        assertEquals(new Double(Double.POSITIVE_INFINITY), result.getMoyenne());
        assertEquals(new Double(Double.POSITIVE_INFINITY), result.getVariance());
        assertEquals(new Double(Double.POSITIVE_INFINITY), result.getEcartType());
    }

    @Test
    public void testCalculateCorrelationMaxValue() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        column1.add(Double.MAX_VALUE);
        column2.add(Double.MAX_VALUE);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getCorrelation());
    }

    @Test
    public void testCalculateRegressionLineaireMaxValue() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        column1.add(Double.MAX_VALUE);
        column2.add(Double.MAX_VALUE);

        data.add(column1);
        data.add(column2);

        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(Double.NaN), result.getRegressionB0());
        assertEquals(new Double(Double.NaN), result.getRegressionB1());
    }

    @Test
    public void testCalculateVariance() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTest.csv");
        CalculationResult result = MathHelper.calculate(data.get(0));
        assertNotNull(result);
        assertEquals(new Double(638.9000000000001), result.getMoyenne());
        assertEquals(new Double(391417.8777777777), result.getVariance());
        assertEquals(new Double(625.6339806770231), result.getEcartType());
    }

    @Test
    public void testCalculateCorrelation() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelation.csv");
        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertNotNull(result);
        assertEquals(new Double(0.9559205282352726), result.getCorrelation());
        assertNull(result.getEcartType());
        assertNull(result.getMoyenne());
        assertNull(result.getVariance());
    }

    @Test
    public void testCalculateRegresionLineaire() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestRegressionLineaire.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);
        assertEquals(new Double(-22.552532752034153), result.getRegressionB0());
        assertEquals(new Double(1.727932426206986), result.getRegressionB1());
    }

    @Test
    public void testCalculateValueWithLinearRegressionBorneInferieur() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestRegressionLineaire.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);

        Double valueY = MathHelper.calculateValueWithLinearRegression(true, Double.MIN_VALUE, result);
        Double valueX = MathHelper.calculateValueWithLinearRegression(false, Double.MIN_VALUE, result);

        assertNotNull(valueX);
        assertNotNull(valueY);
        assertEquals(Double.valueOf("13.051744622641063"), valueX);
        assertEquals(Double.valueOf("-22.552532752034153"), valueY);

        valueY = MathHelper.calculateValueWithLinearRegression(true, Double.NEGATIVE_INFINITY, result);
        valueX = MathHelper.calculateValueWithLinearRegression(true, Double.NEGATIVE_INFINITY, result);

        assertNotNull(valueX);
        assertNotNull(valueY);
        assertEquals(Double.valueOf(Double.NEGATIVE_INFINITY), valueX);
        assertEquals(Double.valueOf(Double.NEGATIVE_INFINITY), valueY);
    }

    @Test
    public void testCalculateValueWithLinearRegressionBorneSuperieure() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestRegressionLineaire.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);

        Double valueY = MathHelper.calculateValueWithLinearRegression(true, Double.MAX_VALUE, result);
        Double valueX = MathHelper.calculateValueWithLinearRegression(false, Double.MAX_VALUE, result);

        assertNotNull(valueX);
        assertNotNull(valueY);

        assertEquals(Double.valueOf("1.0403723592411902E308"), valueX);
        assertEquals(new Double(Double.POSITIVE_INFINITY), valueY);

        valueY = MathHelper.calculateValueWithLinearRegression(true, Double.POSITIVE_INFINITY, result);
        valueX = MathHelper.calculateValueWithLinearRegression(true, Double.POSITIVE_INFINITY, result);

        assertNotNull(valueX);
        assertNotNull(valueY);
        assertEquals(Double.valueOf(Double.POSITIVE_INFINITY), valueX);
        assertEquals(Double.valueOf(Double.POSITIVE_INFINITY), valueY);
    }

    @Test
    public void testCalculateValueWithLinearRegressionNotANumber() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestRegressionLineaire.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);

        Double valueY = MathHelper.calculateValueWithLinearRegression(true, Double.NaN, result);
        Double valueX = MathHelper.calculateValueWithLinearRegression(false, Double.NaN, result);

        assertNotNull(valueX);
        assertNotNull(valueY);
        assertEquals(Double.valueOf(Double.NaN), valueX);
        assertEquals(Double.valueOf(Double.NaN), valueY);
    }

    @Test
    public void testCalculateValueWithLinearRegressionNUllValue() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestRegressionLineaire.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);

        Double valueY = MathHelper.calculateValueWithLinearRegression(true, null, result);
        Double valueX = MathHelper.calculateValueWithLinearRegression(false, null, result);

        assertNull(valueX);
        assertNull(valueY);
    }

    @Test
    public void testCalculateValueWithLinearRegressionValide() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestRegressionLineaire.csv");
        CalculationResult result = MathHelper.calculateRegresionLineaire(data);
        assertNotNull(result);

        Double valueY = MathHelper.calculateValueWithLinearRegression(true, 12.1254, result);
        Double valueX = MathHelper.calculateValueWithLinearRegression(false, 12.1254, result);

        assertNotNull(valueX);
        assertNotNull(valueY);
        assertEquals(Double.valueOf("20.06903292402254"), valueX);
        assertEquals(Double.valueOf("-1.6006609113039652"), valueY);
    }

    @Test
    public void testSumAndMergeListNull() {
        List<Double> result = MathHelper.sumAndMergeList(null);
        assertNull(result);
    }

    @Test
    public void testSumAndMergeListEmpty() {
        List<List<Double>> data = new ArrayList();

        List<Double> result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(0, result.size());

        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        data.add(column1);
        data.add(column2);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testSumAndMergeListNaN() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        data.add(column1);
        data.add(column2);

        column1.add(Double.NaN);
        column2.add(Double.NaN);

        List<Double> result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(new Double(Double.NaN), result.get(0));

        column1.add(10.0);
        column2.add(Double.NaN);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(new Double(Double.NaN), result.get(1));
    }

    @Test
    public void testSumAndMergeListBorneInferieure() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        data.add(column1);
        data.add(column2);

        column1.add(Double.MIN_VALUE);
        column2.add(Double.MIN_VALUE);

        List<Double> result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(new Double(Double.MIN_VALUE * 2), result.get(0));

        column1.add(10.0);
        column2.add(Double.MIN_VALUE);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(new Double(Double.MIN_VALUE + 10.0), result.get(1));

        column1.add(Double.NEGATIVE_INFINITY);
        column2.add(Double.NEGATIVE_INFINITY);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(new Double(Double.NEGATIVE_INFINITY), result.get(2));

        column1.add(10.0);
        column2.add(Double.NEGATIVE_INFINITY);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(new Double(Double.NEGATIVE_INFINITY), result.get(3));
    }

    @Test
    public void testSumAndMergeListBorneSuperieure() {
        List<List<Double>> data = new ArrayList();
        List<Double> column1 = new ArrayList();
        List<Double> column2 = new ArrayList();
        data.add(column1);
        data.add(column2);

        column1.add(Double.MAX_VALUE);
        column2.add(Double.MAX_VALUE);

        List<Double> result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(new Double(Double.MAX_VALUE * 2), result.get(0));

        column1.add(10.0);
        column2.add(Double.MAX_VALUE);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(new Double(Double.MAX_VALUE + 10.0), result.get(1));

        column1.add(Double.POSITIVE_INFINITY);
        column2.add(Double.POSITIVE_INFINITY);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(new Double(Double.POSITIVE_INFINITY), result.get(2));

        column1.add(10.0);
        column2.add(Double.POSITIVE_INFINITY);

        result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(new Double(Double.POSITIVE_INFINITY), result.get(3));
    }

    @Test
    public void testSumAndMergeListValide() {
        List<Double> sumList = new ArrayList(35);
        sumList.add(14.64);
        sumList.add(14.5);
        sumList.add(9.54);
        sumList.add(13.29);
        sumList.add(13.309999999999999);
        sumList.add(13.579999999999998);
        sumList.add(14.26);
        sumList.add(12.690000000000001);
        sumList.add(12.98);
        sumList.add(15.49);
        sumList.add(14.889999999999999);
        sumList.add(14.74);
        sumList.add(16.049999999999997);
        sumList.add(19.07);
        sumList.add(12.94);
        sumList.add(13.7);
        sumList.add(11.44);
        sumList.add(14.61);
        sumList.add(13.26);
        sumList.add(12.76);
        sumList.add(13.45);
        sumList.add(12.45);
        sumList.add(8.0);
        sumList.add(9.940000000000001);
        sumList.add(12.4);
        sumList.add(13.23);
        sumList.add(12.689999999999998);
        sumList.add(12.689999999999998);
        sumList.add(12.33);
        sumList.add(12.34);
        sumList.add(11.77);
        sumList.add(14.39);
        sumList.add(13.23);
        sumList.add(11.5);
        sumList.add(11.759999999999998);

        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestMultipleColumns.csv", false);
        List<Double> result = MathHelper.sumAndMergeList(data);
        assertNotNull(result);
        assertEquals(35, result.size());

        for (int i = 0; i < 35; i++) {
            assertEquals(sumList.get(i), result.get(i));
        }
    }
}
