/**
 * @file server.h
 * @brief server
 * @author Rashevskii Slava
 */
#ifndef SERVER_H
#define SERVER_H

#include <QObject>
#include <QWebSocketServer>
#include <QSettings>
#include <QSqlDatabase>

class Server : public QObject
{
    Q_OBJECT
private:
    /**
     * @brief connecting
     */
    QWebSocketServer* webServer;

    /**
     * @brief connecting to the client
     */
    QWebSocket* client;

    /**
     * @brief list of clients
     */
    QList <QWebSocket*> clients;

    /**
     * @brief settings
     */
    QSettings *settings;

    /**
     * @brief database
     */
    QSqlDatabase db;

public:
    /**
     * @brief Server Constructor
     * @param parent
     */
    explicit Server(QObject *parent = nullptr);

    /**
      * @brief Server destructor
      */
    ~Server();
	
    /**
     * @brief getPort
     * @return port
     */
    QString getPort();
	
    /**
     * @brief getHost
     * @return host
     */
    QString getHost();

private:
    /**
     * @brief Send message for all users
     * @param message
     */
    void sender(QString message);

    /**
     * @brief connect database
     */
    void connectDatabase();

    /**
     * @brief record message
     * @param user nick
     * @param user message
     */
    void recordMessage(QString nick, QString message);

public slots:
    /**
     * @brief set settings for server
     * @param server host
     * @param server port
     */
    void setSettings(QString host, quint16 port);

private slots:
    /**
     * @brief read settings
     * @return server port
     */
    quint16 readSettings();

    /**
     * @brief connect user
     */
    void connectUser();

    /**
     * @brief message from client
     */
    void runClientAction(QString message);

    /**
     * @brief disconnect user
     */
    void disconnectUser();

    /**
     * @brief send last 10 messages for new user
     */
    void send10Message();

signals:
    /**
     * @brief information about server
     * @param info - message with information about server
     */
    void info(QString info);
};

#endif // SERVER_H
