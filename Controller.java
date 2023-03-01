import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public static boolean clicked2 = false;
    public static boolean clicked3 = false;
    public static boolean clicked100 = false;
    public static int multiply = 1;
    public static int clicks = 0;
    @FXML
    private Button clickButton;
    @FXML
    private Label clickLabel;
    @FXML
    private Button label2;
    @FXML
    private Button label3;
    @FXML
    private Button label100;

    @FXML
    private void click2(ActionEvent event) {
        if (!clicked2 && clicks > 1000) {
            clicked2 = true;
            clicks -= 1000;
            clickLabel.setText("Clicks: " + clicks);
            multiply = 2;
        }
    }

    @FXML
    private void click3(ActionEvent event) {
        if (!clicked3 && clicks > 3000) {
            clicked3 = true;
            clicks -= 3000;
            clickLabel.setText("Clicks: " + clicks);
            multiply = 3;
        }
    }

    @FXML
    private void click100(ActionEvent event) {
        if (!clicked100 && clicks > 10000) {
            clicked100 = true;
            clicks -= 10000;
            clickLabel.setText("Clicks: " + clicks);
            multiply = 100;
        }
    }

    @FXML
    private void click(ActionEvent event) {
        clicks += 1 * multiply;
        clickLabel.setText("Clicks: " + clicks);
    }

}
