/**
 * @file scene.h
 * @brief scene for painting
 * @author Rashevskii Slava
 */
#include "scene.h"
#include <QMessageBox>

Scene::Scene(QObject *parent) : QGraphicsScene(parent){
    this->setSize("1");
}

Scene::~Scene(){}

void Scene::mousePressEvent(QGraphicsSceneMouseEvent *event){
    addEllipse(event->scenePos().x()-(size/2),
               event->scenePos().y()-(size/2),
               size, size, QPen(Qt::NoBrush), QBrush(color));
    previousPoint = event->scenePos();
}

void Scene::mouseMoveEvent(QGraphicsSceneMouseEvent *event){
    addLine(previousPoint.x(), previousPoint.y(),
            event->scenePos().x(), event->scenePos().y(),
            QPen(color, size,Qt::SolidLine,Qt::RoundCap));
    previousPoint = event->scenePos();
}

void Scene::setColor(QString color){
    this->color = color;
}

void Scene::setSize(QString size){
    if(size.toInt()>0)
        this->size = size.toInt();
    else{
        QMessageBox::information(NULL,QObject::tr("Error"), tr("Enter size more than 0"));
        return; }
}
