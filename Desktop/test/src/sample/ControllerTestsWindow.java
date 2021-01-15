package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.json.JSONArray;
import org.json.JSONObject;

public class ControllerTestsWindow extends ControllerAuthWindow {
    @FXML
    private Text testTitle;
    @FXML
    private Text testInfoSpec;
    @FXML
    private ImageView imageMain;
    @FXML
    private Text availableTests;
    @FXML
    private Text testInfo;
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
    private JFXButton buttonTests;
    @FXML
    private JFXButton buttonGoToTest;
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
        userEmail.setText(login);
        testInfoSpec.setUnderline(true);
//@todo разобраться с POST && DELETE запросами
        testInfoSpec.setOnMouseClicked(event -> {
            JSONArray jsonArray = new JSONArray(getDataFromAPI("test_all"));
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            //@todo make an alert
            Alert criteria = new Alert(Alert.AlertType.INFORMATION);
            criteria.setContentText(String.valueOf(jsonObject.get("description")));//@todo вставлять description с test_subject или description с tests
            criteria.setTitle(getLangSource("testInfo"));
            criteria.setHeaderText("");
            criteria.show();
            criteria.setResizable(false);
            criteria.setY(200.0);
        });

        buttonSignOut.setOnAction(event -> signOut());
        buttonGoToTest.setOnAction(event -> {
            goToQuestions();
            countOfRightAnswers = 0;
        });
        buttonHelp.setOnAction(event -> goToHelp());
        buttonTestResults.setOnAction(event -> goToTestResults());
        imageMain.setOnMouseClicked(event -> goToMain());
        buttonTests.setOnAction(event -> goToTests());
    }

    private void setScene() {
        goToTests();
    }

    private void setAllText() {
        JSONArray jsonArray = new JSONArray(getDataFromAPI("test_all"));//@todo переделать под те тесты, которые доступны пользователю
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        testTitle.setText(String.valueOf(jsonObject.get("name")).toUpperCase());

        menuLang.setText(getLangSource("menuLang"));
        langRus.setText(getLangSource("langRus"));
        langEng.setText(getLangSource("langEng"));
        menuTheme.setText(getLangSource("menuTheme"));
        themeLight.setText(getLangSource("themeLight"));
        themeDark.setText(getLangSource("themeDark"));
        buttonTestResults.setText(getLangSource("buttonTestResults"));
        buttonTests.setText(getLangSource("buttonTests"));
        buttonHelp.setText(getLangSource("buttonHelp"));
        buttonSignOut.setText(getLangSource("buttonSignOut"));

        buttonGoToTest.setText(getLangSource("buttonGoToTest"));
        availableTests.setText(getLangSource("availableTests"));
        testInfo.setText(getLangSource("testInfo"));
        testInfoSpec.setText(getLangSource("testInfo"));
    }

    private void refreshTests() {
        //@todo удалять и добавлять новые тесты
    }
}
