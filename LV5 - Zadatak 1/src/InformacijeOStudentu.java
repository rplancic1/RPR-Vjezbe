class InformacijeOStudentu extends LicneInformacije {
    private String godinaStudija;
    private String brojIndexa;

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
    public String predstavi() {
        return super.predstavi() + ", " + godinaStudija + " godina studija, br. indexa: " + brojIndexa;
    }
}