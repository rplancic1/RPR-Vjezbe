package ba.unsa.etf.rpr.main;

import java.util.*;

public class Imenik {

    private Map<String, TelefonskiBroj> brojevi;

    public Imenik() {
        this.brojevi = new HashMap<String, TelefonskiBroj>();
    }

    public Map<String, TelefonskiBroj> getBrojevi() {
        return brojevi;
    }

    public void setBrojevi(Map<String, TelefonskiBroj> brojevi) {
        this.brojevi = brojevi;
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        this.brojevi.put(ime, broj);
    }

    public String getBroj(String ime) {
        TelefonskiBroj broj = this.brojevi.get(ime);
        if (ime != null) {
            return broj.print();
        } else {
            return null;
        }
    }

    public String getIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getValue().print().equals(broj.print())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String naSlovo(char c) {
        StringBuilder builder = new StringBuilder();
        int br = 1;
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getKey().startsWith(String.valueOf(c))) {
                builder.append(br)
                        .append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().print())
                        .append(System.lineSeparator());
            }
            br++;
        }
        return builder.toString();
    }

    public Set<String> izGrada(Grad c) {
        Set<String> results = new TreeSet<String>();
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (jeIzGrada(entry.getValue(), c)) {
                results.add(entry.getKey());
            }
        }
        return results;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad c){
        Set<TelefonskiBroj> rezultati = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.print().compareTo(o2.print());
            }
        });

        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (jeIzGrada(entry.getValue(), c)) {
                rezultati.add(entry.getValue());
            }
        }

        return rezultati;
    }

    private boolean jeIzGrada(TelefonskiBroj broj, Grad c) {
        if (broj instanceof FiksniBroj) {
            return c.equals(((FiksniBroj) broj).getGrad());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int br = 1;
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            builder.append(br)
                    .append(". ")
                    .append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue().print())
                    .append(System.lineSeparator());
            br++;
        }
        return builder.toString();
    }
}