package ba.unsa.etf.rpr.lv10;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DrzavaController {
    public TextField naziv;
    public ChoiceBox<Grad> izborGrad;
    public Button btn1;
    public Button btn2;
    public Drzava drzava = null;
    GeografijaDAO dao = GeografijaDAO.getInstance();
    private ArrayList<Grad> gradovi2 = dao.gradovi();
    private ObservableList<Grad> gradovi = FXCollections.observableList(gradovi2);
    public DrzavaController(){}
    public DrzavaController(Drzava drzava, ArrayList<Grad> gradovi) {
        this.drzava = drzava;
        this.gradovi2 = gradovi;
    }

    @FXML

    public void initialize() {
        izborGrad.setItems(gradovi);
        izborGrad.getSelectionModel().selectFirst();
        naziv.getStyleClass().add("prazno");

        naziv.textProperty().addListener((obs, oldNaziv, newNaziv) -> {
            if (!newNaziv.trim().isEmpty()) {
                naziv.getStyleClass().removeAll("prazno");
                naziv.getStyleClass().add("popunjeno");
            } else {
                naziv.getStyleClass().removeAll("popunjeno");
                naziv.getStyleClass().add("prazno");
            }
        });
    }

    public void CancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btn2.getScene().getWindow();
        stage.close();
    }

    public void btn1Action(ActionEvent actionEvent) {
        if (!naziv.getText().trim().isEmpty() && drzava == null) {
            Drzava nova = new Drzava();
            drzava = nova;
            drzava.setNaziv(naziv.getText());
            drzava.setGlavniGrad(izborGrad.getSelectionModel().getSelectedItem());
            int id = dao.IDDrzave();
            drzava.setId(id);
        }

        if (!naziv.getText().trim().isEmpty()) {
            Stage stage = (Stage) btn1.getScene().getWindow();
            stage.close();
        }
    }

    public Drzava getDrzavu() {
        return drzava;
    }
}
