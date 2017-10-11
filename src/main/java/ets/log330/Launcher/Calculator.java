package ets.log330.Launcher;

import ets.log330.utils.CalculationResult;


/**
 *
 * @author Zeldorine
 */
public abstract class Calculator {

    /**
     * Get the file path from args provided to the system.
     *
     * @param args All args provided to the system.
     * @return The file path.
     */
    protected static String getFileFromArgs(String[] args) {
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

    protected static void displayResult(CalculationResult result) {
        System.out.println("Moyenne = " + result.getMoyenne());
        System.out.println("Variance = " + result.getVariance());
        System.out.println("Ecart type = " + result.getEcartType());
        System.out.println("Correlation = " + result.getCorrelation());
    }
}
