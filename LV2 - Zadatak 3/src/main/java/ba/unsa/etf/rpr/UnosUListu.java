package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnosUListu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> brojevi = new ArrayList<Double>();

        while(true){
            System.out.print("Unesi broj ili stop: ");
            String line = scanner.nextLine();
            if ("stop".equalsIgnoreCase(line.trim())){
                break;
            }
            try{
                Double n = Double.parseDouble(line);
                brojevi.add(n);
            }catch (Exception e){
                System.out.println("Uneseni string nije broj!");
            }
        }

        System.out.println("Rezultat: ");
        System.out.println("MIN: " + MathUtils.min(brojevi));
        System.out.println("MAX: " + MathUtils.max(brojevi));
        System.out.println("MEAN: " + MathUtils.mean(brojevi));
        System.out.println("Standardna devijacija: " + MathUtils.standardnaDevijacija(brojevi));
    }
}