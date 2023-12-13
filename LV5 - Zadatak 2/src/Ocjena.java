class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;

    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        setOcjena(ocjena);
    }

    public LicneInformacije getOsoba() {
        return osoba;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        if (ocjena > 0 && ocjena <= 10) {
            this.ocjena = ocjena;
        } else {
            System.out.println("Ocjena mora biti između 1 i 10.");
        }
    }
}