/**
  * @file main.cpp
  * @brief main file
  * @author Rashevskii Slava
  */
#include "mainwindow.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWindow w;
    w.show();
    return a.exec();
}
