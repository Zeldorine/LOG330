package utils;

import ets.log330.utils.FileReader;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class FileReaderTest {

    public FileReaderTest() {
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
        System.out.println("utils.FileReaderTest.testPathWrongExtension()");
        assertNull(FileReader.read("data.pdf"));
        System.out.println("");
    }

    @Test
    public void testPathNull() {
        System.out.println("utils.FileReaderTest.testPathNull()");
        assertNull(FileReader.read(null));
        System.out.println("");
    }

    @Test
    public void testFileEmpty() {
        System.out.println("utils.FileReaderTest.testFileEmpty()");
        assertNull(FileReader.read("./src/test/java/resources/dataTestNull.csv"));
        System.out.println("");
    }

    @Test
    public void testFileOneValueGood() {
        System.out.println("utils.FileReaderTest.testFileOneValueGood()");
        List<List<Double>> data = FileReader.read("./src/test/java/resources/dataTestOneValueGood.csv");
        assertNotNull(data);
        assertNotNull(data.get(0));
        assertEquals(data.get(0).size(), 0);
        System.out.println("");
    }

    @Test
    public void testFileOneValueWrong() {
        System.out.println("utils.FileReaderTest.testFileOneValueWrong()");
        assertNull(FileReader.read("./src/test/java/resources/dataTestOneValueWrong.csv"));
        System.out.println("");
    }

    @Test
    public void testFileWrongTotal() {
        System.out.println("utils.FileReaderTest.testFileWrongTotal()");
        assertNull(FileReader.read("./src/test/java/resources/dataTestWrongTotal.csv"));
        System.out.println("");
    }

    @Test
    public void testFileWrongTotalValue() {
        System.out.println("utils.FileReaderTest.testFileWrongTotalValue()");
        assertNull(FileReader.read("./src/test/java/resources/dataTestWrongTotalValue.csv"));
        System.out.println("");
    }

    @Test
    public void testFileWrongValue() {
        System.out.println("utils.FileReaderTest.testFileWrongValue()");
        assertNull(FileReader.read("./src/test/java/resources/dataTestWrongValue.csv"));
        System.out.println("");
    }

    @Test
    public void testFileGood() {
        System.out.println("utils.FileReaderTest.testFileGood()");
        List<List<Double>> data = FileReader.read("./src/test/java/resources/dataTest.csv");
        System.out.println("");
        assertNotNull(data);
        assertNotNull(data.get(0));
        assertEquals(data.size(), 1);
        assertEquals(data.get(0).size(), 11);
    }

    @Test
    public void testFileCorrelationWrongColumnLess() {
        System.out.println("utils.FileReaderTest.testFileCorrelationWrongColumnLess()");
        List<List<Double>> data = FileReader.read("./src/test/java/resources/dataTestCorrelationWrongColumnLess.csv");
        System.out.println("");
        assertNull(data);
    }

    @Test
    public void testFileCorrelationWrongColumnMore() {
        System.out.println("utils.FileReaderTest.testFileCorrelationWrongColumnMore()");
        List<List<Double>> data = FileReader.read("./src/test/java/resources/dataTestCorrelationWrongColumnMore.csv");
        System.out.println("");
        assertNull(data);
    }

    @Test
    public void testFileCorrelationWrongColumnValue() {
        System.out.println("utils.FileReaderTest.testFileCorrelationWrongColumnValue()");
        List<List<Double>> data = FileReader.read("./src/test/java/resources/dataTestCorrelationWrongColumnValue.csv");
        System.out.println("");
        assertNull(data);
    }

    @Test
    public void testFileCorrelationGood() {
        System.out.println("utils.FileReaderTest.testFileCorrelationGood()");
        List<List<Double>> data = FileReader.read("./src/test/java/resources/dataTestCorrelation.csv");
        System.out.println("");
        assertNotNull(data);
        assertEquals(data.size(), 2);

        assertNotNull(data.get(0));
        assertNotNull(data.get(1));

        assertEquals(data.get(0).size(), 10);
        assertEquals(data.get(1).size(), 10);
    }
}
