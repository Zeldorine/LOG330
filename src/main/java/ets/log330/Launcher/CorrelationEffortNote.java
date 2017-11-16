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
        int[] linesToRemove = new int[]{0,1};
        int[] columnsToRemove = new int[]{0};
        List<List<Double>> data = FileReader.read(path, false, linesToRemove, columnsToRemove);

        if (data == null || data.size() < 2) {
            System.out.println("Data cannot be null or contain only one column to calculate correlation , exit...");
            exit(-1);
        }

        List<Double> notes = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        List<List<Double>> dataToCalculate = new ArrayList<>(2);
        dataToCalculate.add(MathHelper.sumAndMergeList(data));
        dataToCalculate.add(notes);

        if (dataToCalculate.get(0) == null || dataToCalculate.get(0).isEmpty()) {
            System.out.println("Data cannot be null to calculate correlation, exit...");
            exit(-1);
        }

        CalculationResult result = MathHelper.CalculateCorrelation(dataToCalculate);

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
     * @return
     */
    protected static String getDisplayResult(CalculationResult result) {
        StringBuilder displayResult = new StringBuilder();

        if (result == null || result.getCorrelation() == null) {
            displayResult.append("No result to display, result is null.");
        } else {
            displayResult.append("Correlation = ").append(result.getCorrelation()).append(NEW_LINE);
            displayResult.append("Correlation au carre = ").append(Math.pow(result.getCorrelation(), 2)).append(NEW_LINE);
            displayResult.append("Interprétation : ").append(CorrelationInterval.getInterpretationFromValue(result.getCorrelation())).append(NEW_LINE);
        }

        return displayResult.toString();
    }
}
