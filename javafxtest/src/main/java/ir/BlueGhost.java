package ir;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BlueGhost extends Ghost {
    private double right;
    private double left;
    private double down;
    private double up;

    public BlueGhost(double x, double y, Group root, double speed, double radius) {
        super(x, y, root, speed, radius);
    }

    public boolean right() {
        if (getCircle().getCenterX() + getSpeed() <= 595 - getRadius())
            if (PacMan.move(getCircle().getCenterX() + getSpeed(), getCircle().getCenterY(), getRadius())) {
                getCircle().setCenterX(getCircle().getCenterX() + getSpeed());
                return true;
            }
        return false;
    }

    public boolean left() {
        if (getCircle().getCenterX() - getSpeed() > getRadius() + 7) {
            if (PacMan.move(getCircle().getCenterX() - getSpeed(), getCircle().getCenterY(), getRadius())) {
                getCircle().setCenterX(getCircle().getCenterX() - getSpeed());
                return true;
            }
        }
        return false;
    }

    public boolean up() {
        if (getCircle().getCenterY() - getSpeed() > 7 + getRadius())
            if (PacMan.move(getCircle().getCenterX(), getCircle().getCenterY() - getSpeed(), getRadius())) {
                getCircle().setCenterY(getCircle().getCenterY() - getSpeed());
                return true;
            }
        return false;
    }

    public boolean down() {
        if (getCircle().getCenterY() + getSpeed() < 195 - getRadius())
            if (PacMan.move(getCircle().getCenterX(), getCircle().getCenterY() + getSpeed(), getRadius())) {
                getCircle().setCenterY(getCircle().getCenterY() + getSpeed());
                return true;
            }
        return false;
    }

    @Override
    public void move(Circle pacMan) {
        right = distance(getCircle().getCenterX() + getSpeed(), getCircle().getCenterY(), pacMan);
        left = distance(getCircle().getCenterX() - getSpeed(), getCircle().getCenterY(), pacMan);
        up = distance(getCircle().getCenterX(), getCircle().getCenterY() - getSpeed(), pacMan);
        down = distance(getCircle().getCenterX(), getCircle().getCenterY() + getSpeed(), pacMan);
        boolean move;
        if (right <= left) {
            if (right <= up) {
                if (right <= down) {
                    move = right();
                    if (!move)
                        if (down <= up)
                            down();
                        else up();
                } else {
                    move = down();
                    if (!move)
                        if (left <= right)
                            left();
                        else right();
                }
            } else if (up <= down) {
                move = up();
                if (!move)
                    if (left <= right)
                        left();
                    else right();
            } else {
                move = down();
                if (!move)
                    if (left <= right)
                        left();
                    else right();
            }
        } else {
            if (left <= up) {
                if (left <= down) {
                    move = left();
                    if (!move)
                        if (left <= right)
                            left();
                        else right();
                } else {
                    move = down();
                    if (!move)
                        if (left <= right)
                            left();
                        else right();
                }
            } else if (down <= up) {
                move = down();
                if (!move)
                    if (left <= right)
                        left();
                    else right();
            } else {
                move = up();
                if (!move)
                    if (left <= right)
                        left();
                    else right();
            }
        }
    }

    public static double distance(double x, double y, Circle p) {
        return Math.pow(x - p.getCenterX(), 2) + Math.pow(y - p.getCenterY(), 2);
    }

    @Override
    public void draw(Group root) {
        Circle circle = new Circle(getX(), getY(), getRadius(), Color.BLUE);
        setCircle(circle);
        root.getChildren().add(circle);
    }


}

