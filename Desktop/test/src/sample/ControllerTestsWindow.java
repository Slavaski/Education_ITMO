package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControllerTestsWindow extends Main {

    @FXML
    public JFXButton TestsButton;

    @FXML
    public JFXButton HelpButton;

    @FXML
    public JFXButton TestResultsButton;

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
        LogoutButton.setOnAction(event -> logout(LogoutButton.getScene().getWindow()));

        TestsButton.setOnAction(event -> goToTests(TestsButton.getScene().getWindow()));

        HelpButton.setOnAction(event -> goToHelp(HelpButton.getScene().getWindow()));

        TestResultsButton.setOnAction(event -> goToTestResults(TestResultsButton.getScene().getWindow()));
    }
}
