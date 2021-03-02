package testPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class VjezbeZeneController {
    public ComboBox<String> nogeCombo_ID;
    public ComboBox<String> rukeCombo_ID;
    private ObservableList<String> listaNoge = FXCollections.observableArrayList();
    private ObservableList<String> listaRuke = FXCollections.observableArrayList();
    private ObservableList<String> lista = FXCollections.observableArrayList();
    public ListView lista_ID;
    public Label label_ID;

    private Korisnik korisnik = new Korisnik();
    private Integer kg = Integer.valueOf(korisnik.getTezina()) - Integer.valueOf(korisnik.getCiljanaTezina());
    private Map<String, URI> mapaLinkova = new HashMap();
    private OdabraneVjezbe vjezbe = new OdabraneVjezbe();

/*    public VjezbeZeneController(Korisnik korisnik) {
        this.korisnik = korisnik;
    }*/

    public void initialize() {
        popuniMapu();
        comboMetoda();
        label_ID.setText("Dobro došli " + korisnik.getIme() + " u Fitness program!\n" +
                "Kako biste skinuli " + String.valueOf(kg) + "kg potrebno je da promijenite svoju ishranu.");
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void popuniMapu() {
        try {
            mapaLinkova.put("Vježbe za potkoljenice", new URI("https://www.vjezbaj.com/vjezbe/potkoljenice/"));
            mapaLinkova.put("Vježbe za natkoljenice", new URI("https://www.vjezbaj.com/vjezbe/natkoljenice/"));

            mapaLinkova.put("Trbušnjaci", new URI("https://www.youtube.com/embed/RjH1Hi1p2RU?autoplay=1&rel=0"));
            mapaLinkova.put("Bočni trbušnjaci", new URI("https://www.youtube.com/embed/VCn3lMwp1WY?autoplay=1&rel=0"));

            mapaLinkova.put("Biceps", new URI("https://www.vjezbaj.com/vjezbe/biceps/"));


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void comboMetoda() {
        listaRuke.addAll("Biceps", "Triceps", "Ramena", "Nadlaktica", "Podlaktica", "Čitava ruka");
        rukeCombo_ID.setItems(listaRuke);
        listaNoge.addAll("Potkoljenice", "Natkoljenice");
        nogeCombo_ID.setItems(listaNoge);
    }

    public void stomakAction(ActionEvent actionEvent) {
        lista.clear();
        lista.addAll("Trbušnjaci", "Bočni trbušnjaci", "Sjedeći trbušnjaci", "Podizanje nogu na dips spravi", "Potpuno podizanje nogu na vratilu", "Brisači");
        lista_ID.setItems(lista);
    }

    public void ledjaAction(ActionEvent actionEvent) {
        lista.clear();
        lista.addAll("Zgibovi", "Vučenje na lat spravi", "Sjedeće veslanje na sajli", "Dizanje na smith spravi",
                "SLijeganje ramenima na cross spravi", "Mrtvo dizanje");
        lista_ID.setItems(lista);
    }

    public void prsaAction(ActionEvent actionEvent) {
        lista.clear();
        lista.addAll("Potisak s ravne klupe", "Potisak s kose klupe", "Letenje na ravnoj klupi",
                "Hammer letenje", "Pullover šipkom", "Cross Over na sajlama");
        lista_ID.setItems(lista);
    }

    public void nogeAction(ActionEvent actionEvent) {
        if (nogeCombo_ID.getValue().equals("Potkoljenice")) {
            lista.clear();
            lista.addAll("Vježbe za potkoljenice");
            lista_ID.setItems(lista);
        } else if (nogeCombo_ID.getValue().equals("Natkoljenice")) {
            lista.clear();
            lista.addAll("Vježbe za natkoljenice");
            lista_ID.setItems(lista);
        }
    }

    public void rukeAction(ActionEvent actionEvent) {
    }

    public void nazadAction(ActionEvent actionEvent) {
        Stage stage = (Stage) nogeCombo_ID.getScene().getWindow();
        stage.close();
    }

    public void listaAkcija(MouseEvent mouseEvent) {
        String nazivVJezbe = (String) lista_ID.getSelectionModel().getSelectedItem();
        for (String s : mapaLinkova.keySet()) {
            if (s.equals(nazivVJezbe)) {
                Desktop desktop = java.awt.Desktop.getDesktop();
                try {
                    desktop.browse(mapaLinkova.get(s));
                } catch (IOException e) {
                    System.out.println("hm");
                    e.printStackTrace();
                }
            }
        }
        lista_ID.getStylesheets().add("/css/vjezbe.css");
    }
}
