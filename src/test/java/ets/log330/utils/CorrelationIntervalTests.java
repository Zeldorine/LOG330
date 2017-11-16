package ets.log330.utils;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class CorrelationIntervalTests{

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
    public void testNullValue() {
        String result = CorrelationInterval.getInterpretationFromValue(null);
        assertNull(result);
    }

    @Test
    public void testNotANumberValue() {
        String result = CorrelationInterval.getInterpretationFromValue(Double.NaN);
        assertNotNull(result);
        assertEquals("Cannot get correlation caption for value " + Double.NaN + ". The value must be between 0 and 1", result);
    }

    @Test
    public void testBorneInferieure() {
        String result = CorrelationInterval.getInterpretationFromValue(Double.NEGATIVE_INFINITY);
        assertNotNull(result);
        assertEquals("Cannot get correlation caption for value " + Double.NEGATIVE_INFINITY + ". The value must be between 0 and 1", result);

        result = CorrelationInterval.getInterpretationFromValue(Double.MIN_VALUE);
        assertNotNull(result);
        assertEquals("Nulle à faible", result);
    }

    @Test
    public void testBorneSuperieure() {
        String result = CorrelationInterval.getInterpretationFromValue(Double.POSITIVE_INFINITY);
        assertNotNull(result);
        assertEquals("Cannot get correlation caption for value " + Double.POSITIVE_INFINITY + ". The value must be between 0 and 1", result);

        result = CorrelationInterval.getInterpretationFromValue(Double.MAX_VALUE);
        assertNotNull(result);
        assertEquals("Cannot get correlation caption for value " + Double.MAX_VALUE + ". The value must be between 0 and 1", result);
    }

    @Test
    public void testValide() {
        String result = CorrelationInterval.getInterpretationFromValue(new Double(0));
        assertNotNull(result);
        assertEquals("Nulle à faible", result);

        result = CorrelationInterval.getInterpretationFromValue(0.1999999);
        assertNotNull(result);
        assertEquals("Nulle à faible", result);

        result = CorrelationInterval.getInterpretationFromValue(0.2);
        assertNotNull(result);
        assertEquals("Faible à moyenne", result);

        result = CorrelationInterval.getInterpretationFromValue(0.3999999);
        assertNotNull(result);
        assertEquals("Faible à moyenne", result);

        result = CorrelationInterval.getInterpretationFromValue(0.4);
        assertNotNull(result);
        assertEquals("Moyenne à forte", result);

        result = CorrelationInterval.getInterpretationFromValue(0.5999999);
        assertNotNull(result);
        assertEquals("Moyenne à forte", result);

        result = CorrelationInterval.getInterpretationFromValue(0.6);
        assertNotNull(result);
        assertEquals("Moyenne à forte", result);

        result = CorrelationInterval.getInterpretationFromValue(0.7999999);
        assertNotNull(result);
        assertEquals("Forte à très forte", result);

        result = CorrelationInterval.getInterpretationFromValue(0.8);
        assertNotNull(result);
        assertEquals("Forte à très forte", result);

        result = CorrelationInterval.getInterpretationFromValue(0.9999999);
        assertNotNull(result);
        assertEquals("Très forte à parfaite", result);

        result = CorrelationInterval.getInterpretationFromValue(new Double(1));
        assertNotNull(result);
        assertEquals("Très forte à parfaite", result);

        result = CorrelationInterval.getInterpretationFromValue(1.00000001);
        assertNotNull(result);
        assertEquals("Cannot get correlation caption for value " + 1.00000001 + ". The value must be between 0 and 1", result);
    }
}
