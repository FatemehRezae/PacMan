package ir;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class CyanGhost extends Ghost {
    private boolean toTheRight = true;

    public CyanGhost(double x, double y, Group root, double speed, double radius) {
        super(x, y, root, speed, radius);
    }


    @Override
    public void move(Circle pacMan) {
        if (toTheRight)
            if (getCircle().getCenterX() + getSpeed() < 595 - getRadius()) {
                getCircle().setCenterX(getCircle().getCenterX() + getSpeed());
            }
            else {
                toTheRight = false;
            }
        if (!toTheRight) {
            if (getCircle().getCenterX() - getSpeed() > 7 + getRadius()) {
                getCircle().setCenterX(getCircle().getCenterX() - getSpeed());
            }
            else {
                toTheRight = true;
            }
        }
    }

    @Override
    public void draw(Group root) {
        Circle circle = new Circle(getX(),getY(),getRadius(),Color.CYAN);
        setCircle(circle);
        root.getChildren().add(circle);
    }
}
