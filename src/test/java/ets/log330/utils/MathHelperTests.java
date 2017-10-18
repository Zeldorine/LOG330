package ets.log330.utils;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

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
    public void testCalculateVarianceNUllList() {
        assertNull(MathHelper.calculate(null));
    }

    @Test
    public void testCalculateCorrelationNUllList() {
        assertNull(MathHelper.CalculateCorrelation(null).getCorrelation());
    }

    @Test
    public void testCalculateVarianceZeroValue() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        CalculationResult result = MathHelper.calculate(data.get(0));
        assertEquals(new Double(0), result.getMoyenne());
        assertEquals(new Double(0), result.getVariance());
        assertEquals(new Double(0), result.getEcartType());
    }

    @Test
    public void testCalculateCorrelationZeroValue() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertEquals(null, result.getCorrelation());
    }

    @Test
    public void testCalculateVarianceMaxValue() {

    }

    @Test
    public void testCalculateCorrelationMaxValue() {

    }

    @Test
    public void testCalculateVariance() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTest.csv");
        CalculationResult result = MathHelper.calculate(data.get(0));
        assertEquals(new Double(638.9000000000001), result.getMoyenne());
        assertEquals(new Double(391417.8777777777), result.getVariance());
        assertEquals(new Double(625.6339806770231), result.getEcartType());
    }

    @Test
    public void testCalculateCorrelation() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelation.csv");
        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertEquals(new Double(0.9559205282352726), result.getCorrelation());
        assertNull(result.getEcartType());
        assertNull(result.getMoyenne());
        assertNull(result.getVariance());
    }
}
