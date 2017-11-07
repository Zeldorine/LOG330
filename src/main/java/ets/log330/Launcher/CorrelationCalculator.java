package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;
import ets.log330.utils.FileReader;
import ets.log330.utils.MathHelper;
import static java.lang.System.exit;
import java.util.List;

/**
 *
 * @author Zeldorine
 */
public class CorrelationCalculator extends Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = getFileFromArgs(args);
        List<List<Double>> data = FileReader.read(path);

        if (data == null || data.isEmpty()) {
            System.out.println("Data cannot be null to calculate correlation, exit...");
            exit(-1);
        }

        if (data.get(0) == null || data.get(0).isEmpty()) {
            System.out.println("Data cannot be null to calculate correlation, exit...");
            exit(-1);
        }

        CalculationResult result = MathHelper.CalculateCorrelation(data);

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
        
        if(result == null || result.getCorrelation() == null){
            displayResult.append("No result to display, result is null.");
        } else {
            displayResult.append("Correlation = ").append(result.getCorrelation()).append(NEW_LINE);
            displayResult.append("Correlation au carre = ").append(Math.pow(result.getCorrelation(), 2)).append(NEW_LINE);
        }
        
        return displayResult.toString();
    }
}
