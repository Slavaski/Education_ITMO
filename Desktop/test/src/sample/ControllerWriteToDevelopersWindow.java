package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Text nameFile;
    @FXML
    private Rectangle rectFile;
    @FXML
    private JFXTextArea enterLetter;
    @FXML
    private JFXButton wish;
    @FXML
    private JFXButton claim;
    @FXML
    private JFXButton comment;
    @FXML
    private JFXButton another;
    @FXML
    private JFXButton buttonSend;
    @FXML
    private JFXButton buttonAddFile;
    @FXML
    private JFXButton buttonDeleteFile;
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
            a.setContentText(getLangSource("confirmationContentSendEmail"));
            a.setTitle(getLangSource("confirmationTitleSendEmail"));
            a.setHeaderText("");
            a.setHeight(400.0);
            a.setWidth(400.0);
            a.setX((WIDTH_SCREEN / 2) - (a.getWidth() / 2));
            a.setY((HEIGHT_SCREEN / 2) - (a.getHeight() / 2));

            Optional<ButtonType> action = a.showAndWait();
            if (action.get() == ButtonType.OK) {
                sendEmail();

                Alert b = new Alert(Alert.AlertType.INFORMATION);
                b.setContentText(getLangSource("confirmationContentSuccess"));
                b.setTitle(getLangSource("confirmationTitleSuccess"));
                b.setHeaderText("");
                b.show();
                a.setHeight(400.0);
                a.setWidth(400.0);
                a.setX((WIDTH_SCREEN / 2) - (a.getWidth() / 2));
                a.setY((HEIGHT_SCREEN / 2) - (a.getHeight() / 2));
            }
        });
        buttonAddFile.setOnAction(event -> {
            FileChooser file = new FileChooser();
            file.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text File", "*.docx", "*.doc", "*.txt"),
                    new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif", "*.bmp")
            );
            File file1 = file.showOpenDialog(myStage);
            int maxSizeOfFile = 10_485_760;
            if (file1 != null && file1.length() <= maxSizeOfFile) {
                nameOfFile = file1.getName();
                nameFile.setText(nameOfFile);
                nameOfFileWithPath = file1.getAbsolutePath();

                buttonAddFile.setDisable(true);
                buttonAddFile.setVisible(false);

                double neededWidth = nameOfFile.length() * 8 + 10;
                if (neededWidth <= 100) {
                    neededWidth += 30;
                }
                if (neededWidth >= enterLetter.getWidth()) {
                    nameFile.setText("Name of chosen file too long");
                    neededWidth = nameFile.getText().length() * 8 + 10;
                }

                rectFile.setWidth(neededWidth);
                nameFile.setWrappingWidth(neededWidth);
                buttonDeleteFile.setLayoutX(buttonDeleteFile.getWidth() + rectFile.getWidth() - 5);

                rectFile.setVisible(true);
                rectFile.setDisable(false);
                nameFile.setVisible(true);
                nameFile.setDisable(false);
                buttonDeleteFile.setVisible(true);
                buttonDeleteFile.setDisable(false);
            }
            if (file1 != null && file1.length() > maxSizeOfFile) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(getLangSource("errorContentAlertSizeOfFile"));
                a.setTitle(getLangSource("errorTitleAlertSizeOfFile"));
                a.setHeaderText("");
                a.setHeight(400.0);
                a.setWidth(400.0);
                a.setX((WIDTH_SCREEN / 2) - (a.getWidth() / 2));
                a.setY((HEIGHT_SCREEN / 2) - (a.getHeight() / 2));
                a.show();
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
            setStyleForSubjectButtons(wish);
            subject = getLangSource("wish");
        });
        another.setOnAction(event -> {
            setStyleForSubjectButtons(another);
            subject = getLangSource("another");
        });
        claim.setOnAction(event -> {
            setStyleForSubjectButtons(claim);
            subject = getLangSource("claim");
        });
        comment.setOnAction(event -> {
            setStyleForSubjectButtons(comment);
            subject = getLangSource("comment");
        });
    }

    private void setStyleForSubjectButtons(JFXButton button) {
        if (themeNumber == 1) {
            wish.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
            another.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
            claim.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");
            comment.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #006fb7;");

            wish.setTextFill(Paint.valueOf("#006fb7"));
            another.setTextFill(Paint.valueOf("#006fb7"));
            claim.setTextFill(Paint.valueOf("#006fb7"));
            comment.setTextFill(Paint.valueOf("#006fb7"));

            button.setTextFill(Paint.valueOf("#000000"));
            button.setStyle("-fx-background-color: #006fb7; -fx-border-color: #000000;");
        } else {
            wish.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
            another.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
            claim.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");
            comment.setStyle("-fx-background-color: #424242; -fx-border-color: #a0a0a0;");

            wish.setTextFill(Paint.valueOf("#a0a0a0"));
            another.setTextFill(Paint.valueOf("#a0a0a0"));
            claim.setTextFill(Paint.valueOf("#a0a0a0"));
            comment.setTextFill(Paint.valueOf("#a0a0a0"));

            button.setTextFill(Paint.valueOf("#1B1B1B"));
            button.setStyle("-fx-background-color: #a0a0a0; -fx-border-color: #C0C0C0;");
        }
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
        buttonSend.setText(getLangSource("buttonSend"));
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

