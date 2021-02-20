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
        initButtons();
    }

    private void initButtons() {
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
            if (getAndSetToken() == 200) {
                isAdmin = Boolean.valueOf(get("role").trim());
                if (isAdmin) {
                    goToMain();
                } else {
                    goToMain();
                    //@todo сюда добавлять осуществление перехода на нужную страницу
                }
            } else {
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
        langRus.setText(getLangSource("langRus"));
        langEng.setText(getLangSource("langEng"));
        menuLang.setText(getLangSource("menuLang"));
        Login.setPromptText(getLangSource("login"));
        menuTheme.setText(getLangSource("menuTheme"));
        themeDark.setText(getLangSource("themeDark"));
        themeLight.setText(getLangSource("themeLight"));
        Password.setPromptText(getLangSource("password"));
        buttonEnter.setText(getLangSource("buttonSingIn"));
    }
}
