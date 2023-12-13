package ba.unsa.etf.rpr.main;

import java.util.Objects;

public class MedjunarodniBroj extends TelefonskiBroj{

    private String drzava;
    private String broj;

    public MedjunarodniBroj(String drzava, String broj){
        this.drzava = drzava;
        this.drzava = drzava;
    }

    @Override
    public String print() {
        if (drzava != null && broj != null){
            return drzava+broj;
        }else {
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(drzava, broj);
    }
}
