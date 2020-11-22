package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

public class ControllerHelpMailToDevelopersWindow extends ControllerAuthWindow {
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
    private MenuItem helpMailToDevelopersLangRus;
    @FXML
    private MenuItem helpMailToDevelopersLangEng;
    @FXML
    private MenuItem helpMailToDevelopersThemeLight;
    @FXML
    private MenuItem helpMailToDevelopersThemeDark;
    @FXML
    private Button LogoutButton;
    @FXML
    void initialize() {
        UserEmail.setText(login);
        LogoutButton.setOnAction(event -> logout());
        TestsButton.setOnAction(event -> goToTests());
        HelpButton.setOnAction(event -> goToHelp());
        TestResultsButton.setOnAction(event -> goToTestResults());
        MainButton.setOnAction(event -> goToMain());
    }
}

