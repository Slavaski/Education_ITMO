package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Application {
    protected HashMap<Integer, String> answers = new HashMap<>();
    protected Scene activeScene, nextScene;
    private static Stage myStage;
    private final static Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private final double widthScreen = screenSize.getWidth();
    private final double heightScreen = screenSize.getHeight() - 40;
    protected static String login = "example@exapmle.com";
    private String title;
    protected int position = 1;//@todo 1-russian, 2-english

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
        activeScene = new Scene(root);
        primaryStage.setScene(activeScene);
        myStage = primaryStage;
        myStage.setTitle("AVEVA Test - Authorization");
        myStage.getIcons().add(new Image("logo.png"));//@todo сделать лого и название
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
        title = "AVEVA Test - Authorization";
        showAndTuneScene(root, title, true);
    }

    protected void goToMain() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "AVEVA Test - Main window";
        showAndTuneScene(root, title, false);
    }

    protected void goToHelp() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowHelpMain.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "AVEVA Test - Help";
        showAndTuneScene(root, title, false);
    }

    protected void goToHelpDescription() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowHelpDescription.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "AVEVA Test - Help - Description and work with the program";
        showAndTuneScene(root, title, false);
    }

    protected void goToHelpMailToDevelopers() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowHelpMailToDevelopers.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "AVEVA Test - Help - Write to developer";
        showAndTuneScene(root, title, false);
    }

    protected void goToTests() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowTests.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "AVEVA Test - Tests";
        showAndTuneScene(root, title, false);
    }

    protected void goToQuestions() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("window1Question.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "AVEVA Test - Questions";
        showAndTuneScene(root, title, false);
    }

    protected void goToTestResults() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("windowTestResults.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = "AVEVA Test - Test results";
        showAndTuneScene(root, title, false);
    }

    private void showAndTuneScene(Parent root, String title, Boolean isAuthNextScene) {
        if (isAuthNextScene) {
            nextScene = new Scene(root);
        } else {
            nextScene = new Scene(root, widthScreen, heightScreen);
        }
        myStage.setScene(nextScene);
        myStage.setTitle(title);
        myStage.setResizable(false);
        if (isAuthNextScene) {
            myStage.centerOnScreen();
        } else {
            myStage.setMaximized(true);
        }
        myStage.show();
    }

    protected String getLangSource(String key, int position) {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("C:\\Users\\slava\\Desktop\\Education_ITMO\\Desktop\\test\\src\\sample\\ru_eng.txt")))) {
            while (s.hasNextLine()) {
                String buf = s.nextLine();
                if (buf.contains(key)) {
                    String[] array = buf.split(";");
                    return array[position];
                }
            }
            System.out.println("BAD KEY OR POSITION OF LANGUAGE");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
