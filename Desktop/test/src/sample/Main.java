package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import okhttp3.*;
import org.json.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Application {
    protected HashMap<Integer, String> answers = new HashMap<>();
    protected Scene activeScene;
    protected static Stage myStage;
    private static final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private final double heightScreen = screenSize.getHeight() - 40; //40 - height of taskbar
    protected final double widthScreen = screenSize.getWidth();

    protected static String login = "";
    protected static String password = "";
    protected static final String URL_API = "https://flaskprojecttest.herokuapp.com/api/";

    protected static int langNumber = 1;//@todo 1-russian, 2-english
    protected static int themeNumber = 1;//@todo 1-light, 2-dark
    protected static JSONObject token = null;

    protected static OkHttpClient client = new OkHttpClient();
    protected static Boolean isAdmin = false;

    //
    public static int countOfRightAnswers = 0;
    //

    //@todo удалить все комментарии или вынести в отдельный файл с пометкой, где было изначально
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("windowLightMain.fxml"));
        getAndSetToken();
        Parent root = FXMLLoader.load(getClass().getResource("windowLightWriteToDevelopers.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("windowDarkWriteToDevelopers.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("windowLightAuth.fxml"));
        activeScene = new Scene(root);
        primaryStage.setScene(activeScene);
        myStage = primaryStage;
        myStage.setTitle(getLangSource("titleAuth"));
        myStage.getIcons().add(new Image("logo_little_without_borders.jpg"));
        myStage.show();
        myStage.centerOnScreen();
    }

    /**
     * @return operation code from server
     */
    protected int getAndSetToken() {
        Request request = new Request.Builder().url(URL_API + "token")
//                .addHeader("Authorization", Credentials.basic(login, password)).get().build();
                .addHeader("Authorization", Credentials.basic("kko1l@mail.ru", "B0Zgz5JzL")).get().build();
        //kko1l@mail.ru  B0Zgz5JzL
        Call call = client.newCall(request);
        Response response;
        try {
            response = call.execute();
            if (response.code() == 200) {
                token = new JSONObject(response.body().string());
                return 200;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 401;
    }

    protected String deleteQueryToAPI(String lastPartOfURL, JSONObject content) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, content.toString());
        Request request = new Request.Builder().url(URL_API + lastPartOfURL)
                .addHeader("Authorization", Credentials.basic(token.getString("token"), ""))
                .delete(body).build();
        return createCallAndResponseAndExecute(request);
    }

    protected String postQueryToAPI(String lastPartOfURL, JSONObject content) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, content.toString());
        Request request = new Request.Builder().url(URL_API + lastPartOfURL)
                .addHeader("Authorization", Credentials.basic(token.getString("token"), ""))
                .post(body).build();
        return createCallAndResponseAndExecute(request);
    }

    protected String getDataFromAPI(String lastPartOfURL) {
        Request request = new Request.Builder().url(URL_API + lastPartOfURL)
                .addHeader("Authorization", Credentials.basic(token.getString("token"), "")).get().build();
        return createCallAndResponseAndExecute(request);
    }

    private String createCallAndResponseAndExecute(Request request) {
        Call call = client.newCall(request);
        Response response;
        try {
            response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void signOut() {
        login = "";
        password = "";
        token = null;

        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightAuth.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDarkAuth.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleAuth"), true);
    }

    protected void goToMain() {
        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightMain.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDarkMain.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleMain"), false);
    }

    protected void goToHelp() {
        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightHelp.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDarkHelp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleHelpMain"), false);
    }

    protected void goToProgramOverview() {
        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightProgramOverview.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDarkProgramOverview.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleProgramOverview"), false);
    }

    protected void goToWriteToDevelopers() {
        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightWriteToDevelopers.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDarkWriteToDevelopers.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleHelpWriteToDevelopers"), false);
    }

    protected void goToTests() {
        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightTests.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDarkTests.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleTests"), false);
    }

    protected void goToQuestions() {
        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLight1Question.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDark1Question.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleQuestions"), false);
    }

    protected void goToTestResults() {
        Parent root = null;
        try {
            if (themeNumber == 1) root = FXMLLoader.load(getClass().getResource("windowLightTestResults.fxml"));
            else root = FXMLLoader.load(getClass().getResource("windowDarkTestResults.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAndTuneScene(root, getLangSource("titleTestResults"), false);
    }

    protected void showAndTuneScene(Parent root, String title, Boolean isAuthNextScene) {
        if (isAuthNextScene) {
            activeScene = new Scene(root);
        } else {
            activeScene = new Scene(root, widthScreen, heightScreen);
        }
        myStage.setScene(activeScene);
        myStage.setTitle(title);
        if (isAuthNextScene) {
            myStage.centerOnScreen();
        } else {
            myStage.setMaximized(true);
            myStage.setMaximized(false);
            myStage.setMaximized(true);
        }
        myStage.show();
    }

    protected String getLangSource(String key) {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("C:\\Users\\slava\\OneDrive\\Desktop\\Education_ITMO\\Desktop\\test\\src\\sample\\ru_eng_sorted.txt")))) {
            while (s.hasNextLine()) {
                String buf = s.nextLine();
                String[] array = buf.split(";");
                if (array[0].equals(key)) {
                    return array[langNumber];
                }
            }
            System.out.println("BAD KEY: " + key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
