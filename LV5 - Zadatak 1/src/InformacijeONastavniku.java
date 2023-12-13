class InformacijeONastavniku extends LicneInformacije {
    private String titula;

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    @Override
    public String predstavi() {
        return super.predstavi() + ", " + titula;
    }
}