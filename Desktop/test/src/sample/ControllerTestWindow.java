package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerTestWindow extends ControllerAuthWindow {
    @FXML
    private ScrollPane scrollPane;

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
    private Text UserEmail;

    @FXML
    private JFXButton Answer;

    @FXML
    private JFXRadioButton RadioButton1;

    @FXML
    private JFXRadioButton RadioButton2;

    @FXML
    private JFXRadioButton RadioButton3;

    @FXML
    private JFXRadioButton RadioButton4;

    @FXML
    private JFXCheckBox CheckBoxButton1;

    @FXML
    private JFXCheckBox CheckBoxButton2;

    @FXML
    private JFXCheckBox CheckBoxButton3;

    @FXML
    private JFXCheckBox CheckBoxButton4;

    @FXML
    private JFXCheckBox CheckBoxButton5;

    @FXML
    void initialize() {
        UserEmail.setText(login);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        Answer.setText("Ответить");
        if (RadioButton1 != null && RadioButton2 != null && RadioButton3 != null && RadioButton4 != null) {
            RadioButton1.setSelected(true);
            Answer.setOnAction(event -> {
//            Добавление ответа, мб оптимизировать
                if (RadioButton1.isSelected())
                    answers.put(1, "1");//номер вопроса, ответ - если ответ множественный, то парсить строку, разрезая по запятой
                if (RadioButton2.isSelected())
                    answers.put(1, "2");
                if (RadioButton3.isSelected())
                    answers.put(1, "3");
                if (RadioButton4.isSelected())
                    answers.put(1, "4");
//@todo сохранять ответ и номер вопроса
                RadioButton1.setDisable(true);
                RadioButton2.setDisable(true);
                RadioButton3.setDisable(true);
                RadioButton4.setDisable(true);
                Answer.setVisible(false);
                System.out.println(answers.values());
                //либо оставить так, добавив сохранение выбранного параметра
                //@todo либо скрывать окно и не давать перейти на нее
                //либо вовсе скрыть переходы между страницами и осуществлять переход по нажатию на конпку "Ответить"
            });
        }
        if (CheckBoxButton1 != null && CheckBoxButton2 != null && CheckBoxButton3 != null && CheckBoxButton4 != null) {
            Answer.setOnAction(event -> {
                String myAnswer = "";
                boolean isAloneAnswer = true;
                if (CheckBoxButton1.isSelected()) {
                    myAnswer += "1";
                    isAloneAnswer = false;
                }
                if (CheckBoxButton2.isSelected()) {
                    if (!isAloneAnswer)
                        myAnswer += ",";
                    isAloneAnswer = false;
                    myAnswer += "2";
                }
                if (CheckBoxButton3.isSelected()) {
                    if (!isAloneAnswer)
                        myAnswer += ",";
                    isAloneAnswer = false;
                    myAnswer += "3";
                }
                if (CheckBoxButton4.isSelected()) {
                    if (!isAloneAnswer)
                        myAnswer += ",";
                    isAloneAnswer = false;
                    myAnswer += "4";
                }
                if (CheckBoxButton5.isSelected()) {
                    if (!isAloneAnswer)
                        myAnswer += ",";
                    myAnswer += "5";
                }
                answers.put(2, myAnswer);
                CheckBoxButton1.setDisable(true);
                CheckBoxButton2.setDisable(true);
                CheckBoxButton3.setDisable(true);
                CheckBoxButton4.setDisable(true);
                CheckBoxButton5.setDisable(true);
                Answer.setVisible(false);
                System.out.println(answers.values());
            });
        }
        if (prevQuestionButton != null) {
            prevQuestionButton.setOnAction(event -> {
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
                stage.show();
                stage.setResizable(false);
                stage.setMaximized(true);
                if (stage.isShowing()) {
                    prevQuestionButton.getScene().getWindow().hide();
                }
            });
        }
        if (nextQuestionButton != null) {
            nextQuestionButton.setOnAction(event -> {
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
                stage.show();
                stage.setResizable(false);
                stage.setMaximized(true);
                if (stage.isShowing()) {
                    nextQuestionButton.getScene().getWindow().hide();
                }
            });
        }
    }
}
