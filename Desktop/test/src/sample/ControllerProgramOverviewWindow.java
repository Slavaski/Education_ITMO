package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ControllerProgramOverviewWindow extends ControllerAuthWindow {
    @FXML
    private Text titleProgramOverview;
    @FXML
    private Text overview;
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
        buttonHelp.setOnAction(event -> goToHelp());
        buttonSignOut.setOnAction(event -> signOut());
        buttonTests.setOnAction(event -> goToTests());
        imageMain.setOnMouseClicked(event -> goToMain());
        buttonTestResults.setOnAction(event -> goToTestResults());
    }

    private void setScene() {
        goToProgramOverview();
    }

    private void setAllText() {
        userEmail.setText(login);
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
        titleProgramOverview.setText(getLangSource("programOverview"));
        overview.setText("\n" + getLangSource("overview"));
    }
}

