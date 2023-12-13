package ba.unsa.etf.rpr;

import java.util.List;

public class MathUtils {
    public static Double min(List<Double> brojevi){
        double min = Double.MAX_VALUE;
        for(Double num : brojevi){
            if (num < min){
                min = num;
            }
        }
        return min;
    }

    public static Double max(List<Double> brojevi){
        double max = Double.MIN_VALUE;
        for(Double num : brojevi) {
            if (num > max){
                max = num.floatValue();
            }
        }
        return max;
    }

    public static Double mean(List<Double> brojevi){
        double sum = 0;
        for(Double num : brojevi){
            sum += num;
        }
        return sum/brojevi.size();
    }

    public static Double standardnaDevijacija(List<Double> brojevi){
        Double mean = MathUtils.mean(brojevi);
        float standardnaDevijacija = 0;
        for(Double num: brojevi) {
            standardnaDevijacija += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardnaDevijacija/brojevi.size());
    }
}
