package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    protected static String login = "example@exapmle.com";
    protected Map<Integer, String> answers = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root, 795, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //@todo сделать страницы, которых нет
    protected void logout(Window windowToHide) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("windowAuth.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Test - Authorization");
        stage.setResizable(false);
        if (stage.isShowing()) {
            windowToHide.hide();
        }
    }

    protected void goToMain(Window windowToHide) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("windowMain.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Test - Main window");
        stage.setResizable(false);
        stage.setMaximized(true);
        if (stage.isShowing()) {
            windowToHide.hide();
        }
    }

    protected void goToHelp(Window windowToHide) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("windowHelp.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Test - Help");
        stage.setResizable(false);
        stage.setMaximized(true);
        if (stage.isShowing()) {
            windowToHide.hide();
        }
    }

    protected void goToTests(Window windowToHide) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("windowTests.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Test - Tests");
        stage.setResizable(false);
        stage.setMaximized(true);
        if (stage.isShowing()) {
            windowToHide.hide();
        }
    }

    protected void goToQuestions(Window windowToHide) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("window1Question.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Test - Questions");
        stage.setResizable(false);
        stage.setMaximized(true);
        if (stage.isShowing()) {
            windowToHide.hide();
        }
    }

    protected void goToTestResults(Window windowToHide) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("windowTestResults.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Test - Test results");
        stage.setResizable(false);
        stage.setMaximized(true);
        if (stage.isShowing()) {
            windowToHide.hide();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
