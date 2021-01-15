package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerTestWindow extends ControllerAuthWindow {
    @FXML
    private ScrollPane scrollPane;
    /**
     * questions
     */
    @FXML
    private Text question;
    @FXML
    private Text testName;
    @FXML
    private Text  userEmail;
    /**
     * for answer
     */
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
        userEmail.setText(login);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        Answer.setText("Ответить");
        if (RadioButton1 != null && RadioButton2 != null && RadioButton3 != null && RadioButton4 != null) {
            RadioButton1.setSelected(true);
            Answer.setOnAction(event -> {
//            Добавление ответа, мб оптимизировать
//                if (RadioButton1.isSelected()) {
//                    answers.put(1, "1");//номер вопроса, ответ (если ответ множественный, то парсить строку, разрезая по запятой)
//                    answersSet.add("1");
//                }
//                if (RadioButton2.isSelected()) {
//                    answers.put(1, "2");
//                    answersSet.add("2");
//                }
//                if (RadioButton3.isSelected()) {
//                    answers.put(1, "3");
//                    answersSet.add("3");
//                }
                if (RadioButton4.isSelected()) {
//                    answers.put(1, "4");
//                    answersSet.add("4");
                    countOfRightAnswers += 1;
                }
                //
                Parent root = null;
                try {
                    if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightTestSecondPage.fxml"));
                    else root = FXMLLoader.load(getClass().getResource("windowDarkTestSecondPage.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                showAndTuneScene(root, getLangSource("titleTestResults"), false);
                //
//@todo сохранять ответ и номер вопроса
//                RadioButton1.setDisable(true);
//                RadioButton2.setDisable(true);
//                RadioButton3.setDisable(true);
//                RadioButton4.setDisable(true);
//                Answer.setVisible(false);
//                System.out.println(answers.values());
                //либо оставить так, добавив сохранение выбранного параметра
                //@todo либо скрывать окно и не давать перейти на нее
                //либо вовсе скрыть переходы между страницами и осуществлять переход по нажатию на конпку "Ответить"
            });
        }
        if (CheckBoxButton1 != null && CheckBoxButton2 != null && CheckBoxButton3 != null && CheckBoxButton4 != null) {
            Answer.setOnAction(event -> {
//                String myAnswer = "";
//                boolean isAloneAnswer = true;
//                if (CheckBoxButton1.isSelected()) {
//                    myAnswer += "1";
//                    isAloneAnswer = false;
//                }
//                if (CheckBoxButton2.isSelected()) {
//                    if (!isAloneAnswer)
//                        myAnswer += ",";
//                    isAloneAnswer = false;
//                    myAnswer += "2";
//                }
//                if (CheckBoxButton3.isSelected()) {
//                    if (!isAloneAnswer)
//                        myAnswer += ",";
//                    isAloneAnswer = false;
//                    myAnswer += "3";
//                }
//                if (CheckBoxButton4.isSelected()) {
//                    if (!isAloneAnswer)
//                        myAnswer += ",";
//                    isAloneAnswer = false;
//                    myAnswer += "4";
//                }
//                if (CheckBoxButton5.isSelected()) {
//                    if (!isAloneAnswer)
//                        myAnswer += ",";
//                    myAnswer += "5";
//                }
//                answers.put(2, myAnswer);
//                CheckBoxButton1.setDisable(true);
//                CheckBoxButton2.setDisable(true);
//                CheckBoxButton3.setDisable(true);
//                CheckBoxButton4.setDisable(true);
//                CheckBoxButton5.setDisable(true);
//                Answer.setVisible(false);
//                System.out.println(answers.values());
                if (CheckBoxButton1.isSelected() && CheckBoxButton2.isSelected() && !CheckBoxButton3.isSelected() && CheckBoxButton4.isSelected() && !CheckBoxButton5.isSelected()) {
                    countOfRightAnswers += 1;
                }
                //
                Parent root = null;
                try {
                    if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightTestResults.fxml"));
                    else root = FXMLLoader.load(getClass().getResource("windowDarkTestResults.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                showAndTuneScene(root, getLangSource("titleTestResults"), false);
                //
            });
        }
    }

    void updateQuestion() {
        //todo получать question с questions, types с questions(уточнить, что это), name с question_type
    }

    void updateAnswers() {
        //@todo получать answer  с answers
    }

    //@todo определиться с форматом сбора, отображения и отправки ответов в users_answers
    //отправлять question_answer_id, users
}
