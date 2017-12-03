package ets.log330.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zeldorine
 */
public class StudentValue {

    private static final Map<Integer, Map<Integer, Double>> studentValues;

    static {
        studentValues = new HashMap(2);

        Map<Integer, Double> p70Values = new HashMap(35);
        Map<Integer, Double> p90Values = new HashMap(35);
        
        p70Values.put(8, 1.108);
        p90Values.put(8, 1.860);
        
        studentValues.put(70, p70Values);
        studentValues.put(90, p90Values);
    }

    public static Double getStudentValue(int percentage, int nbElement) {
        if (percentage == 70 || percentage == 90) {
            return studentValues.get(percentage).get(nbElement);
        } else {
            System.out.println("Only 70 and 90 percentage value are available");
            return null;
        }
    }
}
