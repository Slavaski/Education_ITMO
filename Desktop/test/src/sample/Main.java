package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("windowAuth.fxml"));
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root, 795, 500));
        primaryStage.setResizable(false); //@todo надо сделать!
//        primaryStage.setMaximized(true);
        primaryStage.show();

    }
/*
        FileInputStream input = null;
        try {
            input = new FileInputStream("@../icons_logo/baseline_help_black_18dp.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert input != null;
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        Button btn1 = new Button("Войти", imageView);
        btn1.setOnAction(value -> {
            btn1.setText("Вошел");
        });*/

    public static void main(String[] args) {
        launch(args);
    }
}
