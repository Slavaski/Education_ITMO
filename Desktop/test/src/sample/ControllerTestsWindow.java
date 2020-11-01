package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerTestsWindow extends ControllerAuthWindow {

    @FXML
    private Button MainButton;

    @FXML
    private Text UserEmail;

    @FXML
    private JFXButton TestsButton;

    @FXML
    private JFXButton HelpButton;

    @FXML
    private JFXButton TestResultsButton;

    @FXML
    private JFXButton TestButton;

    @FXML
    private MenuItem testsLangRus;

    @FXML
    private MenuItem testsLangEng;

    @FXML
    private MenuItem testsThemeLight;

    @FXML
    private MenuItem testsThemeDark;

    @FXML
    private Button LogoutButton;

    @FXML
    void initialize() {
        UserEmail.setText(login);
        LogoutButton.setOnAction(event -> logout(LogoutButton.getScene().getWindow()));
        TestsButton.setOnAction(event -> goToTests(TestsButton.getScene().getWindow()));
        HelpButton.setOnAction(event -> goToHelp(HelpButton.getScene().getWindow()));
        TestResultsButton.setOnAction(event -> goToTestResults(TestResultsButton.getScene().getWindow()));
        MainButton.setOnAction(event -> goToMain(MainButton.getScene().getWindow()));
        TestButton.setOnAction(event -> goToQuestions(TestButton.getScene().getWindow()));
    }
}
