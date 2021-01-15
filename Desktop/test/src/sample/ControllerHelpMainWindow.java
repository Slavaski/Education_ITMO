package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ControllerHelpMainWindow extends ControllerAuthWindow {
    /**
     * localization
     */
    @FXML
    private Text helpTitleAlert;
    @FXML
    private Text userEmail;
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
    /**
     * navigation
     * it's already finished, but need to check
     */
    @FXML
    private ImageView imageMain;
    @FXML
    private JFXButton buttonTests;
    @FXML
    private JFXButton buttonTestResults;
    @FXML
    private JFXButton buttonHelp;
    @FXML
    private Button buttonSignOut;
    @FXML
    private JFXButton buttonProgramOverview;
    @FXML
    private JFXButton buttonWriteToDevelopers;
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
        userEmail.setText(login);
        buttonSignOut.setOnAction(event -> signOut());
        buttonTests.setOnAction(event -> goToTests());
        buttonHelp.setOnAction(event -> goToHelp());
        buttonTestResults.setOnAction(event -> goToTestResults());
        imageMain.setOnMouseClicked(event -> goToMain());
        buttonProgramOverview.setOnAction(event -> goToProgramOverview());
        buttonWriteToDevelopers.setOnAction(event -> goToWriteToDevelopers());
    }

    private void setScene(){
        goToHelp();
    }

    private void setAllText(){
        menuLang.setText(getLangSource("menuLang"));
        langRus.setText(getLangSource("langRus"));
        langEng.setText(getLangSource("langEng"));
        menuTheme.setText(getLangSource("menuTheme"));
        themeLight.setText(getLangSource("themeLight"));
        themeDark.setText(getLangSource("themeDark"));
        buttonTests.setText(getLangSource("buttonTests"));
        buttonTestResults.setText(getLangSource("buttonTestResults"));
        buttonHelp.setText(getLangSource("buttonHelp"));
        buttonSignOut.setText(getLangSource("buttonSignOut"));
        helpTitleAlert.setText(getLangSource("helpTitleAlert"));
        buttonProgramOverview.setText(getLangSource("programOverview"));
        buttonWriteToDevelopers.setText(getLangSource("writeToDevelopers"));
    }
}
