/**
 * @file authorization.cpp
 * @brief authorization: entry of the nickname and server port and confirmation of the entered data
 * @author Rashevskii Slava
 */
#include "authorization.h"
#include "ui_authorization.h"
#include <QMessageBox>

Authorization::Authorization(QWidget *parent) :
    QDialog(parent), ui(new Ui::Authorization)
{
    ui->setupUi(this);
    connect(ui->ok, &QPushButton::clicked,
            this, &Authorization::pushOk);
}

Authorization::~Authorization(){
    delete ui;
}

void Authorization::pushOk(){
    if(ui->nick->displayText() == "" ||
       ui->nick->displayText() == " "){
        QMessageBox::information(NULL,QObject::tr("Ошибка"), tr("Введите никнейм!"));
        return; }
    nick = ui->nick->displayText();
    this->close();
    emit sendNick(ui->nick->displayText());
}

QString Authorization::getNick(){
    return nick;
}

quint16 Authorization::getPort(){
    quint16 port = 1113;
    if (ui->port->displayText() == "") { return port; }
    else { return ui->port->displayText().toUInt(); }
}