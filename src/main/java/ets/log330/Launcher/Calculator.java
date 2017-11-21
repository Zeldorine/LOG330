package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;

/**
 *
 * @author Zeldorine
 */
public abstract class Calculator {

    protected static final String NEW_LINE = System.getProperty("line.separator");

    /**
     * Get the file path from args provided to the system.
     *
     * @param args All args provided to the system.
     * @return The file path.
     */
    protected static String getFileFromArgs(String[] args) {
        if(args == null){
            System.out.println("There are no args, cannot get file.");
            return null;
        }
        
        int nbArgs = args.length;

        if (nbArgs == 0) {
            System.out.println("There are no args, cannot get file.");
            return null;
        } else if (nbArgs > 1) {
            System.out.println("There are too many args, cannot get file. Only one arg is expected, the file path.");
            return null;
        } else {
            return args[0];
        }
    }
    
    /**
     * Display attributs value for CalculationResult
     * @param result The result to display
     * @return A string contains a display result
     */
    protected String getDisplayResult(CalculationResult result) {
        StringBuilder displayResult = new StringBuilder();

        if (result == null) {
            displayResult.append("No result to display, result is null.");
        } else {
            displayResult.append("Moyenne = ").append(result.getMoyenne()).append(NEW_LINE);
            displayResult.append("Variance = ").append(result.getVariance()).append(NEW_LINE);
            displayResult.append("Ecart type = ").append(result.getEcartType()).append(NEW_LINE);
            displayResult.append("Correlation = ").append(result.getCorrelation()).append(NEW_LINE);
        }

        return displayResult.toString();
    }
}
