package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControllerTestResultsWindow extends ControllerAuthWindow {
    /**
     * for localization
     */
    @FXML
    private Text countOfRightAnswers;
    @FXML
    private Text correctAnswers;
    @FXML
    private Text passedDate;
    @FXML
    private Text evaluationCriteria;
    @FXML
    private Text testTitle;
    @FXML
    private Text textTestResults;
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

        buttonSignOut.setOnAction(event -> signOut());
        buttonTests.setOnAction(event -> goToTests());
        buttonHelp.setOnAction(event -> goToHelp());
        buttonTestResults.setOnAction(event -> goToTestResults());
        imageMain.setOnMouseClicked(event -> goToMain());
        evaluationCriteria.setOnMouseClicked(event -> {
            JSONArray jsonArray = new JSONArray(getDataFromAPI("test_all"));
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            Alert criteria = new Alert(Alert.AlertType.INFORMATION);
            criteria.setContentText(String.valueOf(jsonObject.get("description")));
            criteria.setTitle(getLangSource("evaluationCriteria"));
            criteria.setHeaderText("");
            criteria.show();
            criteria.setResizable(false);
            criteria.setY(200.0);
        });
    }

    private void setScene(){
        goToTestResults();
    }

    private void setAllText(){
        JSONArray jsonArray = new JSONArray(getDataFromAPI("test_all"));
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();

        userEmail.setText(login);
        evaluationCriteria.setUnderline(true);
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
        textTestResults.setText(getLangSource("textTestResults"));
        evaluationCriteria.setText(getLangSource("evaluationCriteria"));
        passedDate.setText(getLangSource("passedDate") + dtf.format(now));
        testTitle.setText(String.valueOf(jsonObject.get("name")).toUpperCase());
        countOfRightAnswers.setText("" + "/2");//@todo вставлять result с test_result с серва

    }
}

