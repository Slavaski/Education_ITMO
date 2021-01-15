package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerAuthWindow extends Main {
    /**
     * menu
     */
    @FXML
    private Menu menuLang;
    @FXML
    private Menu menuTheme;
    @FXML
    private MenuItem themeLight;
    @FXML
    private MenuItem themeDark;
    @FXML
    private MenuItem langRus;
    @FXML
    private MenuItem langEng;
    @FXML
    protected TextField Login;
    @FXML
    private PasswordField Password;
    @FXML
    private JFXButton buttonEnter;
    @FXML
    private JFXButton buttonHelp;

    @FXML
    void initialize() {
        setAllText();
        langRus.setOnAction(event -> {
            langNumber = 1;
            setAllText();
        });
        langEng.setOnAction(event -> {
            langNumber = 2;
            setAllText();
        });
        themeLight.setOnAction(event -> {
            themeNumber = 1;
            setScene();
        });
        themeDark.setOnAction(event -> {
            themeNumber = 2;
            setScene();
        });
        buttonEnter.setOnAction(event -> {
            login = Login.getText().trim();
            password = Password.getText().trim();
            if (getAndSetToken() == 200) goToMain();
            else {
                Alert badResponse = new Alert(Alert.AlertType.ERROR);
                badResponse.setContentText(getLangSource("errorContentAlertLoginPassword"));
                badResponse.setTitle(getLangSource("errorTitleAlertLoginPassword"));
                badResponse.setHeaderText("");
                badResponse.show();
                badResponse.setResizable(false);
                badResponse.setY(200.0);
            }
        });
        buttonHelp.setOnAction(event -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(getLangSource("helpContentAlert"));
            a.setTitle(getLangSource("helpTitleAlert"));
            a.setHeaderText("");
            a.show();
            a.setHeight(230.0);
            a.setY(200.0);
        });
    }

    private void setScene() {
        signOut();
    }

    private void setAllText() {
        menuLang.setText(getLangSource("menuLang"));
        langRus.setText(getLangSource("langRus"));
        langEng.setText(getLangSource("langEng"));
        menuTheme.setText(getLangSource("menuTheme"));
        themeLight.setText(getLangSource("themeLight"));
        themeDark.setText(getLangSource("themeDark"));
        buttonEnter.setText(getLangSource("buttonSingIn"));
        Login.setPromptText(getLangSource("login"));
        Password.setPromptText(getLangSource("password"));
    }
}
