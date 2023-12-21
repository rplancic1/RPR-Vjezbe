package ba.unsa.etf.rpr.lv7;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    public PasswordField lozinka;
    public TextField korisnickoIme;
    public TextField email;
    public TextField prezime;
    public TextField ime;
    public ListView<Korisnik> lista;

    private KorisniciModel model=new KorisniciModel();
    private Korisnik trenutniKorisnik;
    public HelloController(){
        model.napuni();
    }
    public void onKrajClicked(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onDodajClick(ActionEvent actionEvent) {
        ime.setText("");
        prezime.setText("");
        email.setText("");
        korisnickoIme.setText("");
        lozinka.setText("");
    }
    @FXML
    public void initialize()
    {
        ime.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        email.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        lozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
        lista.setItems(model.getKorisnici());
        lista.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            model.setTrenutniKorisnik(newKorisnik);
            lista.refresh();
        });
    }

}