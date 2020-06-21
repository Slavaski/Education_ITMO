/**
 * @file mainwindow.h
 * @brief client/user application
 * @author Rashevskii Slava
 */
#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QMessageBox>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    dialog = new Authorization();
    this->authorization();
    this->nick = dialog->getNick();
    this->port = dialog->getPort();
    ui->nick->setText(this->nick);
    if (nick != " "){
        socketClient = new QWebSocket();
        QUrl urlServer = QUrl(QString("ws://127.0.0.1:"));
        urlServer.setPort(port);
        socketClient->open(urlServer);
    }

    connect(socketClient, &QWebSocket::connected,
            this, &MainWindow::connected);
    connect(ui->send, &QPushButton::clicked,
            this, &MainWindow::execButtonAction);
    connect(socketClient, &QWebSocket::textMessageReceived,
            this, &MainWindow::readSocket);
    connect(dialog, &Authorization::sendNick,
            this, &MainWindow::setNick);
    connect(socketClient, &QWebSocket::disconnected,
            this, &MainWindow::serverDisconnected);

}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::connected(){
    QMessageBox::information(NULL, QObject::tr("Информация"),
                             tr("Подключение прошло успешно!"));
}

void MainWindow::execButtonAction()
{
    if(ui->message->text().toUtf8() == ""){
         QMessageBox::information(NULL,QObject::tr("Ошибка"),
                                  tr("Введите сообщение"));
         return;
    } else {
        socketClient->sendTextMessage(nick + " " + ui->message->displayText());
        ui->message->clear();
    }
}

void MainWindow::readSocket(QString message)
{
    ui->textEdit->append(message);
}

void MainWindow::setNick(QString nickname){
    this->nick = nickname;
    ui->nick->setText(nick);
}

void MainWindow::authorization(){
    dialog->exec();
    this->close();
}

void MainWindow::serverDisconnected()
{
    QMessageBox::information(NULL,QObject::tr("Информация"),
                             tr("Нет подключения к серверу"));
}
