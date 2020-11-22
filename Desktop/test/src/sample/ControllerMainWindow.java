package sample;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class ControllerMainWindow extends ControllerAuthWindow {

    @FXML
    private MenuItem mainThemeLight;

    @FXML
    private MenuItem mainThemeDark;

    @FXML
    private MenuItem mainLangRus;

    @FXML
    private MenuItem mainLangEng;

    @FXML
    private Button MainButton;

    @FXML
    private Text mainHeader;

    @FXML
    private Text mainMain;

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
        mainHeader.setText(getLangSource("main_header", position));
        mainMain.setText(getLangSource("main_main", position));
        LogoutButton.setOnAction(event -> logout());
        TestsButton.setOnAction(event -> goToTests());
        HelpButton.setOnAction(event -> goToHelp());
        TestResultsButton.setOnAction(event -> goToTestResults());
        MainButton.setOnAction(event -> goToMain());
    }
}
