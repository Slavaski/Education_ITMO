/**
 * @file authorization.h
 * @brief authorization: entry of the nickname and server port and confirmation of the entered data
 * @author Rashevskii Slava
 */
#ifndef AUTHORIZATION_H
#define AUTHORIZATION_H

#include <QDialog>

namespace Ui {class Authorization;}

class Authorization : public QDialog
{
    Q_OBJECT

public:
    /**
     * @brief Constructor
     * @param parent
     */
    explicit Authorization(QWidget *parent = nullptr);

    /**
     * @brief Destructor
     */
    ~Authorization();

    /**
     * @brief get user nickname
     * @return nickname
     */
    QString getNick();

    /**
     * @brief get Port with server
     * @return port
     */
    quint16 getPort();
private:
    Ui::Authorization *ui;
    QString nick;

private slots:
    /**
     * @brief push button "Ok"
     */
    void pushOk();
signals:
    /**
     * @brief send user nickname
     * @param nick
     */
    void sendNick(QString nick);
};

#endif // AUTHORIZATION_H