import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> imenaPrezimena = new ArrayList<>();
        imenaPrezimena.add("Ramiz A");
        imenaPrezimena.add("Ramiz Ab");
        imenaPrezimena.add("Ramiz Abc");

        KolekcijaImena kolekcijaImena = new KolekcijaImena(imenaPrezimena);
        System.out.println("Najduže ime: " + kolekcijaImena.getNajduzeIme());

        Pobjednik pobjednik = new Pobjednik(kolekcijaImena);
        System.out.println("Pobjednik: " + pobjednik.getIme() + " " + pobjednik.getPrezime());

        List<String> imena = new ArrayList<>();
        List<String> prezimena = new ArrayList<>();
        imena.add("Mujo");
        imena.add("Haso");
        prezimena.add("Mujic");
        prezimena.add("Hasic");

        KolekcijaImenaIPrezimena kolekcijaImenaIPrezimena = new KolekcijaImenaIPrezimena(imena, prezimena);
        System.out.println("Najduži par: " + kolekcijaImenaIPrezimena.getImeiPrezime(kolekcijaImenaIPrezimena.getIndexNajduzegPara()));
    }
}