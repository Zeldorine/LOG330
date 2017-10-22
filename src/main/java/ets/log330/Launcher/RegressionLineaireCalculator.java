package ets.log330.Launcher;

import static ets.log330.Launcher.Calculator.getFileFromArgs;
import ets.log330.utils.CalculationResult;
import ets.log330.utils.FileReader;
import ets.log330.utils.MathHelper;
import static java.lang.System.exit;
import java.util.List;

/**
 *
 * @author Zeldorine
 */
public class RegressionLineaireCalculator extends Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = getFileFromArgs(args);
        List<List<Double>> data = FileReader.read(path);

        if (data == null || data.isEmpty()) {
            System.out.println("Data cannot be null to calculate variance, exit...");
            exit(-1);
        }

        CalculationResult result = MathHelper.calculateRegresionLineaire(data);

        if (result == null) {
            System.out.println("Calculation result is null, cannot display results, exit...");
            exit(-1);
        }

        System.out.println(getDisplayResult(result));
    }

    /**
     * Display result after calculation
     *
     * @param result The result
     */
    protected static String getDisplayResult(CalculationResult result) {
        StringBuilder displayResult = new StringBuilder();

        if (result == null) {
            displayResult.append("No result to display, result is null.");
        } else {
            if (result.getRegressionB0() == null) {
                displayResult.append("B0 (origine) = null").append(NEW_LINE);
            } else {
                displayResult.append("B0 (origine) = ").append(result.getRegressionB0()).append(NEW_LINE);
            }

            if (result.getRegressionB1() == null) {
                displayResult.append("B1 (pente) = null").append(NEW_LINE);
            } else {
                displayResult.append("B1 (pente) = ").append(result.getRegressionB1()).append(NEW_LINE);
            }

            if (result.getRegressionB0() == null || result.getRegressionB1() == null) {
                displayResult.append("Equation is null").append(NEW_LINE);
            } else {
                displayResult.append("y(x) = ").append(result.getRegressionB0()).append(" + x*").append(result.getRegressionB1()).append(NEW_LINE);
            }
        }

        return displayResult.toString();
    }
}
