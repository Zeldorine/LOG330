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

    @Test
    @Override
    public void testNullValue() {
        assertEquals("No result to display, result is null.", CorrelationEffortNote.getDisplayResult(null));
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = new CalculationResult(null);
        assertEquals("No result to display, result is null.", CorrelationEffortNote.getDisplayResult(result));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        CalculationResult result = new CalculationResult(Double.NaN);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(Double.NaN).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(Double.NaN).append(NEW_LINE);
        displayResult.append("Interprétation : ").append("Cannot get correlation caption for value ").append(Double.NaN).append(". The value must be between 0 and 1").append(NEW_LINE);

        assertEquals(displayResult.toString(), CorrelationEffortNote.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        CalculationResult result = new CalculationResult(Double.MIN_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.MIN_VALUE)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(0.0)).append(NEW_LINE);
        displayResult.append("Interprétation : ").append("Nulle à faible").append(NEW_LINE);

        assertEquals(displayResult.toString(), CorrelationEffortNote.getDisplayResult(result));

        result = new CalculationResult(Double.NEGATIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);
        displayResult.append("Interprétation : ").append("Cannot get correlation caption for value ").append(Double.POSITIVE_INFINITY).append(". The value must be between 0 and 1").append(NEW_LINE);

        assertEquals(displayResult.toString(), CorrelationEffortNote.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        CalculationResult result = new CalculationResult(Double.MAX_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.MAX_VALUE)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);
        displayResult.append("Interprétation : ").append("Cannot get correlation caption for value ").append(Double.MAX_VALUE).append(". The value must be between 0 and 1").append(NEW_LINE);


        assertEquals(displayResult.toString(), CorrelationEffortNote.getDisplayResult(result));

        result = new CalculationResult(Double.POSITIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);
        displayResult.append("Interprétation : ").append("Cannot get correlation caption for value ").append(Double.POSITIVE_INFINITY).append(". The value must be between 0 and 1").append(NEW_LINE);


        assertEquals(displayResult.toString(), CorrelationEffortNote.getDisplayResult(result));
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = new CalculationResult(0.9559205282352726);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(0.9559205282352726)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(0.9137840563016026)).append(NEW_LINE);
        displayResult.append("Interprétation : ").append("Très forte à parfaite").append(NEW_LINE);


        assertEquals(displayResult.toString(), CorrelationEffortNote.getDisplayResult(result));
    }
}
