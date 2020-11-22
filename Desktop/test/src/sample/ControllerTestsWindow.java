package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.text.Text;

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
        LogoutButton.setOnAction(event -> logout());
        TestsButton.setOnAction(event -> goToTests());
        HelpButton.setOnAction(event -> goToHelp());
        TestResultsButton.setOnAction(event -> goToTestResults());
        MainButton.setOnAction(event -> goToMain());
        TestButton.setOnAction(event -> goToQuestions());
    }
}
