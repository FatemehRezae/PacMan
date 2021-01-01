package ir;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RedGhost extends Ghost{
    private boolean goingDown = true;

    public RedGhost(double x, double y, Group root, double speed, double radius) {
        super(x, y, root, speed, radius);
    }

    @Override
    public void move(Circle pacMan) {
        if (goingDown)
            if (getCircle().getCenterY() + getSpeed() <195 - getRadius()){
                getCircle().setCenterY(getCircle().getCenterY() + getSpeed());
            }
            else {
                goingDown = false;
            }
        if (!goingDown) {
            if (getCircle().getCenterY() - getSpeed() > 7 + getRadius()) {
                getCircle().setCenterY(getCircle().getCenterY() - getSpeed());

            }
            else {
                goingDown = true;
            }
        }
    }

    @Override
    public void draw(Group root) {
         Circle circle = new Circle(getX(),getY(),getRadius(),Color.RED);
         setCircle(circle);
         root.getChildren().add(circle);
    }
}
