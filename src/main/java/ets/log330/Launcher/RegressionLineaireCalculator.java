package ets.log330.Launcher;

import static ets.log330.Launcher.Calculator.getFileFromArgs;
import ets.log330.utils.CalculationResult;
import ets.log330.utils.FileReader;
import ets.log330.utils.MathHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        userInputCalculation(result);
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

    /**
     * Ask to the user to enter a value x to calculate y or y to calculate x
     * (y=ax+b)
     *
     * @param result Regression lineaire coef
     */
    static void userInputCalculation(CalculationResult result) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean stop = false;

            System.out.println("Voulez-vous calculer une valeur x ou y à partir des coefficients ? (x|y|exit) :");
            String response = br.readLine();

            while (!stop) {
                if ("y".equalsIgnoreCase(response)) {
                    System.out.println("Entrer la valeur x à utiliser pour calculer y : ");
                    response = br.readLine();
                    calculeUserInput(true, response, result);
                } else if ("x".equalsIgnoreCase(response)) {
                    System.out.println("Entrer la valeur y à utiliser pour calculer x : ");
                    response = br.readLine();
                    calculeUserInput(false, response, result);
                } else if ("exit".equalsIgnoreCase(response)) {
                    stop = true;
                } else {
                    System.out.println("Voulez-vous calculer une valeur x ou y à partir des coefficients ? (x|y|exit) :");
                    response = br.readLine();
                }
            }
        } catch (IOException ex) {
            System.out.println("An error occured while reading user input. Error : " + ex.getMessage());
        }
    }

    /**
     * Display a value x to calculate y or y to calculate x (y=ax+b)
     *
     * @param isX If the value is a x or a y
     * @param value The value to use to calculate x or y deponds on isX
     * @param result Regression lineaire coef
     */
    static void calculeUserInput(boolean isX, String value, CalculationResult result) {
        if(value == null){
            System.out.println("The value is null, cannot calcule " + (isX ? "Y" : "X") + " value");
            return;
        }
        
        Double valueToCalculate;
        String variable = isX ? "Y" : "X";

        try {
            valueToCalculate = Double.parseDouble(value);
            Double valueCalculated = MathHelper.calculateValueWithLinearRegression(isX, valueToCalculate, result);
            System.out.println(variable + " = " + valueCalculated);
        } catch (NumberFormatException nfe) {
            System.out.println("La valeur " + variable + " à calculer est invalide. " + variable + " doit être un nombre");
        }
    }
}
