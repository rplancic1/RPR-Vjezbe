import java.util.ArrayList;
import java.util.List;

class KolekcijaPoruka {
    private final List<String> poruke;

    public KolekcijaPoruka(List<String> informacijeList) {
        this.poruke = new ArrayList<>(informacijeList);
    }

    public List<String> getPoruke() {
        return poruke;
    }
}