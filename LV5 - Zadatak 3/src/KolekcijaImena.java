import java.util.List;

class KolekcijaImena {
    private List<String> imenaPrezimena;

    public KolekcijaImena(List<String> imenaPrezimena) {
        this.imenaPrezimena = imenaPrezimena;
    }

    public String getNajduzeIme() {
        String najduzeIme = "";
        for (String imePrezime : imenaPrezimena) {
            if (imePrezime.length() > najduzeIme.length()) {
                najduzeIme = imePrezime;
            }
        }
        return najduzeIme;
    }
}