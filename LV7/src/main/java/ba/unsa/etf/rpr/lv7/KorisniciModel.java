package ba.unsa.etf.rpr.lv7;

import java.util.AbstractList;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici=FXCollections.observableArrayList();

    private SimpleObjectProperty<Korisnik> trenutniKorisnik=new SimpleObjectProperty<>();



    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public void napuni() {
        korisnici.add(new Korisnik("Ramiz","Plancic","rplancic1@gmail.com","rplancic1","ramiz123"));
        korisnici.add(new Korisnik("Mujo","Mujic","mujo@gmail.com","mujo1","mujo123"));
        trenutniKorisnik.set(korisnici.get(0));
    }

}
