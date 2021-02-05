package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class ControllerWriteToDevelopersWindow extends ControllerAuthWindow {
    @FXML
    private JFXTextArea enterLetter;
    @FXML
    private JFXButton comment;
    @FXML
    private JFXButton wish;
    @FXML
    private JFXButton another;
    @FXML
    private JFXButton claim;
    @FXML
    private Text nameFile;
    @FXML
    private Rectangle rectFile;
    @FXML
    private JFXButton buttonDeleteFile;
    @FXML
    private JFXButton buttonAddFile;
    @FXML
    private JFXButton buttonSend;
    /**
     * for localization
     */
    @FXML
    private Text writeToDevelopers;
    @FXML
    private Text userEmail;
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

    private String nameOfFile = "";
    private String nameOfFileWithPath = "";
    private String subject = "";

    @FXML
    void initialize() {
        setAllText();
        initButtons();
    }

    private void initButtons() {
        rectFile.setVisible(false);
        rectFile.setDisable(true);
        nameFile.setVisible(false);
        nameFile.setDisable(true);
        buttonDeleteFile.setVisible(false);
        buttonDeleteFile.setDisable(true);

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
        buttonHelp.setOnAction(event -> goToHelp());
        buttonSignOut.setOnAction(event -> signOut());
        buttonTests.setOnAction(event -> goToTests());
        imageMain.setOnMouseClicked(event -> goToMain());
        buttonTestResults.setOnAction(event -> goToTestResults());
        buttonSend.setOnAction(event -> {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText(getLangSource("helpContentAlert"));
            a.setTitle(getLangSource("helpTitleAlert"));
            a.setHeaderText("");
            a.show();
            a.setHeight(230.0);
            a.setY(200.0);
            //@todo уточнить, что отправка может занять некоторое время и программа не будет отвечать на действия - нужно просто подождать (зависит от интернета, серверов, компа)

            sendEmail();

            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setContentText(getLangSource("helpContentAlert"));
            b.setTitle(getLangSource("helpTitleAlert"));
            b.setHeaderText("");
            b.show();
            b.setHeight(230.0);
            b.setY(200.0);
            //@todo подтвердить отправку сообщения и поблагодарить за отзыв
        });
        buttonAddFile.setOnAction(event -> {
            FileChooser file = new FileChooser();
            file.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text File", "*.docx", "*.doc", "*.txt"),
                    new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif", "*.bmp")
            );
            File file1 = file.showOpenDialog(myStage);
            if (file1 != null) {
                nameOfFile = file1.getName();
                nameFile.setText(nameOfFile);
                nameOfFileWithPath = file1.getAbsolutePath();

                buttonAddFile.setDisable(true);
                buttonAddFile.setVisible(false);

                rectFile.setVisible(true);
                rectFile.setDisable(false);
                nameFile.setVisible(true);
                nameFile.setDisable(false);
                buttonDeleteFile.setVisible(true);
                buttonDeleteFile.setDisable(false);
            }
        });
        buttonDeleteFile.setOnAction(event -> {
            nameFile.setText("");
            nameOfFile = "";
            nameOfFileWithPath = "";

            rectFile.setVisible(false);
            rectFile.setDisable(true);
            nameFile.setVisible(false);
            nameFile.setDisable(true);
            buttonDeleteFile.setVisible(false);
            buttonDeleteFile.setDisable(true);

            buttonAddFile.setDisable(false);
            buttonAddFile.setVisible(true);
        });

        wish.setOnAction(event -> {
            if (themeNumber == 1) {
                wish.setStyle("-fx-background-color: #006fb7; -fx-border-color: #000000;");
                another.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                claim.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                comment.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");

                wish.setTextFill(Paint.valueOf("#000000"));
                another.setTextFill(Paint.valueOf("#006fb7"));
                claim.setTextFill(Paint.valueOf("#006fb7"));
                comment.setTextFill(Paint.valueOf("#006fb7"));
            } else {
                wish.setStyle("-fx-background-color: #a0a0a0; -fx-border-color: #C0C0C0;");
                another.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                claim.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                comment.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");

                wish.setTextFill(Paint.valueOf("#1B1B1B"));
                another.setTextFill(Paint.valueOf("#a0a0a0"));
                claim.setTextFill(Paint.valueOf("#a0a0a0"));
                comment.setTextFill(Paint.valueOf("#a0a0a0"));
            }
            subject = getLangSource("wish");
        });
        another.setOnAction(event -> {
            if (themeNumber == 1) {
                wish.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                another.setStyle("-fx-background-color: #006fb7; -fx-border-color: #000000;");
                claim.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                comment.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");

                wish.setTextFill(Paint.valueOf("#006fb7"));
                another.setTextFill(Paint.valueOf("#000000"));
                claim.setTextFill(Paint.valueOf("#006fb7"));
                comment.setTextFill(Paint.valueOf("#006fb7"));
            } else {
                wish.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                another.setStyle("-fx-background-color: #a0a0a0; -fx-border-color: #C0C0C0;");
                claim.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                comment.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");

                wish.setTextFill(Paint.valueOf("#a0a0a0"));
                another.setTextFill(Paint.valueOf("#1B1B1B"));
                claim.setTextFill(Paint.valueOf("#a0a0a0"));
                comment.setTextFill(Paint.valueOf("#a0a0a0"));
            }
            subject = getLangSource("another");
        });
        claim.setOnAction(event -> {
            if (themeNumber == 1) {
                wish.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                another.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                claim.setStyle("-fx-background-color: #006fb7; -fx-border-color: #000000;");
                comment.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");

                wish.setTextFill(Paint.valueOf("#006fb7"));
                another.setTextFill(Paint.valueOf("#006fb7"));
                claim.setTextFill(Paint.valueOf("#000000"));
                comment.setTextFill(Paint.valueOf("#006fb7"));
            } else {
                wish.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                another.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                claim.setStyle("-fx-background-color: #a0a0a0; -fx-border-color: #C0C0C0;");
                comment.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");

                wish.setTextFill(Paint.valueOf("#a0a0a0"));
                another.setTextFill(Paint.valueOf("#a0a0a0"));
                claim.setTextFill(Paint.valueOf("#1B1B1B"));
                comment.setTextFill(Paint.valueOf("#a0a0a0"));
            }
            subject = getLangSource("claim");
        });
        comment.setOnAction(event -> {
            if (themeNumber == 1) {
                wish.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                another.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                claim.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
                comment.setStyle("-fx-background-color: #006fb7; -fx-border-color: #000000;");

                wish.setTextFill(Paint.valueOf("#006fb7"));
                another.setTextFill(Paint.valueOf("#006fb7"));
                claim.setTextFill(Paint.valueOf("#006fb7"));
                comment.setTextFill(Paint.valueOf("#000000"));
            } else {
                wish.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                another.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                claim.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
                comment.setStyle("-fx-background-color: #a0a0a0; -fx-border-color: #C0C0C0;");

                wish.setTextFill(Paint.valueOf("#a0a0a0"));
                another.setTextFill(Paint.valueOf("#a0a0a0"));
                claim.setTextFill(Paint.valueOf("#a0a0a0"));
                comment.setTextFill(Paint.valueOf("#1B1B1B"));
            }
            subject = getLangSource("comment");
        });
    }

    private void setScene() {
        goToWriteToDevelopers();
    }

    private void setAllText() {
        userEmail.setText(login);
        wish.setText(getLangSource("wish"));
        claim.setText(getLangSource("claim"));
        comment.setText(getLangSource("comment"));
        another.setText(getLangSource("another"));
        langRus.setText(getLangSource("langRus"));
        langEng.setText(getLangSource("langEng"));
        menuLang.setText(getLangSource("menuLang"));
        menuTheme.setText(getLangSource("menuTheme"));
        themeDark.setText(getLangSource("themeDark"));
        buttonHelp.setText(getLangSource("buttonHelp"));
        themeLight.setText(getLangSource("themeLight"));
        buttonTests.setText(getLangSource("buttonTests"));
        buttonSignOut.setText(getLangSource("buttonSignOut"));
        enterLetter.setPromptText(getLangSource("enterLetter"));
        buttonTestResults.setText(getLangSource("buttonTestResults"));
        writeToDevelopers.setText(getLangSource("writeToDevelopers"));
    }

    private void sendEmail() {
        //@todo решить, создавать ли новую почту каждому пользователю, создать новую служебную свою или спрашивать пароль от почты

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(login, password);
                        return new PasswordAuthentication("slava121231@gmail.com", "Gmailkey12123402022021");
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("slava121231@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("slava121231@mail.ru"));
            message.setSubject("REVIEW ABOUT \"Klinkmann Testing\": " + subject);

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(enterLetter.getText());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);

            if (!nameOfFileWithPath.equals("")) {
                MimeBodyPart messageBodyPart2 = new MimeBodyPart();

                String filename = nameOfFileWithPath;
                DataSource source = new FileDataSource(filename);
                messageBodyPart2.setDataHandler(new DataHandler(source));
                messageBodyPart2.setFileName(filename);
                multipart.addBodyPart(messageBodyPart2);
            }
            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

