package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerMainWindow extends ControllerAuthWindow {

    @FXML
    private Button MainButton;

    @FXML
    private MenuItem mainThemeLight;

    @FXML
    private MenuItem mainThemeDark;

    @FXML
    private Text mainHeader;

    @FXML
    private Text mainMain;

    @FXML
    private MenuItem mainLangRus;

    @FXML
    private MenuItem mainLangEng;

    @FXML
    private JFXButton TestsButton;

    @FXML
    private JFXButton TestResultsButton;

    @FXML
    private JFXButton HelpButton;

    @FXML
    private Text UserEmail;

    @FXML
    private Button LogoutButton;

    @FXML
    void initialize() {
        UserEmail.setText(login);
        mainMain.setLineSpacing(1.0);
        mainMain.setWrappingWidth(1000);
        mainHeader.setText("Приветствуем!");
        mainMain.setText("   В данном приложении Вы можете пройти тестирования - раздел \"Прохождение тестов\", " +
                "посмотреть свои результаты - раздел \"Результаты тестов\" и послать письмо разработчику.\n" +
                "   Если в ходе работы были обнаружены проблемы, баги или присутствуют " +
                "жалобы/пожелания по работе программы, перейдите в раздел \"Помощь\"->\"Письмо разработчику\", подробно изложите ситуацию и " +
                "отправьте свое сообщение. Каждое сообщение будет рассмотрено.\n   Приятного и плодотворного пользования!");
        LogoutButton.setOnAction(event -> logout());
        TestsButton.setOnAction(event -> goToTests());
        HelpButton.setOnAction(event -> goToHelp());
        TestResultsButton.setOnAction(event -> goToTestResults());
        MainButton.setOnAction(event -> goToMain());
    }
}
