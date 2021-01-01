package ir;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Coin {
    private Color color;
    private final double x;
    private final double y;
    Circle circle;

    Coin(double x, double y, Color color, Group root) {
        this.x = x;
        this.y = y;
        this.color = color;
        draw(root);
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        circle.setCenterX(x);
    }

    public void setY(double y) {
        circle.setCenterY(y);
    }

    public void draw(Group group) {
        circle = new Circle(x, y, 4, color);
        group.getChildren().add(circle);
    }

    public Circle getCircle() {
        return circle;
    }
}

