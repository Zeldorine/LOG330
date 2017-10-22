package ets.log330.utils;

/**
 * This class encapsulate all informations about a variance calculation :
 * <ul>
 * <li> Moyenne
 * <li> Variance
 * <li> Ecart Type
 * </ul>
 *
 * @author Zeldorine
 */
public class CalculationResult {

    private Double moyenne;
    private Double variance;
    private Double ecartType;
    private Double correlation;
    private Double regressionB1;
    private Double regressionB0;

    public CalculationResult() {
    }

    /**
     * A result of calculation provided by {@link utils.MathHelper}.
     *
     * @param moyenne The moyenne.
     * @param variance The variance.
     * @param ecartType The ecart type.
     */
    public CalculationResult(Double moyenne, Double variance, Double ecartType) {
        this.moyenne = moyenne;
        this.variance = variance;
        this.ecartType = ecartType;
    }

    /**
     * A result of calculation provided by {@link utils.MathHelper}.
     *
     * @param correlation The correlation.
     */
    public CalculationResult(Double correlation) {
        if (correlation != null) {
            this.correlation = Math.abs(correlation);
        }
    }

    /**
     * A result of calculation provided by {@link utils.MathHelper}.
     *
     * @param correlation The correlation.
     */
    public CalculationResult(Double regressionB0, Double regressionB1) {
        this.regressionB0 = regressionB0;
        this.regressionB1 = regressionB1;
    }

    /**
     * Get the moyenne.
     *
     * @return The moyenne.
     */
    public Double getMoyenne() {
        return moyenne;
    }

    /**
     * Set the moyenne.
     *
     * @param moyenne The new moyenne.
     */
    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    /**
     * Get the variance.
     *
     * @return The variance.
     */
    public Double getVariance() {
        return variance;
    }

    /**
     * Set the variance.
     *
     * @param variance The new variance.
     */
    public void setVariance(Double variance) {
        this.variance = variance;
    }

    /**
     * Get the ecart type.
     *
     * @return the ecart type.
     */
    public Double getEcartType() {
        return ecartType;
    }

    /**
     * Set the ecart type.
     *
     * @param ecartType The ecart type.
     */
    public void setEcartType(Double ecartType) {
        this.ecartType = ecartType;
    }

    /**
     * Get the correlation.
     *
     * @return the correlation.
     */
    public Double getCorrelation() {
        return correlation;
    }

    /**
     * Set the correlation.
     *
     * @param correlation The correlation.
     */
    public void setCorrelation(Double correlation) {
        if (correlation != null) {
            this.correlation = Math.abs(correlation);
        }
    }

    /**
     * Get the regression B1.
     *
     * @return the regression B1.
     */
    public Double getRegressionB1() {
        return regressionB1;
    }

    /**
     * Set the regression B1.
     *
     * @param regressionB1 The regression B1.
     */
    public void setRegressionB1(Double regressionB1) {
        this.regressionB1 = regressionB1;
    }

    /**
     * Get the regression B0.
     *
     * @return the regression B0.
     */
    public Double getRegressionB0() {
        return regressionB0;
    }

    /**
     * Set the regression B0.
     *
     * @param regressionB0 The regression B0.
     */
    public void setRegressionB0(Double regressionB0) {
        this.regressionB0 = regressionB0;
    }
}
