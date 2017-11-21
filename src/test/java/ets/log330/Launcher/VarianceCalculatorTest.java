package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;
import ets.log330.utils.MathTests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Zeldorine
 */
public class VarianceCalculatorTest extends MathTests {
    private final VarianceCalculator varianceCalculator = new VarianceCalculator();

        @Test
    @Override
    public void testNullValue() {
        assertEquals("No result to display, result is null.", varianceCalculator.getDisplayResult(null));
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = new CalculationResult(null, null, null);
        
        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Moyenne = null").append(NEW_LINE);
        displayResult.append("Variance = null").append(NEW_LINE);
        displayResult.append("Ecart type = null").append(NEW_LINE);
        
        assertEquals(displayResult.toString(), varianceCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        CalculationResult result = new CalculationResult(Double.NaN, Double.NaN, Double.NaN);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Moyenne = ").append(Double.NaN).append(NEW_LINE);
        displayResult.append("Variance = ").append(Double.NaN).append(NEW_LINE);
        displayResult.append("Ecart type = ").append(Double.NaN).append(NEW_LINE);

        assertEquals(displayResult.toString(), varianceCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        CalculationResult result = new CalculationResult(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Moyenne = ").append(Double.MIN_VALUE).append(NEW_LINE);
        displayResult.append("Variance = ").append(Double.MIN_VALUE).append(NEW_LINE);
        displayResult.append("Ecart type = ").append(Double.MIN_VALUE).append(NEW_LINE);

        assertEquals(displayResult.toString(), varianceCalculator.getDisplayResult(result));

        result = new CalculationResult(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("Moyenne = ").append(Double.NEGATIVE_INFINITY).append(NEW_LINE);
        displayResult.append("Variance = ").append(Double.NEGATIVE_INFINITY).append(NEW_LINE);
        displayResult.append("Ecart type = ").append(Double.NEGATIVE_INFINITY).append(NEW_LINE);

        assertEquals(displayResult.toString(), varianceCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        CalculationResult result = new CalculationResult(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Moyenne = ").append(Double.MAX_VALUE).append(NEW_LINE);
        displayResult.append("Variance = ").append(Double.MAX_VALUE).append(NEW_LINE);
        displayResult.append("Ecart type = ").append(Double.MAX_VALUE).append(NEW_LINE);

        assertEquals(displayResult.toString(), varianceCalculator.getDisplayResult(result));

        result = new CalculationResult(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("Moyenne = ").append(Double.POSITIVE_INFINITY).append(NEW_LINE);
        displayResult.append("Variance = ").append(Double.POSITIVE_INFINITY).append(NEW_LINE);
        displayResult.append("Ecart type = ").append(Double.POSITIVE_INFINITY).append(NEW_LINE);

        assertEquals(displayResult.toString(), varianceCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = new CalculationResult(638.9000000000001, 391417.8777777777, 625.6339806770231);
        
        StringBuilder displayResult = new StringBuilder();
        displayResult.append("Moyenne = ").append(638.9000000000001).append(NEW_LINE);
        displayResult.append("Variance = ").append(391417.8777777777).append(NEW_LINE);
        displayResult.append("Ecart type = ").append(625.6339806770231).append(NEW_LINE);

        assertEquals(displayResult.toString(), varianceCalculator.getDisplayResult(result));
    }
}
