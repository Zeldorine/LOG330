package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;
import ets.log330.utils.MathTests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Zeldorine
 */
public class RegressionLineaireCalculatorTest extends MathTests {
    private final RegressionLineaireCalculator regressionLineaireCalculator = new RegressionLineaireCalculator();

    @Test
    @Override
    public void testNullValue() {
        assertEquals("No result to display, result is null.", regressionLineaireCalculator.getDisplayResult(null));
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = new CalculationResult(null, null);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("B0 (origine) = null").append(NEW_LINE);
        displayResult.append("B1 (pente) = null").append(NEW_LINE);
        displayResult.append("Equation is null").append(NEW_LINE);

        assertEquals(displayResult.toString(), regressionLineaireCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        CalculationResult result = new CalculationResult(Double.NaN, Double.NaN);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("B0 (origine) = ").append(Double.NaN).append(NEW_LINE);
        displayResult.append("B1 (pente) = ").append(Double.NaN).append(NEW_LINE);
        displayResult.append("y(x) = ").append(Double.NaN).append(" + x*").append(Double.NaN).append(NEW_LINE);

        assertEquals(displayResult.toString(), regressionLineaireCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        CalculationResult result = new CalculationResult(Double.MIN_VALUE, Double.MIN_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("B0 (origine) = ").append(Double.MIN_VALUE).append(NEW_LINE);
        displayResult.append("B1 (pente) = ").append(Double.MIN_VALUE).append(NEW_LINE);
        displayResult.append("y(x) = ").append(Double.MIN_VALUE).append(" + x*").append(Double.MIN_VALUE).append(NEW_LINE);

        assertEquals(displayResult.toString(), regressionLineaireCalculator.getDisplayResult(result));

        result = new CalculationResult(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("B0 (origine) = ").append(Double.NEGATIVE_INFINITY).append(NEW_LINE);
        displayResult.append("B1 (pente) = ").append(Double.NEGATIVE_INFINITY).append(NEW_LINE);
        displayResult.append("y(x) = ").append(Double.NEGATIVE_INFINITY).append(" + x*").append(Double.NEGATIVE_INFINITY).append(NEW_LINE);

        assertEquals(displayResult.toString(), regressionLineaireCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        CalculationResult result = new CalculationResult(Double.MAX_VALUE, Double.MAX_VALUE);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("B0 (origine) = ").append(Double.MAX_VALUE).append(NEW_LINE);
        displayResult.append("B1 (pente) = ").append(Double.MAX_VALUE).append(NEW_LINE);
        displayResult.append("y(x) = ").append(Double.MAX_VALUE).append(" + x*").append(Double.MAX_VALUE).append(NEW_LINE);

        assertEquals(displayResult.toString(), regressionLineaireCalculator.getDisplayResult(result));

        result = new CalculationResult(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        displayResult = new StringBuilder();
        displayResult.append("B0 (origine) = ").append(Double.POSITIVE_INFINITY).append(NEW_LINE);
        displayResult.append("B1 (pente) = ").append(Double.POSITIVE_INFINITY).append(NEW_LINE);
        displayResult.append("y(x) = ").append(Double.POSITIVE_INFINITY).append(" + x*").append(Double.POSITIVE_INFINITY).append(NEW_LINE);

        assertEquals(displayResult.toString(), regressionLineaireCalculator.getDisplayResult(result));
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = new CalculationResult(-22.552532752034153, 1.727932426206986);

        StringBuilder displayResult = new StringBuilder();
        displayResult.append("B0 (origine) = ").append("-22.552532752034153").append(NEW_LINE);
        displayResult.append("B1 (pente) = ").append("1.727932426206986").append(NEW_LINE);
        displayResult.append("y(x) = ").append("-22.552532752034153").append(" + x*").append("1.727932426206986").append(NEW_LINE);

        assertEquals(displayResult.toString(), regressionLineaireCalculator.getDisplayResult(result));
    }

    @Test
    public void calculeUserInputValideBorneInferieure() {
        CalculationResult result = new CalculationResult(-22.552532752034153, 1.727932426206986);
        RegressionLineaireCalculator.calculeUserInput(true, ""+Double.MIN_VALUE, result);
        RegressionLineaireCalculator.calculeUserInput(true, ""+Double.NEGATIVE_INFINITY, result);
    }

    @Test
    public void calculeUserInputValideBorneSuperieure() {
        CalculationResult result = new CalculationResult(-22.552532752034153, 1.727932426206986);
        RegressionLineaireCalculator.calculeUserInput(true, ""+Double.MAX_VALUE, result);
        RegressionLineaireCalculator.calculeUserInput(true, ""+Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void calculeUserInputValideNotANumber() {
        CalculationResult result = new CalculationResult(-22.552532752034153, 1.727932426206986);
        RegressionLineaireCalculator.calculeUserInput(true, ""+Double.NaN, result);
    }

    @Test
    public void calculeUserInputValideNull() {
        CalculationResult result = new CalculationResult(-22.552532752034153, 1.727932426206986);
        RegressionLineaireCalculator.calculeUserInput(true, null, result);
    }

    @Test
    public void calculeUserInputValideEmpty() {
        CalculationResult result = new CalculationResult(-22.552532752034153, 1.727932426206986);
        RegressionLineaireCalculator.calculeUserInput(true, "", result);
    }

    @Test
    public void calculeUserInputValide() {
        CalculationResult result = new CalculationResult(-22.552532752034153, 1.727932426206986);
        RegressionLineaireCalculator.calculeUserInput(true, "12.25", result);
    }
}
