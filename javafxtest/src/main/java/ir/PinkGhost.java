package ir;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PinkGhost extends Ghost {
    private int r;

    public PinkGhost(double x, double y, Group root, double speed, double radius) {
        super(x, y, root, speed, radius);
        r = Handler.getRandom().nextInt(4);
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
        int t = Handler.getRandom().nextInt(30);
        if (t == 0) {
            if (getCircle().getCenterX() < 45 - getRadius() || getCircle().getCenterX() > 225 + getRadius() &&
                    getCircle().getCenterX() < 270 - getRadius() || getCircle().getCenterX() > 330 + getRadius() &&
                    getCircle().getCenterX() < 375 - getRadius() || getCircle().getCenterX() > 555 + getRadius())
                r = Handler.getRandom().nextInt(4);
            else if (getCircle().getCenterX() < 435 - getRadius() && getCircle().getCenterX() > 397 + getRadius() ||
                    getCircle().getCenterX() < 530 - getRadius() || getCircle().getCenterX() > 497 + getRadius() &&
                    getCircle().getCenterY() < 158 - getRadius() && getCircle().getCenterY() > 42 + getRadius())
                r = Handler.getRandom().nextInt(4);
        }


        boolean move;
        if (r == 0) {
            move = left();
            if (!move) {
                r = Handler.getRandom().nextInt(4);
            }
        }
        if (r == 2) {
            move = right();
            if (!move)
                r = Handler.getRandom().nextInt(4);

        }
        if (r == 3) {
            move = down();
            if (!move)
                r = Handler.getRandom().nextInt(4);
        }
        if (r == 1) {
            move = up();
            if (!move)
                r = Handler.getRandom().nextInt(4);

        }

    }

    @Override
    public void draw(Group root) {
        Circle circle = new Circle(getX(), getY(), getRadius(), Color.PINK);
        setCircle(circle);
        root.getChildren().add(circle);
    }
}
