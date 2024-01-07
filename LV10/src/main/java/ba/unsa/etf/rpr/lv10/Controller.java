package ba.unsa.etf.rpr.lv10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller {
    public Button btnDodajGrad;
    public Button btnDodajDrzavu;
    public Button btnIzmijeniGrad;
    public Button btnObrisiGrad;
    public TableView<Grad> tableViewGradovi;
    public TableColumn<Integer, Grad> colGradId;
    public TableColumn<String, Grad> colGradNaziv;
    public TableColumn<Integer, Grad> colGradStanovnika;
    public TableColumn<Drzava, Grad> colGradDrzava;

    GeografijaDAO dao = GeografijaDAO.getInstance();
    private ObservableList<Grad> gradovi;
    private ArrayList<Grad> gradovi2 = new ArrayList<>();

    public Controller() {

    }

    @FXML
    public void initialize() {
        gradovi2.addAll(dao.gradovi());
        gradovi = FXCollections.observableList(gradovi2);
        colGradId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("brojStanovnika"));
        colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));
        tableViewGradovi.setItems(gradovi);
    }

    public void DodajDrzavuAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("drzava.fxml"));
        Parent root = loader.load();

        DrzavaController kontroler = loader.getController();

        Stage novaFormaStage = new Stage();
        novaFormaStage.setTitle("Drzava");
        novaFormaStage.setScene(new Scene(root));
        novaFormaStage.setResizable(false);
        novaFormaStage.show();

        novaFormaStage.setOnHiding(lambda -> {
            Drzava drzava = kontroler.getDrzavu();
            if (drzava != null) {
                dao.dodajDrzavu(drzava);
            }
        });
    }

    public void IzmijeniGradAction(ActionEvent actionEvent) throws IOException {
        if (tableViewGradovi.getSelectionModel().getSelectedItem() != null) {
            Grad grad = tableViewGradovi.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("grad.fxml"));
            Parent root = loader.load();

            GradController kontroler = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Grad");
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            kontroler.fieldNaziv.setText(grad.getNaziv());
            kontroler.fieldBrojStanovnika.setText(String.valueOf(grad.getBrojStanovnika()));
            kontroler.izborDrzava.getSelectionModel().select(grad.getDrzava());

            stage.show();

            stage.setOnHiding(lambda -> {
                Grad grad2 = kontroler.getGrad();
                if (grad2 != null) {
                    dao.izmijeniGrad(grad2);
                    tableViewGradovi.refresh();
                }
            });
        }
    }

    public void dodajGradAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("grad.fxml"));
        Parent root = loader.load();
        GradController kontroler = loader.getController();
        Stage novaFormaStage = new Stage();
        novaFormaStage.setTitle("Grad");
        novaFormaStage.setScene(new Scene(root));
        novaFormaStage.setResizable(false);
        novaFormaStage.show();

        novaFormaStage.setOnHiding(lambda -> {
            Grad grad = kontroler.getGrad();
            if (grad != null) {
                dao.dodajGrad(grad);
                tableViewGradovi.getItems().add(grad);
                tableViewGradovi.refresh();
            }
        });
    }


    public void ObrisiGradAction(ActionEvent actionEvent) {
        Grad grad = tableViewGradovi.getSelectionModel().getSelectedItem();

        if (grad != null) {
            dao = GeografijaDAO.getInstance();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Da li zelite obrisati selektovani grad?");
            alert.setHeaderText("");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                dao.obrisiGrad(grad.getId());
                tableViewGradovi.getItems().remove(grad);
                tableViewGradovi.refresh();
            }
        }
    }
}