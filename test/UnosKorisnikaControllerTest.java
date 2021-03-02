import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
@ExtendWith(ApplicationExtension.class)

public class UnosKorisnikaControllerTest {
    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/unosKorisnika.fxml"));
        primaryStage.setTitle("Unos korisnika");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        primaryStage.toFront();
    }
    @Test
    void unosKorisnika(FxRobot robot){
       //Button btnPrijava = robot.lookup("#cancel_ID").queryAs(Button.class);
        robot.clickOn("#ime_ID").write("Niko");

        robot.clickOn("#spol_ID");


        robot.clickOn("#cancel_ID");
    }
}
