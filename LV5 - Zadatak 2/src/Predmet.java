import java.util.ArrayList;
import java.util.List;

class Predmet implements MozeOcijeniti {
    private String naziv;
    private String opis;
    private List<Ocjena> ocjene = new ArrayList<>();

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public Ocjena ocijeni(int x) {
        Ocjena novaOcjena = new Ocjena(null, x);  // Ocjena predmeta nema vezu s osobom, pa je postavljena na null
        ocjene.add(novaOcjena);
        return novaOcjena;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }

    public String predstavi() {
        return "Predmet: " + naziv + ", Opis: " + opis;
    }
}