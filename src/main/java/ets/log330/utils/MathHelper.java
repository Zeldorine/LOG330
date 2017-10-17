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
        Double somme = new Double(0);

        if (data == null || data.isEmpty()) {
            return somme;
        }

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

        List<Double> distances = new ArrayList<Double>(data.size());

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
        
        if(totalData < 2){
            System.out.println("The number of total value cannot be less than 1. Actual value is: " + totalData);
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
    public static CalculationResult CalculateCorrelation(List<List<Double>> data) {
        if (data == null || data.isEmpty()) {
            System.out.println("data is null, cannot calculate correlation");
            return new CalculationResult(null);
        }

        if (data.size() != 2) {
            System.out.println("To calculate correlation it should be 2 columns or " + data.size() + " was found");
            return new CalculationResult(null);
        }

        Double n = new Double(data.get(0).size());
        Double sumXY = calculateSumProduct(data);
        Double sumX = calculateSumPow(data.get(0), 1);
        Double sumY = calculateSumPow(data.get(1), 1);
        Double sumXCarre = calculateSumPow(data.get(0), 2);
        Double sumYCarre = calculateSumPow(data.get(1), 2);

        Double correlation = ((n * sumXY) - (sumX * sumY)) / (Math.sqrt(((n * sumXCarre) - Math.pow(sumX, 2)) * (n * sumYCarre - Math.pow(sumY, 2))));

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
    static Double calculateSumPow(List<Double> data, int pow) {
        if (data == null || data.isEmpty()) {
            System.out.println("Data is null or empty, cannot calculate sum.");
            return null;
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
    static Double calculateSumProduct(List<List<Double>> data) {
        if (data == null || data.isEmpty()) {
            System.out.println("Data is null or empty, cannot calculate sum.");
            return null;
        }

        if (data.size() < 2) {
            return calculateSumPow(data.get(0), 1);
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
}
