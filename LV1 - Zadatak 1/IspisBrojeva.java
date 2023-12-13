package ba.unsa.etf.rpr;

import java.util.Scanner;

public class IspisBrojeva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi prvi broj: ");
        int first = scanner.nextInt();
        System.out.println("Unesi drugi broj: ");
        int second = scanner.nextInt();
        System.out.println("Prvi broj je: " + first + " , a drugi broj je: " + second);
    }
}