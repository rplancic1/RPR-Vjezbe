class Predmet {
    private String naziv;
    private String opis;

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

    public String predstavi() {
        return "Predmet: " + naziv + ", Opis: " + opis;
    }
}