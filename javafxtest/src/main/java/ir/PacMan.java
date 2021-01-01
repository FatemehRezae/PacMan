package ir;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PacMan {
    private double x = 300;
    private double y = 175;
    private final double radius = 10;
    private Circle pacMan;
    private int score;
    private static int life = 2;
    private double speed = 3.5;

    public PacMan() {
        draw(x, y);
    }

    public Paint getColor() {
        return pacMan.getFill();
    }

    public void draw(double x, double y) {
        pacMan = new Circle(x, y, radius, Color.GOLD);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void refresh() {
        pacMan.setCenterY(175.0);
        pacMan.setCenterX(300);
    }


    public void left() {
        if (x - speed > radius + 7)
            if (move(x - speed, y, radius)) {
                this.x = x - speed;
                pacMan.setCenterX(getX());
            }
    }

    public void right() {
        if (x + speed < 595 - radius) {
            if (move(x + speed, y, radius)) {
                this.x = x + speed;
                pacMan.setCenterX(getX());
            }
        }
    }

    public void up() {
        if (y - speed > 7 + radius) {
            if (move(x, y - speed, radius)) {
                this.y = y - speed;
                pacMan.setCenterY(getY());
            }
        }
    }

    public void down() {
        if (y + speed < 195 - radius)
            if (move(x, y + speed, radius)) {
                this.y = y + speed;
                pacMan.setCenterY(getY());
            }
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

    public static boolean move(double x, double y, double r) {
        if (x >= 272 + r && x <= 330 - r && y >= 122 + r || y >= 42 + r && y < 79 - r)
            return true;
        if (y >= 7 + r && y <= 40 - r)
            return true;
        if (x <= 270 - r || x >= 272 + r && x <= 330 - r || x > 350) {
            if (y >= 162 + r)
                return true;
        }
        if (y <= 160 - r && y >= 122 + r)
            return true;
        if (x <= 45 - r || x >= 225 + r && x <= 270 - r || x >= 330 + r && x <= 375 - r || x >= 555 + r)
            return true;
        if (y >= 81 + r && y <= 120 - r && x >= 47 + r && x <= 270 - r)
            return true;
        if (x >= 210 + r && x <= 270 - r && y >= 42 + r && y <= 160 - r)
            return true;
        if (x >= 375 + r && x <= 395 - r || x >= 397 + r && x <= 435 - r || x >= 497 + r && x <= 530 - r ||
                x >= 532 + r) {
            if (y >= 42 + r && y <= 160 - r)
                return true;
        } else if (x >= 437 + r && x <= 495 - r && y >= 81 + r && y <= 160 - r)
            return true;
        return false;
    }
    public void addSc(){
        score++;
    }
    public void setLife(int i) {
        life=i;
    }

    public int getLife() {
        return life;
    }

    public int getScore() {
        return score;
    }

    public Circle getPacMan() {
        return pacMan;
    }

    public void setScore(int Score) {
        this.score = score;
    }
}
