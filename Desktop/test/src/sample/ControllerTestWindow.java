package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerTestWindow {

    @FXML
    private MenuItem questionLangRus;

    @FXML
    private MenuItem questionLangEng;

    @FXML
    private MenuItem questionThemeLight;

    @FXML
    private MenuItem questionThemeDark;

    @FXML
    private Text question;

    @FXML
    private Text testName;

    @FXML
    private JFXButton prevQuestionButton;

    @FXML
    private JFXButton nextQuestionButton;

    @FXML
    void initialize() {
        prevQuestionButton.setOnAction(event -> {
            prevQuestionButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("window1Question.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        nextQuestionButton.setOnAction(event -> {
            nextQuestionButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("window2Question.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}
