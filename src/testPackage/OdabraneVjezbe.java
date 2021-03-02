package testPackage;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class OdabraneVjezbe {
    private ObservableList<String> vjezbe = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutnaVjezba = new SimpleObjectProperty<>();
    private Connection conn;
    private PreparedStatement dajKorisnikaUpit, izmijeniKorisnikaUpit, imeIzmjenaUpit;

    public ObservableList<String> getVjezbe() {
        return vjezbe;
    }

    public void setVjezbu(String vjezba) {
        vjezbe.setAll(vjezba);
    }

    public OdabraneVjezbe() {

        File file = new File("baza.db");

        if (!file.exists()) {

            try {
                Class.forName("SQLite.JDBCDriver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            vratiNaDefault();
        }

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
            // dajKorisnikaUpit = conn.prepareStatement("SELECT * FROM Vjezbe");
//            izmijeniKorisnikaUpit = conn.prepareStatement("UPDATE Vjezbe SET Naziv_Vjezbe=? WHERE NazivTijela=?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void vratiNaDefault() {
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Vjezbe");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if (sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
