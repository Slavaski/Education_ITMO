package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class ControllerWriteToDevelopersWindow extends ControllerAuthWindow {
    /**
     * for localization
     */
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

    @FXML
    void initialize() {
        setAllText();
        initButtons();
        System.out.println(sendEmail());
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
        buttonHelp.setOnAction(event -> goToHelp());
        buttonSignOut.setOnAction(event -> signOut());
        buttonTests.setOnAction(event -> goToTests());
        imageMain.setOnMouseClicked(event -> goToMain());
        buttonTestResults.setOnAction(event -> goToTestResults());
    }

    private void setScene() {
        goToWriteToDevelopers();
    }

    private void setAllText() {
        userEmail.setText(login);
        langRus.setText(getLangSource("langRus"));
        langEng.setText(getLangSource("langEng"));
        menuLang.setText(getLangSource("menuLang"));
        menuTheme.setText(getLangSource("menuTheme"));
        themeDark.setText(getLangSource("themeDark"));
        buttonHelp.setText(getLangSource("buttonHelp"));
        themeLight.setText(getLangSource("themeLight"));
        buttonTests.setText(getLangSource("buttonTests"));
        buttonSignOut.setText(getLangSource("buttonSignOut"));
        buttonTestResults.setText(getLangSource("buttonTestResults"));

    }

    /**
     * @return operation code from server
     */
    private int sendEmail() {
////        String sender = login;
////        String senderPassword = ""; //@todo решить, создавать ли новую почту или спрашивать пароль от почты
//
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", "mail.javatpoint.com");
//        properties.put("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(userTest, passwordTest);
//            }
//        });
//
//        try {
//
//            Transport.send(message);
//
//            System.out.println("message sent...");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }

//        send("slava121231@gmail.com", "Gmailkey12123402022021", "slava121231@mail.ru", "hello javatpoint", "How r u?");
        send("slava121231@gmail.com", "Gmailkey12123402022021", "rakivas@mail.ru");
        return 1;
    }

    public void send(String from, String password, String to) {
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("7 навыков");  //@todo сюда вставлять тему письма

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("Могу пихать все, что хочу. Хоть еще файлов, хоть ссылки, хоть сайты. Не смотри на название файла.");

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            String filename = "F:\\7 навыков.pdf"; //@todo сюда вставлять название файла
            DataSource source = new FileDataSource(filename); //@todo ограничить до 1 файла добавление или делать больше messageBodyPart
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}

