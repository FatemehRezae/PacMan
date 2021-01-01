package ir;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public abstract class Ghost {
    private double x;
    private double y;
    private final double speed;
    private final double radius;
    private Circle circle;

    public Ghost(double x, double y, Group root, double speed, double radius) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.radius = radius;
        draw(root);
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public double getSpeed() {
        return speed;
    }

    public Circle getCircle() {
        return circle;
    }

    public double getX() {
        return x;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public abstract void move(Circle pacMan);

    public abstract void draw(Group root);
    public boolean hitPacMan(Circle pacMan){
        return Handler.circlesTouch(pacMan, getCircle()) == 1;
    }
}
