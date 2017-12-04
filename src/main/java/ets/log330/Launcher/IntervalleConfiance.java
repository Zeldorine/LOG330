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

/**
 *
 * @author Zeldorine
 */
public class IntervalleConfiance extends Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = getFileFromArgs(args);
        List<List<Double>> data = FileReader.read(path, true);

        if (data == null || data.isEmpty()) {
            System.out.println("Data cannot be null to calculate interval, exit...");
            exit(-1);
        }

        Double xk = getUserInput();
        
        if(xk == null){
            exit(0);
        }
        
        CalculationResult result = MathHelper.calculateInterval(data, xk);

        if (result == null) {
            System.out.println("Calculation result is null, cannot display results, exit...");
            exit(-1);
        }

        System.out.println(getDisplayResult(result, xk));
    }

    /**
     * Display result after calculation
     *
     * @param result The result
     * @return
     */
    static String getDisplayResult(CalculationResult result, Double xk) {
        StringBuilder displayResult = new StringBuilder();

        if (result == null) {
            displayResult.append("No result to display, result is null.");
        } else if (result.getRegressionB0() == null) {
            displayResult.append("Impossible de calculer l'interval, B0 est null");
        } else if (result.getRegressionB1() == null) {
            displayResult.append("Impossible de calculer l'interval, B1 est null");
        } else {
            Double yk = result.getRegressionB0() + xk * result.getRegressionB1();
            displayResult.append("Calcule de yk avec la regression linéaire, yk = ").append(yk).append(NEW_LINE);

            if (result.getIntervalValue(70) == null) {
                displayResult.append("Aucun interval pour une certitude de 70%").append(NEW_LINE);
            } else {
                Double interval70 = result.getIntervalValue(70);
                Double min70 = yk - interval70;
                Double max70 = yk + interval70;

                displayResult.append("Pour une certitude de 70% :").append(NEW_LINE);
                displayResult.append("Valeur de l'interval = ").append(interval70).append(NEW_LINE);
                displayResult.append("Interval de confiance [").append(min70).append(", ").append(max70).append("]").append(NEW_LINE);
            }

            if (result.getIntervalValue(90) == null) {
                displayResult.append("Aucun interval pour une certitude de 90%").append(NEW_LINE);
            } else {
                Double interval90 = result.getIntervalValue(90);
                Double min90 = yk - interval90;
                Double max90 = yk + interval90;

                displayResult.append("Pour une certitude de 90% :").append(NEW_LINE);
                displayResult.append("Valeur de l'interval = ").append(interval90).append(NEW_LINE);
                displayResult.append("Interval de confiance [").append(min90).append(", ").append(max90).append("]").append(NEW_LINE);
            }
        }

        return displayResult.toString();
    }

    /**
     * Ask to the user to enter a value xk
     *
     */
    private static Double getUserInput() {
        Double xk = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            boolean stop = false;
            String response;

            System.out.println("Quel valeur xk voulez-vous utiliser pour l'interval de confiance ? (exit) :");
            
            while (!stop) {
                response = bufferedReader.readLine();

                if ("exit".equalsIgnoreCase(response)) {
                    stop = true;
                } else {
                    try {
                        xk = Double.parseDouble(response);
                        stop = true;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Veuillez entrer un chiffre valide ou exit pour quitter :");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("An error occured while reading user input. Error : " + ex.getMessage());
        }

        return xk;
    }
}
