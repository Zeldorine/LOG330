package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;
import ets.log330.utils.MathTests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class IntervalleConfianceTest extends MathTests {

    @Test
    @Override
    public void testNullValue() {
        assertEquals("No result to display, result is null.", IntervalleConfiance.getDisplayResult(null, null));
    }

    @Test
    @Override
    public void testEmptyValue() {
        CalculationResult result = new CalculationResult(null);
        result.setRegressionB0(null);
        assertEquals("Impossible de calculer l'interval, B0 est null", IntervalleConfiance.getDisplayResult(result, 1.0));

        result.setRegressionB0(1.0);
        result.setRegressionB1(null);
        assertEquals("Impossible de calculer l'interval, B1 est null", IntervalleConfiance.getDisplayResult(result, 1.0));

        result = new CalculationResult(Double.MAX_VALUE);
        result.setIntervalValue(Double.MAX_VALUE, 0);
        result.setRegressionB0(Double.MAX_VALUE);
        result.setRegressionB1(Double.MAX_VALUE);

        assertEquals("Calcule de yk avec la regression linéaire, yk = Infinity" + NEW_LINE
                + "Aucun interval pour une certitude de 70%" + NEW_LINE
                + "Aucun interval pour une certitude de 90%" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));

        result.setIntervalValue(Double.MAX_VALUE, 70);
        assertEquals("Calcule de yk avec la regression linéaire, yk = Infinity" + NEW_LINE
                + "Pour une certitude de 70% :" + NEW_LINE
                + "Valeur de l'interval = 1.7976931348623157E308" + NEW_LINE
                + "Interval de confiance [Infinity, Infinity]" + NEW_LINE
                + "Aucun interval pour une certitude de 90%" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0)
        );
    }

    @Test
    @Override
    public void testNotANumberValue() {
        CalculationResult result = new CalculationResult();
        result.setIntervalValue(Double.NaN, 0);
        result.setRegressionB0(Double.NaN);
        result.setRegressionB1(Double.NaN);

        assertEquals("Calcule de yk avec la regression linéaire, yk = NaN" + NEW_LINE
                + "Aucun interval pour une certitude de 70%" + NEW_LINE
                + "Aucun interval pour une certitude de 90%" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));

        result.setIntervalValue(Double.NaN, 70);
        result.setIntervalValue(Double.NaN, 90);
        result.setRegressionB0(Double.NaN);
        result.setRegressionB1(Double.NaN);

        assertEquals("Calcule de yk avec la regression linéaire, yk = NaN" + NEW_LINE
                + "Pour une certitude de 70% :" + NEW_LINE
                + "Valeur de l'interval = NaN" + NEW_LINE
                + "Interval de confiance [NaN, NaN]" + NEW_LINE
                + "Pour une certitude de 90% :" + NEW_LINE
                + "Valeur de l'interval = NaN" + NEW_LINE
                + "Interval de confiance [NaN, NaN]" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        CalculationResult result = new CalculationResult(Double.MIN_VALUE);
        result.setIntervalValue(Double.MIN_VALUE, 70);
        result.setIntervalValue(Double.MIN_VALUE, 90);
        result.setRegressionB0(Double.MIN_VALUE);
        result.setRegressionB1(Double.MIN_VALUE);

        assertEquals("Calcule de yk avec la regression linéaire, yk = 1.0E-323" + NEW_LINE
                + "Pour une certitude de 70% :" + NEW_LINE
                + "Valeur de l'interval = 4.9E-324" + NEW_LINE
                + "Interval de confiance [4.9E-324, 1.5E-323]" + NEW_LINE
                + "Pour une certitude de 90% :" + NEW_LINE
                + "Valeur de l'interval = 4.9E-324" + NEW_LINE
                + "Interval de confiance [4.9E-324, 1.5E-323]" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));

        result = new CalculationResult(Double.NEGATIVE_INFINITY);
        result.setIntervalValue(Double.NEGATIVE_INFINITY, 70);
        result.setIntervalValue(Double.NEGATIVE_INFINITY, 90);
        result.setRegressionB0(Double.NEGATIVE_INFINITY);
        result.setRegressionB1(Double.NEGATIVE_INFINITY);

        assertEquals("Calcule de yk avec la regression linéaire, yk = -Infinity" + NEW_LINE
                + "Pour une certitude de 70% :" + NEW_LINE
                + "Valeur de l'interval = -Infinity" + NEW_LINE
                + "Interval de confiance [NaN, -Infinity]" + NEW_LINE
                + "Pour une certitude de 90% :" + NEW_LINE
                + "Valeur de l'interval = -Infinity" + NEW_LINE
                + "Interval de confiance [NaN, -Infinity]" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        CalculationResult result = new CalculationResult(Double.MAX_VALUE);
        result.setIntervalValue(Double.MAX_VALUE, 70);
        result.setIntervalValue(Double.MAX_VALUE, 90);
        result.setRegressionB0(Double.MAX_VALUE);
        result.setRegressionB1(Double.MAX_VALUE);

        assertEquals("Calcule de yk avec la regression linéaire, yk = Infinity" + NEW_LINE
                + "Pour une certitude de 70% :" + NEW_LINE
                + "Valeur de l'interval = 1.7976931348623157E308" + NEW_LINE
                + "Interval de confiance [Infinity, Infinity]" + NEW_LINE
                + "Pour une certitude de 90% :" + NEW_LINE
                + "Valeur de l'interval = 1.7976931348623157E308" + NEW_LINE
                + "Interval de confiance [Infinity, Infinity]" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));

        result = new CalculationResult(Double.POSITIVE_INFINITY);
        result.setIntervalValue(Double.POSITIVE_INFINITY, 70);
        result.setIntervalValue(Double.POSITIVE_INFINITY, 90);
        result.setRegressionB0(Double.POSITIVE_INFINITY);
        result.setRegressionB1(Double.POSITIVE_INFINITY);

        assertEquals("Calcule de yk avec la regression linéaire, yk = Infinity" + NEW_LINE
                + "Pour une certitude de 70% :" + NEW_LINE
                + "Valeur de l'interval = Infinity" + NEW_LINE
                + "Interval de confiance [NaN, Infinity]" + NEW_LINE
                + "Pour une certitude de 90% :" + NEW_LINE
                + "Valeur de l'interval = Infinity" + NEW_LINE
                + "Interval de confiance [NaN, Infinity]" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));
    }

    @Test
    @Override
    public void testValide() {
        CalculationResult result = new CalculationResult(0.9559205282352726);
        result.setIntervalValue(412.0,70);
        result.setIntervalValue(542.0,90);
        result.setRegressionB0(12.25);
        result.setRegressionB1(245.15);

        assertEquals("Calcule de yk avec la regression linéaire, yk = 257.4" + NEW_LINE
                + "Pour une certitude de 70% :" + NEW_LINE
                + "Valeur de l'interval = 412.0" + NEW_LINE
                + "Interval de confiance [-154.60000000000002, 669.4]" + NEW_LINE
                + "Pour une certitude de 90% :" + NEW_LINE
                + "Valeur de l'interval = 542.0" + NEW_LINE
                + "Interval de confiance [-284.6, 799.4]" + NEW_LINE, IntervalleConfiance.getDisplayResult(result, 1.0));
    }
}
