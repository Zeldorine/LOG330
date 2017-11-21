package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provide method to calculate variance .
 *
 * @author Zeldorine
 */
public abstract class MathHelper {

    /**
     * This method allow to calculate variance from a list of number.
     *
     * @param data A list of all data used to calculate variance.
     * @return {@link utils.CalculationResult}.
     */
    public static CalculationResult calculate(List<Double> data) {
        if (data == null) {
            System.out.println("Data cannot be null to calculate variance");
            return null;
        }

        if (data.isEmpty()) {
            return new CalculationResult(new Double(0), new Double(0), new Double(0));
        }

        Double moyenne = calculateMoyenne(data);
        List<Double> distance = calculateDistance(data, moyenne);
        Double sommeDistance = calculateSommeDistance(distance);
        Double variance = calculateVariance(sommeDistance, data.size());
        Double ecartType = calculateEcartType(variance);

        return new CalculationResult(moyenne, variance, ecartType);
    }

    /**
     * This methode calculate moyenne from a list of number.
     *
     * @param data List of number .
     * @return Moyenne.
     */
    static Double calculateMoyenne(List<Double> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        Double somme = new Double(0);

        for (Double element : data) {
            somme += element;
        }

        return (1 / (double) data.size()) * (double) somme;
    }

    /**
     * This method calculate distance for each element of the list.
     *
     * @param data A list of data.
     * @param moyenne Moyenne calculated form the list.
     * @return A list with the distance for all element in the list.
     */
    static List<Double> calculateDistance(List<Double> data, Double moyenne) {
        if (moyenne == null) {
            System.out.println("Moyenne is null, cannot calculate distance");
            return null;
        }

        if (data == null) {
            System.out.println("Data is null, cannot calculate distance");
            return null;
        }

        List<Double> distances = new ArrayList<>(data.size());

        for (Double element : data) {
            distances.add(Math.pow(element - moyenne, 2));
        }

        return distances;
    }

    /**
     * This methode calculate a sum of distance.
     *
     * @param distance A list of each distance.
     * @return Sum of distance.
     */
    static Double calculateSommeDistance(List<Double> distance) {
        if (distance == null) {
            System.out.println("Distance is null, cannot calculate somme distance");
            return null;
        }

        Double somme = new Double(0);

        for (Double element : distance) {
            somme += element;
        }

        return somme;
    }

    /**
     * This methode calculate the variance.
     *
     * @param sommeDistance Sum of distance.
     * @param totalData Total element used to calculate variance.
     * @return The variance.
     */
    static Double calculateVariance(Double sommeDistance, int totalData) {
        if (sommeDistance == null) {
            System.out.println("Somme distance is null, cannot calculate variance");
            return null;
        }

        if (totalData < 2) {
            System.out.println("The number of total value cannot be less than 2. Actual value is: " + totalData);
            return null;
        }

        return (1 / (double) (totalData - 1)) * sommeDistance;
    }

    /**
     * This method calculate ecart type from the variance.
     *
     * @param variance Variance.
     * @return Ecart Type.
     */
    static Double calculateEcartType(Double variance) {
        if (variance == null) {
            System.out.println("Variance is null, cannot calculate ecart type");
            return null;
        }

        return Math.sqrt(variance);
    }

    /**
     * This method allow to calculate correlation from a list of number.
     *
     * @param data A list of all data used to calculate correlation.
     * @return {@link utils.CalculationResult}.
     */
    public static CalculationResult calculateCorrelation(List<List<Double>> data) {
        if (data == null || data.isEmpty()) {
            System.out.println("data is null, cannot calculate correlation");
            return new CalculationResult(null);
        }

        if (data.size() != 2) {
            System.out.println("To calculate correlation it should be 2 columns or " + data.size() + " was found");
            return new CalculationResult(null);
        }
        
        Double correlation = null;

        try {
            Double n = new Double(data.get(0).size());
            Double sumXY = calculateSumProductElementBetweenList(data);
            Double sumX = calculateSumPowElementList(data.get(0), 1);
            Double sumY = calculateSumPowElementList(data.get(1), 1);
            Double sumXCarre = calculateSumPowElementList(data.get(0), 2);
            Double sumYCarre = calculateSumPowElementList(data.get(1), 2);

            correlation = ((n * sumXY) - (sumX * sumY)) / (Math.sqrt(((n * sumXCarre) - Math.pow(sumX, 2)) * (n * sumYCarre - Math.pow(sumY, 2))));
        } catch (Exception e) {
            System.out.println("Cannot calculate correlation. Error " + e.getMessage());
            return new CalculationResult(null);
        }
        
        return new CalculationResult(correlation);
    }

    /**
     * This method allow to calculate a sum of number raised to the power of pow
     * .
     *
     * @param data A list of all data used to calculate correlation.
     * @param pow the exponent
     * @return {@link utils.CalculationResult}.
     */
    static Double calculateSumPowElementList(List<Double> data, int pow) {
        if (data == null) {
            System.out.println("Data is null, cannot calculate sum.");
            return null;
        }

        if (data.isEmpty()) {
            return new Double(0);
        }

        Double sum = new Double(0);
        for (Double value : data) {
            sum += Math.pow(value, pow);
        }

        return sum;
    }

