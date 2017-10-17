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
public class VarianceCalculator extends Calculator {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = getFileFromArgs(args);
        List<List<Double>> data = FileReader.read(path);
        
        if(data == null || data.isEmpty()){
            System.out.println("Data cannot be null to calculate variance, exit...");
            exit(-1);
        }
        
        CalculationResult result = MathHelper.calculate(data.get(0));
        
        if(result == null){
            System.out.println("Calculation result is null, cannot display results, exit...");
            exit(-1);
        }
        
        displayResult(result);
    }
    
    /**
     * Display result after calculation
     * @param result  The result
     */
    protected static void displayResult(CalculationResult result){
        if(result == null){
            System.out.println("No result to display, result is null.");
        }
        
        System.out.println("Moyenne = " + result.getMoyenne());
        System.out.println("Variance = " + result.getVariance());
        System.out.println("Ecart type = " + result.getEcartType());
    }
}
