package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAuthWindow {

//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;

    @FXML
    private MenuItem loginLangRus;

    @FXML
    private MenuItem loginLangEng;

//    @FXML
//    private Image loginLogo;

    @FXML
    private TextField loginLogin;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private JFXButton loginEnterButton;

    @FXML
    private JFXButton loginHelpButton;

//    @FXML
//    private Image loginHelpImg;

    @FXML
    void initialize() {
//        assert loginLangRus != null : "fx:id=\"loginLangRus\" was not injected: check your FXML file '3.fxml'.";
//        assert loginLangEng != null : "fx:id=\"loginLangEng\" was not injected: check your FXML file '3.fxml'.";
//        assert loginLogo != null : "fx:id=\"loginLogo\" was not injected: check your FXML file '3.fxml'.";
//        assert loginLogin != null : "fx:id=\"loginLogin\" was not injected: check your FXML file '3.fxml'.";
//        assert loginPassword != null : "fx:id=\"loginPassword\" was not injected: check your FXML file '3.fxml'.";
//        assert loginEnterButton != null : "fx:id=\"loginEnterButton\" was not injected: check your FXML file '3.fxml'.";
//        assert loginHelpButton != null : "fx:id=\"loginHelpButton\" was not injected: check your FXML file '3.fxml'.";
//        assert loginHelpImg != null : "fx:id=\"loginHelpImg\" was not injected: check your FXML file '3.fxml'.";
        loginEnterButton.setOnAction(event -> {
            if (loginLogin.getText().length() == 5) {
                if (loginPassword.getText().length() == 5) {
                    System.out.println("Login: \"" + loginLogin.getText() + "\", password: \"" + loginPassword.getText() + "\".");
                    loginEnterButton.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("windowMain.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                } else {
                    Alert badPassword = new Alert(Alert.AlertType.ERROR);
                    badPassword.setContentText("Пароль должен состоять из 5 символов.");
                    badPassword.setTitle("Ошибка в пароле");
                    badPassword.setHeaderText("");
                    badPassword.show();
                    badPassword.setResizable(false);
                    badPassword.setY(200.0);
                }
            } else {
                Alert badLogin = new Alert(Alert.AlertType.ERROR);
                badLogin.setContentText("Логин должен состоять из 5 символов.");
                badLogin.setTitle("Ошибка в логине");
                badLogin.setHeaderText("");
                badLogin.show();
                badLogin.setResizable(false);
                badLogin.setY(200.0);
            }
        });
        loginHelpButton.setOnAction(event -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Если у Вас нет логина или пароля, обратитесь к Модератору. Функции изменения логина или пароля не предусмотрено, поэтому не теряйте и не забывайте личные данные для авторизации. После добавления Вас в систему для полноценного и правильного функционирования следует подождать 2 рабочих дня.");
            a.setTitle("Помощь");
            a.setHeaderText("");
            a.show();
            a.setHeight(200.0);
            a.setY(200.0);
        });
    }
}
