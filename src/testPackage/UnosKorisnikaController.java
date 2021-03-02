package testPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class UnosKorisnikaController {
    @FXML
    public ChoiceBox<String> spol_ID;
    @FXML
    public TextField ime_ID;

    private ObservableList<String> lista = FXCollections.observableArrayList();
    private Korisnik korisnik;

    public void initialize() {
        ucitajChoice();
    }

    private void ucitajChoice() {
        lista.addAll("Muško", "Žensko");
        spol_ID.setItems(lista);
    }

    public void Ok_Action(ActionEvent actionEvent) {
        Korisnik k = new Korisnik(ime_ID.getText(), "lozinka", "170", "75", "60", "muški");
        if(spol_ID.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("UNESITE SPOL !");

            alert.showAndWait();
            return;
        }
        if (spol_ID.getValue().equals("Žensko")) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vjezbeZene.fxml"));
               // VjezbeZeneController vjezbeZeneController = new VjezbeZeneController(korisnik);
                root = loader.load();
                stage.setTitle("Vježbe za žene");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (spol_ID.getValue().equals("Muško")) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vjezbeMuskarci.fxml"));
                root = loader.load();
                stage.setTitle("Vježbe za muškarce");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void cancel_Action(ActionEvent actionEvent) {
        Stage stage = (Stage) ime_ID.getScene().getWindow();
        stage.close();
    }
}
