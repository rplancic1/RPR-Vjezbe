public class Grad {
    private int id;
    private String naziv;
    private int brojStanovnika;
    private Drzava drzava;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    public Grad() {

    }

    public Grad(int id, String naziv, int brojStanovnika, Drzava drzava) {
        this.id = id;
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.drzava = drzava;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!( o instanceof Grad )) return false;

        Grad grad = (Grad) o;

        if (getId() != grad.getId()) return false;
        if (getBrojStanovnika() != grad.getBrojStanovnika()) return false;
        if (getNaziv() != null ? !getNaziv().equals(grad.getNaziv()) : grad.getNaziv() != null) return false;
        return getDrzava() != null ? getDrzava().equals(grad.getDrzava()) : grad.getDrzava() == null;
    }

    @Override
    public int hashCode() {
        int rezultat = getId();
        rezultat = 31 * rezultat + ( getNaziv() != null ? getNaziv().hashCode() : 0 );
        rezultat = 31 * rezultat + getBrojStanovnika();
        rezultat = 31 * rezultat + ( getDrzava() != null ? getDrzava().hashCode() : 0 );
        return rezultat;
    }

}