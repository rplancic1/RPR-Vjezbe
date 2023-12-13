package ba.unsa.etf.rpr;

public class Math {
    public static double sin(double unos){
        double sum = 0;
        for (int i = 0; i <= 5; i++) {
            sum += stepen(-1, i) * (stepen(unos, 2 * i + 1) / faktorijel(2 * i + 1));
        }
        return sum;
    }

    public static int faktorijel(int unos){
        int fact = 1;
        for (int i = 2; i <= unos; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static double stepen(double unos, int pow){
        double produkt = 1;
        for(int i=0; i<pow; i++){
            produkt *= unos;
        }
        return produkt;
    }
}
