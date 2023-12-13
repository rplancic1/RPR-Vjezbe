import java.util.ArrayList;
import java.util.List;

class InformacijeOStudentu extends LicneInformacije implements MozeOcijeniti {
    private String godinaStudija;
    private String brojIndexa;
    private List<Ocjena> ocjene = new ArrayList<>();

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    @Override
    public Ocjena ocijeni(int x) {
        Ocjena novaOcjena = new Ocjena(this, x);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }

    @Override
    public String predstavi() {
        return super.predstavi() + ", " + godinaStudija + " godina studija, br. indexa: " + brojIndexa;
    }
}