package ba.unsa.etf.rpr;

import java.util.Scanner;

public class DjeljivostCifara {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite neki cijeli broj: ");
        int br = scanner.nextInt();
        for (int i = 1; i < br; i++){
            if (jeDjeljiv(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean jeDjeljiv(int n){
        int sum = sumaCifara(n);
        return n%sum == 0;
    }

    private static int sumaCifara(int n){
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n = n / 10;
        }
        return sum;
    }
}