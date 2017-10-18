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
        
        System.out.println(getDisplayResult(result));
    }
    
    /**
     * Display result after calculation
     * @param result  The result
     */
    protected static String getDisplayResult(CalculationResult result){
        StringBuilder displayResult = new StringBuilder();
        
        if(result == null){
            displayResult.append("No result to display, result is null.");
        } else {
            if(result.getMoyenne() == null){
                displayResult.append("Moyenne = null").append(NEW_LINE);
            }else {
                displayResult.append("Moyenne = ").append(result.getMoyenne()).append(NEW_LINE);
            }
            
            if(result.getMoyenne() == null){
                displayResult.append("Variance = null").append(NEW_LINE);
            }else {
                displayResult.append("Variance = ").append(result.getVariance()).append(NEW_LINE);
            }
            
            if(result.getMoyenne() == null){
                displayResult.append("Ecart type = null").append(NEW_LINE);
            }else {
                displayResult.append("Ecart type = ").append(result.getEcartType()).append(NEW_LINE);
            }
        }
        
        
        return displayResult.toString();
    }
}
