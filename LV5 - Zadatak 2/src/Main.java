import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InformacijeOStudentu student = new InformacijeOStudentu();
        student.setIme("Ramiz");
        student.setPrezime("Plancic");
        student.setGodinaStudija("2");
        student.setBrojIndexa("19107");

        InformacijeONastavniku nastavnik = new InformacijeONastavniku();
        nastavnik.setIme("Prof");
        nastavnik.setPrezime("Profesor");
        nastavnik.setTitula("Dr.");

        Predmet predmet = new Predmet();
        predmet.setNaziv("Programiranje");
        predmet.setOpis("Učenje programiranja u Javi.");

        predmet.ocijeni(8);

        Ocjena ocjenaNastavnika = student.ocijeni(9);
        nastavnik.getOcjene().add(ocjenaNastavnika);

        System.out.println("Ocjene studenta: " + student.getOcjene());
        System.out.println("Ocjene nastavnika: " + nastavnik.getOcjene());
        System.out.println("Ocjene predmeta: " + predmet.getOcjene());
    }
}