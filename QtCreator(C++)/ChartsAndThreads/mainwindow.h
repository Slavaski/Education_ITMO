/**
  * @file mainwindow.h
  * @brief main window with charts
  * @author Slava Rashevskii
  */
#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QThread>
#include <QChart>
#include <QChartView>
#include <QBarSeries>
#include <QBarSet>
#include <QBarCategoryAxis>
#include <QValueAxis>
#include <QTimer>
#include "sort.h"

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

using namespace QtCharts;

class MainWindow : public QMainWindow
{
  Q_OBJECT
public:
  /**
   * @brief constructor MainWindow
   * @param parent
   */
  MainWindow(QWidget *parent = nullptr);
  /**
    * @brief destructor MainWindow
    */
  ~MainWindow();

private:
  Ui::MainWindow *ui;
  QThread        *thread;
  Sort           *array;
  QChart         *chart;
  QChartView     *view;
  QBarSeries     *series;
  QTimer         *timer;
  double         zoomValue=1;

private:
  /**
   * @brief create chart
   */
  void createChart();
  /**
   * @brief create series for chart
   * @return
   */
  QBarSeries* createSeries();
  /**
   * @brief create X axis for chart
   * @return
   */
  QBarCategoryAxis* createXAxis();
  /**
   * @brief create Y axis for chart
   * @return
   */
  QValueAxis* createYAxis();
  /**
   * @brief create chart view
   */
  void createChartView();
  /**
   * @brief create set for series
   * @return
   */
  QBarSet* createSet();

private slots:
  /**
   * @brief button start is clicked
   */
  void startClicked();
  /**
   * @brief button stop is clicked
   */
  void stopClicked();
  /**
   * @brief change series
   */
  void changeSeries();
  /**
   * @brief sort finished message
   */
  void sortFinished();
  /**
   * @brief zoom in
   */
  void plusZoom();
  /**
   * @brief zoom out
   */
  void minusZoom();
  /**
   * @brief reset zoom
   */
  void resetZoom();
};
#endif // MAINWINDOW_H
