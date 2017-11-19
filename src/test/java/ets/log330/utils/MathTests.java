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
    protected static final String NEW_LINE = System.getProperty("line.separator");
    static List<Double> dataOneColumn;
    static List<List<Double>> dataMultipleColumns;
    static List<List<Double>> dataTwoColumnCorrelation;
    static List<List<Double>> dataTwoColumnRegressionLineaire;

    static {
        dataOneColumn = FileReader.read("./src/test/java/ets/log330/resources/dataTest.csv").get(0);
        dataMultipleColumns = FileReader.read("./src/test/java/ets/log330/resources/dataTestMultipleColumns.csv", false);
        dataTwoColumnCorrelation = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelation.csv");
        dataTwoColumnRegressionLineaire = FileReader.read("./src/test/java/ets/log330/resources/dataTestRegressionLineaire.csv");
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

    public List<Double> getListOneColumn() {
        return new ArrayList<>(dataOneColumn);
    }
    
    public List<List<Double>> getListMultipleColumns(){
        return dataMultipleColumns;
    }
    
    public List<List<Double>> getListTwoColumnCorrelation() {
        return new ArrayList<>(dataTwoColumnCorrelation);
    }
    
    public List<List<Double>> getListTwoColumnRegressionLineaire() {
        return new ArrayList<>(dataTwoColumnRegressionLineaire);
    }

    public abstract void testNullValue();

    public abstract void testEmptyValue();

    public abstract void testNotANumberValue();

    public abstract void testBorneInferieure();

    public abstract void testBorneSuperieure();

    public abstract void testValide();
}
