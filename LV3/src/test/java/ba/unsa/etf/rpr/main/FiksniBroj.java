package ba.unsa.etf.rpr.main;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{

    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        if (null == grad) throw new BrojIzuzetak("Fiksni broj nije OK!");
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String print() {
        if (grad != null && broj != null){
            return grad.getBrojTelefona()+"/"+broj;
        }else {
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }
}
