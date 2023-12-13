package ba.unsa.etf.rpr.main;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Imenik imenik = new Imenik();

    public static void main(String[] args) {
        fillData();
        while(true){
            System.out.println("Unesi komandu [dodaj, getBroj, getIme, naSlovo, izGrada, izGradaBrojevi, imenik, exit]");
            String komanda = scanner.nextLine();
            switch (komanda){
                case "dodaj":
                    dodajBroj();
                    break;
                case "getBroj":
                    getBroj();
                    break;
                case "getIme":
                    getIme();
                    break;
                case "naSlovo":
                    naSlovo();
                    break;
                case "izGrada":
                    izGrada();
                    break;
                case "izGradaBrojevi":
                    izGradaBrojevi();
                    break;
                case "imenik":
                    printImenik();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pogresna komanda.");
            }
        }
    }
    private static void izGradaBrojevi(){
        System.out.println("Unesi grad: ");
        String grad = scanner.nextLine();
        try{
            Grad c = Grad.valueOf(grad);
            Set<TelefonskiBroj> odgovor = imenik.izGradaBrojevi(c);
            for (TelefonskiBroj broj : odgovor){
                System.out.println(broj.print());
            }
        }catch (Exception e){
            System.out.println("Pogresan grad");
            return;
        }
    }
    private static void izGrada(){
        System.out.println("Unesi grad: ");
        String grad = scanner.nextLine();
        try{
            Grad c = Grad.valueOf(grad);
            Set<String> odgovor = imenik.izGrada(c);
            System.out.println(odgovor);
        }catch (Exception e){
            System.out.println("Pogresan grad");
            return;
        }
    }
    private static void naSlovo(){
        System.out.println("Unesi prvo slovo imena: ");
        String c = scanner.nextLine();
        String odgovor = imenik.naSlovo(c.toCharArray()[0]);
        System.out.println(odgovor);
    }
    private static void getIme() {
        TelefonskiBroj broj = unesiTelefonskiBroj();
        String ime = imenik.getIme(broj);
        if(ime == null){
            System.out.println("Nema u imeniku!");
        }else{
            System.out.println("Vlasnik broja "+ broj.print()+" je "+ ime);
        }
    }
    private static TelefonskiBroj unesiTelefonskiBroj(){
        System.out.println("Unesi tip broja[fiksni, mobilni, medjunarodni]:");
        String tip = scanner.nextLine();
        switch (tip){
            case "fiksni":
                System.out.println("Unesi fiksni: ");
                String fiksni = scanner.nextLine();
                System.out.println("Unesi broj: ");
                String broj = scanner.nextLine();
                return new FiksniBroj(Grad.izBrojTelefona(fiksni), broj);
            case "mobilni":
                System.out.println("Unesi mrezu: ");
                int mreza = scanner.nextInt();
                String mobilniBroj = scanner.nextLine();
                System.out.println("Unesi broj: ");
                mobilniBroj = scanner.nextLine();
                return new MobilniBroj(mreza, mobilniBroj);
            case "medjunarodni":
                System.out.println("Unesi kod drzave [+387]: ");
                String kod = scanner.nextLine();
                System.out.println("Unesi broj: ");
                String intBroj = scanner.nextLine();
                return new MedjunarodniBroj(kod, intBroj);
        }
        return null;
    }
    private static void dodajBroj(){
        System.out.println("Unesi ime: ");
        String ime = scanner.nextLine();
        TelefonskiBroj broj = unesiTelefonskiBroj();
        imenik.dodaj(ime, broj);
    }

    private static void printImenik(){
        System.out.println(imenik.toString());
    }

    private static void getBroj(){
        System.out.println("Unesi ime: ");
        String ime = scanner.nextLine();
        String rezultat = imenik.getBroj(ime);
        System.out.println(rezultat == null ? "Nema u imeniku!" : rezultat);
    }

    private static void fillData(){
        imenik.dodaj("Ramiz", new FiksniBroj(Grad.SARAJEVO, "212-802"));
        imenik.dodaj("Haso", new FiksniBroj(Grad.ZENICA, "235-812"));
        imenik.dodaj("Mujo", new MobilniBroj(62, "654-225"));
        imenik.dodaj("Edward", new MedjunarodniBroj("+34", "2164389410"));
    }
}
