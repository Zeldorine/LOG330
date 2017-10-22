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
}
