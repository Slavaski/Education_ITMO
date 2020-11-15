package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import okhttp3.*;

import java.io.IOException;

public class ControllerAuthWindow extends Main {
    @FXML
    private MenuItem loginThemeDark;

    @FXML
    private MenuItem loginThemeLight;

    @FXML
    private MenuItem loginLangRus;

    @FXML
    private MenuItem loginLangEng;

    @FXML
    protected TextField Login;

    @FXML
    private PasswordField Password;

    @FXML
    private JFXButton EnterButton;

    @FXML
    private JFXButton HelpButton;

    @FXML
    void initialize() {
        EnterButton.setOnAction(event -> {
            if (Login.getText().contains("@")) {
                login = Login.getText().trim();

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("https://flaskprojecttest.herokuapp.com/api/token").addHeader("Authorization", Credentials.basic(Login.getText().trim(), Password.getText().trim())).get().build();
                Call call = client.newCall(request);
                Response response = null;
                try {
                    response = call.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response != null)
                    if (response.isSuccessful()) goToMain();
                    else {
                        Alert badResponse = new Alert(Alert.AlertType.ERROR);
                        badResponse.setContentText("Пара логин-пароль не подходит.");
                        badResponse.setTitle("Ошибка авторизации");
                        badResponse.setHeaderText("");
                        badResponse.show();
                        badResponse.setResizable(false);
                        badResponse.setY(200.0);
                    }
                else System.out.println("response is null");
            } else {
                Alert badLogin = new Alert(Alert.AlertType.ERROR);
                badLogin.setContentText("Логин должен содержать символ '@'.");
                badLogin.setTitle("Ошибка в логине");
                badLogin.setHeaderText("");
                badLogin.show();
                badLogin.setResizable(false);
                badLogin.setY(200.0);
            }
        });
        HelpButton.setOnAction(event -> {
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
