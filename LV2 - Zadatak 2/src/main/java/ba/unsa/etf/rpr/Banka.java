package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banka {
    private Long brojRacuna;

    private List<Korisnik> korisnik;

    private List<Uposlenik> uposlenik;

    public Banka() {
        this.korisnik = new ArrayList<Korisnik>();
        this.uposlenik = new ArrayList<Uposlenik>();
    }

    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        Korisnik k = new Korisnik(ime, prezime);
        this.korisnik.add(k);
        return k;
    }

    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik u = new Uposlenik(ime, prezime);
        this.uposlenik.add(u);
        return u;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik k){
        Racun r = null;
        for (int i = 0; i < this.korisnik.size(); i++){
            if (this.korisnik.get(i).equals(k)){
                Long brojRacuna = (new Random()).nextLong();
                r = new Racun(brojRacuna, this.korisnik.get(i));
                break;
            }
        }
        return r;
    }
}
