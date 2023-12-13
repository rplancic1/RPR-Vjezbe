import java.util.ArrayList;
import java.util.List;

class InformacijeONastavniku extends LicneInformacije {
    private String titula;
    private List<Ocjena> ocjene = new ArrayList<>();

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }

    @Override
    public String predstavi() {
        return super.predstavi() + ", " + titula;
    }
}