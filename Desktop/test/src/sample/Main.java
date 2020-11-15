package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    protected static String login = "example@exapmle.com";
    protected Map<Integer, String> answers = new HashMap<>();
    protected static Stage myStage;
    protected Scene activeScene, nextScene;
    private final static Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    protected static double widthScreen = screenSize.getWidth();
    protected static double heightScreen = screenSize.getHeight();
    private String title;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
        activeScene = new Scene(root);
        primaryStage.setScene(activeScene);
        myStage = primaryStage;
        myStage.setTitle("Test - Authorization");
        myStage.show();
        myStage.centerOnScreen();
    }

    //@todo сделать страницы, которых нет
    protected void logout() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "Test - Authorization";
        showAndTuneScene(root, title);
    }

    protected void goToMain() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "Test - Main window";
        showAndTuneScene(root, title);
    }

    protected void goToHelp() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowHelp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "Test - Help";
        showAndTuneScene(root, title);
    }

    protected void goToTests() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowTests.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "Test - Tests";
        showAndTuneScene(root, title);
    }

    protected void goToQuestions() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("window1Question.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "Test - Questions";
        showAndTuneScene(root, title);
    }

    protected void goToTestResults() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowTestResults.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "Test - Test results";
        showAndTuneScene(root, title);
    }

    private void showAndTuneScene(Parent root, String title) {
        nextScene = new Scene(root, widthScreen, heightScreen);
        myStage.setScene(nextScene);
        myStage.setTitle(title);
        if (title.equals("Test - Authorization"))
            myStage.setMaximized(false);
        else
            myStage.setMaximized(true);
//        ломается при повторном выходе
        myStage.setResizable(false);
        if (!myStage.isMaximized())
            myStage.centerOnScreen();
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
