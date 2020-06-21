/**
 * @file mainwindow.h
 * @brief client/user application
 * @author Rashevskii Slava
 */
#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QWebSocket>
#include "authorization.h"

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

private:
    Ui::MainWindow *ui;
    QWebSocket *socketClient;
    QString nick = " ";
    quint16 port;
    Authorization* dialog;

public:
    /**
     * @brief Client constructor
     * @param parent
     */
    MainWindow(QWidget *parent = nullptr);

    /**
      * @brief Client destructor
      */
    ~MainWindow();

private slots:
    /**
     * @brief function called after pressing a button, after which message is sent
     */
    void execButtonAction();

    /**
     * @brief read Socket
     */
    void readSocket(QString message);

    /**
     * @brief connected
     */
    void connected();

    /**
     * @brief set nickname of user
     * @param nickname
     */
    void setNick(QString nickname);

    /**
     * @brief authorization
     */
    void authorization();

    /**
     * @brief server disconnected
     */
    void serverDisconnected();
};
#endif // MAINWINDOW_H
