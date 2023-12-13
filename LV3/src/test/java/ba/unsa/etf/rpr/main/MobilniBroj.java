package ba.unsa.etf.rpr.main;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj{

    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj){
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String print() {
        if (broj != null){
            return "0"+mobilnaMreza+"/"+broj;
        }else{
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, broj);
    }
}
