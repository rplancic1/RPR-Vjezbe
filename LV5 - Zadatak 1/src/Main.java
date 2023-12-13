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

        List<String> informacijeList = new ArrayList<>();
        informacijeList.add(student.predstavi());
        informacijeList.add(nastavnik.predstavi());
        informacijeList.add(predmet.predstavi());

        KolekcijaPoruka kolekcijaPoruka = new KolekcijaPoruka(informacijeList);
        List<String> poruke = kolekcijaPoruka.getPoruke();

        for (String poruka : poruke) {
            System.out.println(poruka);
        }
    }
}