package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("windowMain.fxml")); //
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
        windowToHide.hide();
        stage.setTitle("Test"); //@todo дополнить название, указывая доп окно
        stage.setResizable(false);
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
        windowToHide.hide();
        stage.setTitle("Test"); //@todo дополнить название, указывая доп окно
        stage.setResizable(false);
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
        windowToHide.hide();
        stage.setTitle("Test"); //@todo дополнить название, указывая доп окно
        stage.setResizable(false);
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
        windowToHide.hide();
        stage.setTitle("Test"); //@todo дополнить название, указывая доп окно
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
