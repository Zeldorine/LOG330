package ets.log330.utils;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
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
public class FileReaderTests {

    public FileReaderTests() {
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
    public void testPathWrongExtension() {
        assertNull(FileReader.read("data.pdf"));
    }

    @Test
    public void testPathNull() {
        assertNull(FileReader.read(null));
    }

    @Test
    public void testFileEmpty() {
        assertNull(FileReader.read("./src/test/java/ets/log330/resources/dataTestNull.csv"));
    }

    @Test
    public void testFileOneValueGood() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueGood.csv");
        assertNotNull(data);
        assertNotNull(data.get(0));
        assertEquals(data.get(0).size(), 0);
    }

    @Test
    public void testFileOneValueWrong() {
        assertNull(FileReader.read("./src/test/java/ets/log330/resources/dataTestOneValueWrong.csv"));
    }

    @Test
    public void testFileWrongTotal() {
        assertNull(FileReader.read("./src/test/java/ets/log330/resources/dataTestWrongTotal.csv"));
    }

    @Test
    public void testFileWrongTotalValue() {
        assertNull(FileReader.read("./src/test/java/ets/log330/resources/dataTestWrongTotalValue.csv"));
    }

    @Test
    public void testFileWrongValue() {
        assertNull(FileReader.read("./src/test/java/ets/log330/resources/dataTestWrongValue.csv"));
    }

    @Test
    public void testFileGood() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTest.csv");
        System.out.println("");
        assertNotNull(data);
        assertNotNull(data.get(0));
        assertEquals(data.size(), 1);
        assertEquals(data.get(0).size(), 10);
    }

    @Test
    public void testFileCorrelationWrongColumnLess() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelationWrongColumnLess.csv");
        assertNull(data);
    }

    @Test
    public void testFileCorrelationWrongColumnMore() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelationWrongColumnMore.csv");
        assertNull(data);
    }

    @Test
    public void testFileCorrelationWrongColumnValue() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelationWrongColumnValue.csv");
        assertNull(data);
    }

    @Test
    public void testFileCorrelationGood() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestCorrelation.csv");
        assertNotNull(data);
        assertEquals(data.size(), 2);

        assertNotNull(data.get(0));
        assertNotNull(data.get(1));

        assertEquals(data.get(0).size(), 10);
        assertEquals(data.get(1).size(), 10);
    }

    @Test
    public void testFileChecktotalWrong() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestDifferentColumnSize.csv", true);
        assertNull(data);
    }

    @Test
    public void testFileChecktotalValide() {
        List<List<Double>> data = FileReader.read("./src/test/java/ets/log330/resources/dataTestDifferentColumnSize.csv", false);
        assertNull(data);

        int[] linesToRemove = new int[]{0,1};
        int[] columnsToRemove = new int[]{0};
        data = FileReader.read("./src/test/java/ets/log330/resources/dataTestSameColumnSize.csv", false, linesToRemove, columnsToRemove);
        assertNotNull(data);
        assertEquals(7, data.size());
    }
}
