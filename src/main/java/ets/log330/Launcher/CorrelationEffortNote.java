package ets.log330.Launcher;

import static ets.log330.Launcher.Calculator.NEW_LINE;
import static ets.log330.Launcher.Calculator.getFileFromArgs;
import ets.log330.utils.CalculationResult;
import ets.log330.utils.CorrelationInterval;
import ets.log330.utils.FileReader;
import ets.log330.utils.MathHelper;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeldorine
 */
public class CorrelationEffortNote extends Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = getFileFromArgs(args);
        int[] linesToRemove = new int[]{0, 1};
        int[] columnsToRemove = new int[]{0};
        List<List<Double>> data = FileReader.read(path, false, linesToRemove, columnsToRemove);

        if (data == null || data.size() < 2) {
            System.out.println("Data cannot be null or contain only one column to calculate correlation , exit...");
            exit(-1);
        }

        List<Double> notes = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        List<List<Double>> correlationData = new ArrayList<>(2);
        List<List<Double>> regressionData = new ArrayList<>(2);

        correlationData.add(MathHelper.sumAndMergeList(data, 1));
        correlationData.add(notes);

        regressionData.add(MathHelper.sumAndMergeList(data, data.size()));
        regressionData.add(notes);

        if (correlationData.get(0) == null || correlationData.get(0).isEmpty()) {
            System.out.println("Data cannot be null to calculate correlation, exit...");
            exit(-1);
        }

        CalculationResult correlationResult = MathHelper.calculateCorrelation(correlationData);
        CalculationResult regressionResult = MathHelper.calculateRegresionLineaire(regressionData);

        System.out.println(getDisplayResult(correlationResult, regressionResult));
    }

    /**
     * Display correlation and regression result
     * @param correlationResult The correlation result
     * @param regressionResult The regression result
     * @return A string containing all regression and correlation result
     */
    protected static String getDisplayResult(CalculationResult correlationResult, CalculationResult regressionResult) {
        return getDisplayCorrelationResult(correlationResult) + getDisplayRegressionResult(regressionResult);
    }

    /**
     * Display correlation result after calculation
     *
     * @param correlationResult The correlation result
     * @return A string containing correlation result
     */
    private static String getDisplayCorrelationResult(CalculationResult correlationResult) {
        StringBuilder displayResult = new StringBuilder();

        if (correlationResult == null || correlationResult.getCorrelation() == null) {
            displayResult.append("No correlation result to display, result is null.");
        } else {
            displayResult.append("Correlation = ").append(correlationResult.getCorrelation()).append(NEW_LINE);
            displayResult.append("Correlation au carre = ").append(Math.pow(correlationResult.getCorrelation(), 2)).append(NEW_LINE);
            displayResult.append("Interprétation : ").append(CorrelationInterval.getInterpretationFromValue(correlationResult.getCorrelation())).append(NEW_LINE);
        }

        return displayResult.toString();
    }

    /**
     * Display regression result after calculation
     *
     * @param regressionResult The regression result
     * @return A string containing regression result
     */
    private static String getDisplayRegressionResult(CalculationResult regressionResult) {
        StringBuilder displayResult = new StringBuilder();

        if (regressionResult == null) {
            displayResult.append("No regression to display, result is null.");
        } else {
            if (regressionResult.getRegressionB0() == null) {
                displayResult.append("B0 (origine) = null").append(NEW_LINE);
            } else {
                displayResult.append("B0 (origine) = ").append(regressionResult.getRegressionB0()).append(NEW_LINE);
            }

            if (regressionResult.getRegressionB1() == null) {
                displayResult.append("B1 (pente) = null").append(NEW_LINE);
            } else {
                displayResult.append("B1 (pente) = ").append(regressionResult.getRegressionB1()).append(NEW_LINE);
            }

            if (regressionResult.getRegressionB0() == null || regressionResult.getRegressionB1() == null) {
                displayResult.append("Equation is null").append(NEW_LINE);
            } else {
                displayResult.append("y(x) = ").append(regressionResult.getRegressionB0()).append(" + x*").append(regressionResult.getRegressionB1()).append(NEW_LINE);
            }
        }

        return displayResult.toString();
    }
}
