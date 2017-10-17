package ets.log330.utils;

/**
 *
 * @author Zeldorine
 */
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class MathTests {

    static List<Double> data;

    static {
        data = FileReader.read("./src/test/java/ets/log330/resources/dataTest.csv").get(0);
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

    public List<Double> getData() {
        return new ArrayList<Double>(data);
    }

    @Test
    public abstract void testNullValue();

    @Test
    public abstract void testEmptyValue();

    @Test
    public abstract void testNotANumberValue();

    @Test
    public abstract void testBorneInferieure();

    @Test
    public abstract void testBorneSuperieure();

    @Test
    public abstract void testValide();
}
