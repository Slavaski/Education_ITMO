package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

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
    private final float widthOnCornerToAuth = 405;
    private final float heightOnCornerToAuth = 390;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
        activeScene = new Scene(root);
        primaryStage.setScene(activeScene);
        myStage = primaryStage;
        myStage.setTitle("Test - Authorization");
        myStage.show();
    }

    //@todo сделать страницы, которых нет
    protected void logout() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextScene = new Scene(root);
        myStage.setScene(nextScene);
        myStage.setX(widthScreen / 2 - widthOnCornerToAuth);
        myStage.setY(heightScreen / 2 - heightOnCornerToAuth);
        myStage.show();
        myStage.setTitle("Test - Authorization");
        myStage.setResizable(false);
    }

    protected void goToMain() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextScene = new Scene(root, widthScreen, heightScreen);
        myStage.setScene(nextScene);
        myStage.setX(-8);
        myStage.setY(-8);
        myStage.show();
        myStage.setTitle("Test - Main window");
        myStage.setMaximized(true);
        myStage.setResizable(false);
    }

    protected void goToHelp() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowHelp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextScene = new Scene(root, widthScreen, heightScreen);
        myStage.setScene(nextScene);
        myStage.show();
        myStage.setTitle("Test - Help");
        myStage.setMaximized(true);
        myStage.setResizable(false);
    }

    protected void goToTests() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowTests.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextScene = new Scene(root, widthScreen, heightScreen);
        myStage.setScene(nextScene);
        myStage.show();
        myStage.setTitle("Test - Tests");
        myStage.setMaximized(true);
        myStage.setResizable(false);
    }

    protected void goToQuestions() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("window1Question.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextScene = new Scene(root, widthScreen, heightScreen);
        myStage.setScene(nextScene);
        myStage.show();
        myStage.setTitle("Test - Questions");
        myStage.setMaximized(true);
        myStage.setResizable(false);
    }

    protected void goToTestResults() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowTestResults.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextScene = new Scene(root, widthScreen, heightScreen);
        myStage.setScene(nextScene);
        myStage.show();
        myStage.setTitle("Test - Test results");
        myStage.setMaximized(true);
        myStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
