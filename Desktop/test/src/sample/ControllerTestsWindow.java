package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ControllerTestsWindow extends ControllerAuthWindow {
    /**
     * 1 test
     */
    @FXML
    private Rectangle rectWhite1;
    @FXML
    private Rectangle rectBlue1;
    @FXML
    private Text testTitle1;
    @FXML
    private Text testInfoSpec1;
    @FXML
    private Text testInfo1;
    @FXML
    private JFXButton buttonGoToTest1;
    /**
     * 2 test
     */
    @FXML
    private Rectangle rectWhite2;
    @FXML
    private Rectangle rectBlue2;
    @FXML
    private Text testTitle2;
    @FXML
    private Text testInfoSpec2;
    @FXML
    private Text testInfo2;
    @FXML
    private JFXButton buttonGoToTest2;
    /**
     * 3 test
     */
    @FXML
    private Rectangle rectWhite3;
    @FXML
    private Rectangle rectBlue3;
    @FXML
    private Text testTitle3;
    @FXML
    private Text testInfoSpec3;
    @FXML
    private Text testInfo3;
    @FXML
    private JFXButton buttonGoToTest3;
    /**
     * 4 test
     */
    @FXML
    private Rectangle rectWhite4;
    @FXML
    private Rectangle rectBlue4;
    @FXML
    private Text testTitle4;
    @FXML
    private Text testInfoSpec4;
    @FXML
    private Text testInfo4;
    @FXML
    private JFXButton buttonGoToTest4;
    /**
     * localization
     */
    @FXML
    private Text availableTests;
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

    private int countOfTests = 0;
    private JSONArray jsonArray = null;

    @FXML
    void initialize() {
        jsonArray = new JSONArray(getDataFromAPI("test_all"));
        initButtons();
        refreshTests();
        setAllText();
        //
        System.out.println(getDataFromAPIWithBody("id_test", "1"));
    }

    private JSONObject getAndSetJSONObjectSubject(JSONObject jsonObject) {
        int test_subject_id = jsonObject.getInt("test_subject_id");
        JSONArray jsonArraySubjects =  new JSONArray(getDataFromAPI("subject_all"));
        JSONObject result = null;
        for (int i = 0; i < jsonArraySubjects.length(); i++){
            if (test_subject_id == jsonArraySubjects.getJSONObject(i).getInt("id")) {
                result = jsonArraySubjects.getJSONObject(i);
            }
        }
        return result;
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

        testInfoSpec1.setUnderline(true);
        testInfoSpec1.setOnMouseClicked(event -> {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            Alert criteria = new Alert(Alert.AlertType.INFORMATION);
            criteria.setContentText(String.valueOf(
                    getAndSetJSONObjectSubject(jsonObject)
                            .get("name")));
            criteria.setTitle(getLangSource("testInfo"));
            criteria.setHeaderText("");
            criteria.show();
            criteria.setResizable(false);
            criteria.setY(200.0);
        });
        buttonGoToTest1.setOnAction(event -> {
//            добавить номер теста, для получения теста с серва @todo
            nameActiveTest = testTitle1.getText(); //second test
            int index;
            for (index = 0; index < jsonArray.length(); index++){
                if (jsonArray.getJSONObject(index).getString("name").equals(nameActiveTest)) {
                    index = jsonArray.getJSONObject(index).getInt("id");
                    break;
                }
            }
            numberActiveTest = index;
            goToQuestions();
        });

        testInfoSpec2.setUnderline(true);
        testInfoSpec2.setOnMouseClicked(event -> {
            JSONObject jsonObject = jsonArray.getJSONObject(1);

            Alert criteria = new Alert(Alert.AlertType.INFORMATION);
            criteria.setContentText(String.valueOf(
                    getAndSetJSONObjectSubject(jsonObject)
                            .get("name")));
            criteria.setTitle(getLangSource("testInfo"));
            criteria.setHeaderText("");
            criteria.show();
            criteria.setResizable(false);
            criteria.setY(200.0);
        });
        buttonGoToTest2.setOnAction(event -> {
            goToQuestions();
        });

        testInfoSpec3.setUnderline(true);
        testInfoSpec3.setOnMouseClicked(event -> {
            JSONObject jsonObject = jsonArray.getJSONObject(2);

            Alert criteria = new Alert(Alert.AlertType.INFORMATION);
            criteria.setContentText(String.valueOf(
                    getAndSetJSONObjectSubject(jsonObject)
                            .get("name")));
            criteria.setTitle(getLangSource("testInfo"));
            criteria.setHeaderText("");
            criteria.show();
            criteria.setResizable(false);
            criteria.setY(200.0);
        });
        buttonGoToTest3.setOnAction(event -> {
            goToQuestions();
        });

        testInfoSpec4.setUnderline(true);
        testInfoSpec4.setOnMouseClicked(event -> {
            JSONObject jsonObject = jsonArray.getJSONObject(3);//@todo переделать под те, которые доступны пользователю

            Alert criteria = new Alert(Alert.AlertType.INFORMATION);
            criteria.setContentText(String.valueOf(
                    getAndSetJSONObjectSubject(jsonObject)
                            .get("name")));
            criteria.setTitle(getLangSource("testInfo"));
            criteria.setHeaderText("");
            criteria.show();
            criteria.setResizable(false);
            criteria.setY(200.0);
        });
        buttonGoToTest4.setOnAction(event -> {
            goToQuestions();
        });

        buttonHelp.setOnAction(event -> goToHelp());
        buttonTests.setOnAction(event -> goToTests());
        buttonSignOut.setOnAction(event -> signOut());
        imageMain.setOnMouseClicked(event -> goToMain());
        buttonTestResults.setOnAction(event -> goToTestResults());
    }

    private void setScene() {
        goToTests();
    }

    private void setAllText() {
        userEmail.setText(login);
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
        availableTests.setText(getLangSource("availableTests"));

        for (int i = 0; i < countOfTests; i++) {
            switch (i) {
                case 0:
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    testTitle1.setText(String.valueOf(jsonObject1.get("name")).toUpperCase());
                    buttonGoToTest1.setText(getLangSource("buttonGoToTest"));
                    testInfo1.setText(getLangSource("testInfo"));
                    testInfoSpec1.setText(getLangSource("testInfo"));
                    break;
                case 1:
                    JSONObject jsonObject2 = jsonArray.getJSONObject(1);
                    testTitle2.setText(String.valueOf(jsonObject2.get("name")).toUpperCase());
                    buttonGoToTest2.setText(getLangSource("buttonGoToTest"));
                    testInfo2.setText(getLangSource("testInfo"));
                    testInfoSpec2.setText(getLangSource("testInfo"));
                    break;
                case 2:
                    JSONObject jsonObject3 = jsonArray.getJSONObject(2);
                    testTitle3.setText(String.valueOf(jsonObject3.get("name")).toUpperCase());
                    buttonGoToTest3.setText(getLangSource("buttonGoToTest"));
                    testInfo3.setText(getLangSource("testInfo"));
                    testInfoSpec3.setText(getLangSource("testInfo"));
                    break;
                case 3:
                    JSONObject jsonObject4 = jsonArray.getJSONObject(3);
                    testTitle4.setText(String.valueOf(jsonObject4.get("name")).toUpperCase());
                    buttonGoToTest4.setText(getLangSource("buttonGoToTest"));
                    testInfo4.setText(getLangSource("testInfo"));
                    testInfoSpec4.setText(getLangSource("testInfo"));
                    break;
                default:
                    break;
            }
        }
    }

    private void refreshTests() {
        countOfTests = jsonArray.length();

        for (int i = 1; i < 5 - countOfTests; i++) {
            switch (i) {
                case 1:
                    setDisableAndUnVisibleTest4();
                    break;
                case 2:
                    setDisableAndUnVisibleTest3();
                    break;
                case 3:
                    setDisableAndUnVisibleTest2();
                    break;
                case 4:
                    setDisableAndUnVisibleTest1();
                    break;
                default:
                    break;
            }
        }
    }

    private void setDisableAndUnVisibleTest4() {
        rectBlue4.setVisible(false);
        rectWhite4.setVisible(false);
        testTitle4.setVisible(false);
        testInfo4.setVisible(false);
        testInfoSpec4.setVisible(false);
        buttonGoToTest4.setVisible(false);

        rectBlue4.setDisable(true);
        rectWhite4.setDisable(true);
        testTitle4.setDisable(true);
        testInfo4.setDisable(true);
        testInfoSpec4.setDisable(true);
        buttonGoToTest4.setDisable(true);
    }

    private void setDisableAndUnVisibleTest3() {
        rectBlue3.setVisible(false);
        rectWhite3.setVisible(false);
        testTitle3.setVisible(false);
        testInfo3.setVisible(false);
        testInfoSpec3.setVisible(false);
        buttonGoToTest3.setVisible(false);

        rectBlue3.setDisable(true);
        rectWhite3.setDisable(true);
        testTitle3.setDisable(true);
        testInfo3.setDisable(true);
        testInfoSpec3.setDisable(true);
        buttonGoToTest3.setDisable(true);
    }

    private void setDisableAndUnVisibleTest2() {
        rectBlue2.setVisible(false);
        rectWhite2.setVisible(false);
        testTitle2.setVisible(false);
        testInfo2.setVisible(false);
        testInfoSpec2.setVisible(false);
        buttonGoToTest2.setVisible(false);

        rectBlue2.setDisable(true);
        rectWhite2.setDisable(true);
        testTitle2.setDisable(true);
        testInfo2.setDisable(true);
        testInfoSpec2.setDisable(true);
        buttonGoToTest2.setDisable(true);
    }

    private void setDisableAndUnVisibleTest1() {
        rectBlue1.setVisible(false);
        rectWhite1.setVisible(false);
        testTitle1.setVisible(false);
        testInfo1.setVisible(false);
        testInfoSpec1.setVisible(false);
        buttonGoToTest1.setVisible(false);

        rectBlue1.setDisable(true);
        rectWhite1.setDisable(true);
        testTitle1.setDisable(true);
        testInfo1.setDisable(true);
        testInfoSpec1.setDisable(true);
        buttonGoToTest1.setDisable(true);
    }
}
