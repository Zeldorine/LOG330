package ets.log330.utils;

/**
 *
 * @author Zeldorine
 */
public abstract class CorrelationInterval {

    public static String getInterpretationFromValue(Double value){
        if(value == null){
            System.out.println("Cannot get correlation caption for null value. The value must be between 0 and 1");
            return null;
        }
        
        if(value >= 0 && value < 0.2){
            return "Nulle à faible";
        } else if (value >= 0.2 && value < 0.4) {
            return "Faible à moyenne";
        }else if (value >= 0.4 && value < 0.7) {
            return "Moyenne à forte";
        }else if (value >= 0.7 && value < 0.9) {
            return "Forte à très forte";
        }else if (value >= 0.9 && value <= 1) {
            return "Très forte à parfaite";
        }
        
        return "Cannot get correlation caption for value " + value + ". The value must be between 0 and 1";
    }
}
