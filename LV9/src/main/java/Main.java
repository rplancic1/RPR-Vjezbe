import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        GeografijaDAO dao = GeografijaDAO.getInstance();
        Drzava drzava = new Drzava();
        Grad grad = new Grad();
        grad.setNaziv("Istanbul");
        grad.setBrojStanovnika(15460000);
        drzava.setNaziv("Turska");
        drzava.setGlavniGrad(grad);
        grad.setDrzava(drzava);
        dao.dodajDrzavu(drzava);
        glavniGrad();
    }

    public static String ispisiGradove() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        ArrayList<Grad> gradovi = geografijaDAO.gradovi();
        StringBuilder builder = new StringBuilder();
        for (Grad g : gradovi) {
            builder.append(g.getNaziv())
                    .append(" (")
                    .append(g.getDrzava().getNaziv())
                    .append(") - ")
                    .append(g.getBrojStanovnika())
                    .append("\n");
        }
        String rezultat = builder.toString();
        return rezultat;
    }

    public static void glavniGrad() {
        System.out.println("Unesite ime drzave: ");
        Scanner scanner = new Scanner(System.in);
        String drzava = scanner.nextLine();
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        Grad grad = geografijaDAO.glavniGrad(drzava);
        if(grad == null) System.out.println("Nepostojeća drzava");
        else System.out.println(String.format("Glavni grad drzave %s je %s", drzava, grad.getNaziv()));
    }
}