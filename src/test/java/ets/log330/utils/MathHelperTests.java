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
    public void testCalculateNUllList() {
        System.out.println("utils.MathHelperTest.testCalculateNUllList()");
        assertNull(MathHelper.calculate(null));
        System.out.println("");
    }

    @Test
    public void testCalculateCorrelationNUllList() {
        System.out.println("utils.MathHelperTest.testCalculateCorrelationNUllList()");
        assertNull(MathHelper.CalculateCorrelation(null).getCorrelation());
        System.out.println("");
    }

    @Test
    public void testCalculateZeroValue() {
        System.out.println("utils.MathHelperTest.testCalculateZeroValue()");
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        CalculationResult result = MathHelper.calculate(data.get(0));
        assertEquals(new Double(0), result.getMoyenne());
        assertEquals(new Double(0), result.getVariance());
        assertEquals(new Double(0), result.getEcartType());
        System.out.println("");
    }

    @Test
    public void testCalculateCorrelationZeroValue() {
        System.out.println("utils.MathHelperTest.testCalculateCorrelationZeroValue()");
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertEquals(null, result.getCorrelation());
        System.out.println("");
    }

    @Test
    public void testCalculate() {
        System.out.println("utils.MathHelperTest.testCalculate()");
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTest.csv");
        CalculationResult result = MathHelper.calculate(data.get(0));
        assertEquals(new Double(638.9000000000001), result.getMoyenne());
        assertEquals(new Double(391417.8777777777), result.getVariance());
        assertEquals(new Double(625.6339806770231), result.getEcartType());
        System.out.println("");
    }

    @Test
    public void testCalculateCorrelation() {
        System.out.println("utils.MathHelperTest.testCalculateCorrelation()");
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelation.csv");
        CalculationResult result = MathHelper.CalculateCorrelation(data);
        assertEquals(new Double(0.9559205282352726), result.getCorrelation());
        System.out.println("");
    }
}
