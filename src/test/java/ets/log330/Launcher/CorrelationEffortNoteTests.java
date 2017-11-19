package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;
import ets.log330.utils.MathTests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class CorrelationEffortNoteTests extends MathTests {

    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    @Override
    public void testNullValue() {
        assertEquals("No correlation result to display, result is null.No regression to display, result is null.", CorrelationEffortNote.getDisplayResult(null, null));
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = new CalculationResult(null);
        result.setRegressionB0(null);
        result.setRegressionB1(null);
        
        assertEquals("No correlation result to display, result is null."
                + "B0 (origine) = null" + NEWLINE
                + "B1 (pente) = null" + NEWLINE
                + "Equation is null" + NEWLINE
                + "", CorrelationEffortNote.getDisplayResult(result, result));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        CalculationResult result = new CalculationResult(Double.NaN);
        result.setRegressionB0(Double.NaN);
        result.setRegressionB1(Double.NaN);

        assertEquals("Correlation = NaN" + NEWLINE
                + "Correlation au carre = NaN" + NEWLINE
                + "Interprétation : Cannot get correlation caption for value NaN. The value must be between 0 and 1" + NEWLINE
                + "B0 (origine) = NaN" + NEWLINE
                + "B1 (pente) = NaN" + NEWLINE
                + "y(x) = NaN + x*NaN" + NEWLINE + "", CorrelationEffortNote.getDisplayResult(result, result));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        CalculationResult result = new CalculationResult(Double.MIN_VALUE);
        result.setRegressionB0(Double.MIN_VALUE);
        result.setRegressionB1(Double.MIN_VALUE);

        assertEquals("Correlation = 4.9E-324" + NEWLINE
                + "Correlation au carre = 0.0" + NEWLINE
                + "Interprétation : Nulle à faible" + NEWLINE
                + "B0 (origine) = 4.9E-324" + NEWLINE
                + "B1 (pente) = 4.9E-324" + NEWLINE
                + "y(x) = 4.9E-324 + x*4.9E-324" + NEWLINE + "", CorrelationEffortNote.getDisplayResult(result, result));

        result = new CalculationResult(Double.NEGATIVE_INFINITY);
        result.setRegressionB0(Double.NEGATIVE_INFINITY);
        result.setRegressionB1(Double.NEGATIVE_INFINITY);

        assertEquals("Correlation = Infinity" + NEWLINE
                + "Correlation au carre = Infinity" + NEWLINE
                + "Interprétation : Cannot get correlation caption for value Infinity. The value must be between 0 and 1" + NEWLINE
                + "B0 (origine) = -Infinity" + NEWLINE
                + "B1 (pente) = -Infinity" + NEWLINE
                + "y(x) = -Infinity + x*-Infinity" + NEWLINE
                + "", CorrelationEffortNote.getDisplayResult(result, result));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        CalculationResult result = new CalculationResult(Double.MAX_VALUE);
        result.setRegressionB0(Double.MAX_VALUE);
        result.setRegressionB1(Double.MAX_VALUE);

        assertEquals("Correlation = 1.7976931348623157E308" + NEWLINE
                + "Correlation au carre = Infinity" + NEWLINE
                + "Interprétation : Cannot get correlation caption for value 1.7976931348623157E308. The value must be between 0 and 1" + NEWLINE
                + "B0 (origine) = 1.7976931348623157E308" + NEWLINE
                + "B1 (pente) = 1.7976931348623157E308" + NEWLINE
                + "y(x) = 1.7976931348623157E308 + x*1.7976931348623157E308" + NEWLINE + "", CorrelationEffortNote.getDisplayResult(result, result));

        result = new CalculationResult(Double.POSITIVE_INFINITY);
        result.setRegressionB0(Double.POSITIVE_INFINITY);
        result.setRegressionB1(Double.POSITIVE_INFINITY);

        assertEquals("Correlation = Infinity" + NEWLINE
                + "Correlation au carre = Infinity" + NEWLINE
                + "Interprétation : Cannot get correlation caption for value Infinity. The value must be between 0 and 1" + NEWLINE
                + "B0 (origine) = Infinity" + NEWLINE
                + "B1 (pente) = Infinity" + NEWLINE
                + "y(x) = Infinity + x*Infinity" + NEWLINE + "", CorrelationEffortNote.getDisplayResult(result, result));
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = new CalculationResult(0.9559205282352726);
        result.setRegressionB0(12.25);
        result.setRegressionB1(245.15);

        assertEquals("Correlation = 0.9559205282352726" + NEWLINE
                + "Correlation au carre = 0.9137840563016026" + NEWLINE
                + "Interprétation : Très forte à parfaite" + NEWLINE
                + "B0 (origine) = 12.25" + NEWLINE
                + "B1 (pente) = 245.15" + NEWLINE
                + "y(x) = 12.25 + x*245.15" + NEWLINE
                + "", CorrelationEffortNote.getDisplayResult(result, result));
    }
}