    /**
     * This method allow to calculate a sum of product number between lists
     *
     * @param data set of list correspondant to multiple columns to product
     * @return the sum
     */
    static Double calculateSumProductElementBetweenList(List<List<Double>> data) {
        if (data == null) {
            System.out.println("Data is null, cannot calculate sum.");
            return null;
        }

        if (data.isEmpty()) {
            return new Double(0);
        }

        if (data.size() < 2) {
            return calculateSumPowElementList(data.get(0), 1);
        }

        Double sum = new Double(0);

        for (int i = 0; i < data.get(0).size(); i++) {
            Double product = new Double(1);

            for (int j = 0; j < data.size(); j++) {
                product *= data.get(j).get(i);
            }

            sum += product;
        }

        return sum;
    }

    /**
     * This method allow to calculate regression lineaire from a list of number.
     *
     * @param data A list of all data used to calculate regression lineaire.
     * @return {@link utils.CalculationResult}.
     */
    public static CalculationResult calculateRegresionLineaire(List<List<Double>> data) {
        if (data == null || data.isEmpty()) {
            System.out.println("data is null, cannot calculate correlation");
            return new CalculationResult(null);
        }

        if (data.size() != 2) {
            System.out.println("To calculate correlation it should be 2 columns or " + data.size() + " was found");
            return new CalculationResult(null);
        }

        Double xmoy = calculateMoyenne(data.get(0));
        Double ymoy = calculateMoyenne(data.get(1));

        Double b1 = calculateRegressionLineaireB1(data, xmoy, ymoy);
        Double b0 = calculateRegressionLineaireB0(b1, xmoy, ymoy);

        return new CalculationResult(b0, b1);
    }

    /**
     * This method allow to calculate regression lineaire B1 from a list of
     * number.
     *
     * @param data A list of all data used to calculate regression lineaire.
     * @param xmoy x moyenne.
     * @param ymoy y moyenne.
     * @return B1.
     */
    static Double calculateRegressionLineaireB1(List<List<Double>> data, Double xmoy, Double ymoy) {
        if (data == null || data.isEmpty() || xmoy == null || ymoy == null) {
            System.out.println("data, xmoy or ymoy is null, cannot calculate correlation");
            return null;
        }

        if (data.size() != 2) {
            System.out.println("To calculate correlation it should be 2 columns or " + data.size() + " was found");
            return null;
        }

        Double n = new Double(data.get(0).size());
        Double sumXY = calculateSumProductElementBetweenList(data);
        Double sumXCarre = calculateSumPowElementList(data.get(0), 2);

        return (sumXY - (n * xmoy * ymoy)) / (sumXCarre - (n * xmoy * xmoy));
    }

    /**
     * This method allow to calculate regression lineaire B0 from a list of
     * number.
     *
     * @param b1 B1.
     * @param xmoy x moyenne.
     * @param ymoy y moyenne.
     * @return B0.
     */
    static Double calculateRegressionLineaireB0(Double b1, Double xmoy, Double ymoy) {
        if (b1 == null || xmoy == null || ymoy == null) {
            System.out.println("Cannot calculate B0, xmoy, ymoy or B1 is null");
            return null;
        }

        return ymoy - b1 * xmoy;
    }

    /**
     * Allow to calculate the Y value from a X and regression lineraire coef (y
     * = ax+b)
     *
     * @param isX To know if the methode calcul X or Y
     * @param value The value can correspond to a X or Y depends on isX true or
     * false.
     * @param result Regression lineaire coef
     * @return X value calculate from coef and Y
     */
    public static Double calculateValueWithLinearRegression(boolean isX, Double value, CalculationResult result) {
        if (value == null) {
            System.out.println("The value is null, cannot calcule " + (isX ? "Y" : "X") + " value");
            return null;
        }

        if (result == null || result.getRegressionB1() == null || result.getRegressionB0() == null) {
            System.out.println("The linear regression coefs are null, cannot calcule " + (isX ? "Y" : "X") + " value");
            return null;
        }

        if (isX) {
            // Search y : b1*x + b0
            return result.getRegressionB1() * value + result.getRegressionB0();
        } else {
            // Search x : y/b1 - b0
            return (value - result.getRegressionB0()) / result.getRegressionB1();
        }
    }

    /**
     * Do the sum of each element line by line and divide the sum by the divisor.
     * @param data The list of list to add and merge
     * @param divisor The divisor to divide the sum of all elements
     * @return A list with all value added and divide by the divisor 
     */
    public static List<Double> sumAndMergeList(List<List<Double>> data, int divisor) {
        if (data == null) {
            System.out.println("The data is null, cannot merge list ");
            return null;
        }

        if (data.isEmpty()) {
            return new ArrayList<>();
        }

        if (data.size() == 1) {
            return data.get(0);
        }

        int nbElements = data.get(0).size();
        List<Double> mergedList = new ArrayList<>(nbElements);

        for (int j = 0; j < nbElements; j++) {
            Double sum = new Double(0);
            for (int i = 0; i < data.size(); i++) {
                sum += data.get(i).get(j);
            }

            mergedList.add((sum/divisor));
        }

        return mergedList;
    }
}
