package ets.log330.Launcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class CalculatorGetPathFromArgsTests {

    @Test
    public void testNullValue() {
        String path = Calculator.getFileFromArgs(null);
        assertNull(path);
    }

    @Test
    public void testBorneInferieure() {
        String path = Calculator.getFileFromArgs(new String[]{});
        assertNull(path);
    }

    @Test
    public void testBorneSuperieure() {
        String path = Calculator.getFileFromArgs(new String[]{"test", "test"});
        assertNull(path);
    }

    @Test
    public void testValide() {
        String path = Calculator.getFileFromArgs(new String[]{""});
        assertEquals("", path);
        
        path = Calculator.getFileFromArgs(new String[]{"data.csv"});
        assertEquals("data.csv", path);
    }
}
