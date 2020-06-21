/**
 * @file scene.h
 * @brief scene for painting
 * @author Rashevskii Slava
 */
#ifndef SCENE_H
#define SCENE_H

#include <QGraphicsScene>
#include <QGraphicsSceneMouseEvent>

class Scene : public QGraphicsScene
{
    Q_OBJECT
private:
    /**
     * @brief coordinates of previous point
     */
    QPointF previousPoint;

    /**
     * @brief color of pencil
     */
    QColor color;

    /**
     * @brief size of pencil
     */
    int size;

public:
    explicit Scene(QObject *parent = nullptr);
    ~Scene();

private:
    /**
     * @brief mousePressEvent
     * @param event
     */
    void mousePressEvent(QGraphicsSceneMouseEvent *event);

    /**
     * @brief mouseMoveEvent
     * @param event
     */
    void mouseMoveEvent(QGraphicsSceneMouseEvent *event);

public slots:
    /**
     * @brief setColor
     * @param color
     */
    void setColor(QString color);

    /**
     * @brief setSize
     * @param size
     */
    void setSize (QString size);
};

#endif // SCENE_H
