package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;
import ets.log330.utils.MathTests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Zeldorine
 */
public class CorrelationCalculatorTests extends MathTests {
    private final CorrelationCalculator correlationCalculator = new CorrelationCalculator();

    @Test
    @Override
    public void testNullValue() {
        assertEquals("No result to display, result is null.", correlationCalculator.getDisplayResult(null));
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = new CalculationResult(null);
        assertEquals("No result to display, result is null.", correlationCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        CalculationResult result = new CalculationResult(Double.NaN);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(Double.NaN).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(Double.NaN).append(NEW_LINE);

        assertEquals(displayResult.toString(), correlationCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        CalculationResult result = new CalculationResult(Double.MIN_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.MIN_VALUE)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(0.0)).append(NEW_LINE);

        assertEquals(displayResult.toString(), correlationCalculator.getDisplayResult(result));

        result = new CalculationResult(Double.NEGATIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);

        assertEquals(displayResult.toString(), correlationCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        CalculationResult result = new CalculationResult(Double.MAX_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.MAX_VALUE)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);

        assertEquals(displayResult.toString(), correlationCalculator.getDisplayResult(result));

        result = new CalculationResult(Double.POSITIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(Double.POSITIVE_INFINITY)).append(NEW_LINE);

        assertEquals(displayResult.toString(), correlationCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = new CalculationResult(0.9559205282352726);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Correlation = ").append(new Double(0.9559205282352726)).append(NEW_LINE);
        displayResult.append("Correlation au carre = ").append(new Double(0.9137840563016026)).append(NEW_LINE);

        assertEquals(displayResult.toString(), correlationCalculator.getDisplayResult(result));
    }
}
