package ir;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.util.ArrayList;

public class MapMaker {
    private ArrayList<Coin> coins;

    public MapMaker(Group root) {
        coins = new ArrayList<>();
        drawWalls(root);
        drawOtherWalls(root);
        coinSet(root);
    }

    public void drawWalls(Group root) {
        Line line = new Line(0, 5, 600, 5);
        root.getChildren().add(line);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        Line lineOne = new Line(0, 195, 600, 195);
        root.getChildren().add(lineOne);
        lineOne.setStroke(Color.RED);
        lineOne.setStrokeWidth(2);
        Line lineTwo = new Line(5, 0, 5, 200);
        root.getChildren().add(lineTwo);
        lineTwo.setStroke(Color.RED);
        lineTwo.setStrokeWidth(2);
        Line lineThree = new Line(595, 0, 595, 200);
        root.getChildren().add(lineThree);
        lineThree.setStroke(Color.RED);
        lineThree.setStrokeWidth(2);
    }

    public void drawOtherWalls(Group root) {
        Line line = new Line(270, 160, 270, 195);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        Line lineOne = new Line(330, 160, 330, 195);
        lineOne.setStroke(Color.RED);
        lineOne.setStrokeWidth(2);
        Line lineThree = new Line(45, 160, 225, 160);
        lineThree.setStroke(Color.RED);
        lineThree.setStrokeWidth(2);
        Line lineFour = new Line(375, 160, 555, 160);
        lineFour.setStroke(Color.RED);
        lineFour.setStrokeWidth(2);
        Line lineFive = new Line(45, 40, 225, 40);
        lineFive.setStroke(Color.RED);
        lineFive.setStrokeWidth(2);
        Line lineSix = new Line(375, 40, 555, 40);
        lineSix.setStroke(Color.RED);
        lineSix.setStrokeWidth(2);
        Line lineSeven = new Line(270, 40, 330, 40);
        lineSeven.setStroke(Color.RED);
        lineSeven.setStrokeWidth(2);
        Line lineEight = new Line(270, 40, 330, 40);
        lineEight.setStroke(Color.RED);
        lineEight.setStrokeWidth(2);
        Circle circle = new Circle(300, 100, 20, Color.WHITE);
        Line lineTw = new Line(45, 79, 210, 79);
        lineTw.setStroke(Color.RED);
        lineTw.setStrokeWidth(2);
        Line lineTh = new Line(45, 120, 210, 120);
        lineTh.setStroke(Color.RED);
        lineTh.setStrokeWidth(2);
        Line lineFo = new Line(45, 79, 45, 120);
        lineFo.setStroke(Color.RED);
        lineFo.setStrokeWidth(2);
        Line lineFif = new Line(435, 79, 495, 79);
        lineFif.setStroke(Color.RED);
        lineFif.setStrokeWidth(2);
        Line lineSi = new Line(435, 79, 435, 120);
        lineSi.setStroke(Color.RED);
        lineSi.setStrokeWidth(2);
        Line lineSev = new Line(495, 79, 495, 120);
        lineSev.setStroke(Color.RED);
        lineSev.setStrokeWidth(2);
        Line lineEighth = new Line(395, 79, 395, 120);
        lineEighth.setStroke(Color.RED);
        lineEighth.setStrokeWidth(2);
        Line lineNinth = new Line(530, 79, 530, 120);
        lineNinth.setStroke(Color.RED);
        lineNinth.setStrokeWidth(2);
        root.getChildren().addAll(line, lineEight, lineEighth, lineFif, lineFive, lineFo, lineFour, lineNinth, lineOne, lineSev,
                lineSeven, lineSi, lineSix, lineTh, lineThree, lineTw, circle);
    }

    public void coinSet(Group root) {
        Penalty penalty = new Penalty(25,23,Color.BROWN.desaturate(),root);
        coins.add(penalty);
        double x = 25, y = 43;
        Coin coin = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin);
        y = 63;
        Coin coin1 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin1);
        y = 83;
        Coin coin2 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin2);
        y = 103;
        Coin coin3 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin3);
        y = 123;
        Coin coin4 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin4);
        y = 143;
        Coin coin5 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin5);
        y = 163;
        Coin coin6 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin6);
        x = 580;
        y = 43;
        Coin coin7 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin7);
        y = 63;
        Coin coin8 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin8);
        y = 83;
        Coin coin9 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin9);
        y = 103;
        Coin coin10 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin10);
        y = 123;
        Coin coin11 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin11);
        y = 143;
        Coin coin12 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin12);
        y = 163;
        Coin coin13 = new Penalty(x,y,Color.ORANGE,root);
        coins.add(coin13);
        setCoins(root, x, y);
    }

    public void setCoins(Group root, double x, double y) {
        x = 512;
        y = 80;
        Reward reward = new Reward(x,y,Color.GREEN,root);
        coins.add(reward);
        y = 100;
        Coin coin = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin);
        y = 120;
        Coin coin0 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin0);
        x = 410;
        y = 80;
        Coin coin2 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin2);
        y = 100;
        Coin coin3 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin3);
        y = 120;
        Reward reward1 = new Reward(x,y,Color.GREEN,root);
        coins.add(reward1);
        x = 465;
        y = 93;
        Coin coin4 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin4);
        y = 115;
        Coin coin6 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin6);
        ofoghiCoins(root, x, y);
    }

    public void ofoghiCoins(Group root, double x, double y) {
        y = 23;
        x = 55;
        Coin coin = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin);
        x = 75;
        Coin coin1 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin1);
        x = 95;
        Coin coin2 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin2);
        x = 115;
        Coin coin3 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin3);
        x = 135;
        Coin coin0 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin0);
        x = 155;
        Coin coin4 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin4);
        x = 175;
        Coin coin5 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin5);
        x = 195;
        Coin coin6 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin6);
        x = 215;
        Coin coin7 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin7);
        y = 180;
        x = 55;
        Coin coin8 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin8);
        x = 75;
        Coin coin9 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin9);
        x = 95;
        Coin coin10 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin10);
        x = 115;
        Coin coin11 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin11);
        x = 135;
        Coin coin12 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin12);
        x = 155;
        Coin coin13 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin13);
        x = 175;
        Coin coin14 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin14);
        x = 195;
        Coin coin15 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin15);
        x = 215;
        Coin coin16 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin16);
        y = 23;
        x = 385;
        Coin coin17 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin17);
        x = 405;
        Stopper coin18 = new Stopper(x,y,Color.WHITE,root);
        coins.add(coin18);
        x = 425;
        Coin coin19 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin19);
        x = 445;
        Coin coin20 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin20);
        x = 465;
        Coin coin21 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin21);
        x = 485;
        Coin coin22 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin22);
        x = 505;
        Coin coin23 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin23);
        x = 525;
        Coin coin24 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin24);
        x = 545;
        Coin coin25 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin25);
        y = 180;
        x = 385;
        Coin coin26 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin26);
        x = 405;
        Coin coin27 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin27);
        x = 425;
        Coin coin28 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin28);
        x = 445;
        Coin coin29 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin29);
        x = 465;
        Coin coin30 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin30);
        x = 485;
        Coin coin31 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin31);
        x = 505;
        Coin coin32 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin32);
        x = 525;
        Coin coin33 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin33);
        x = 545;
        Coin coin34 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin34);
        x = 280;
        y = 23;
        Coin coin35 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin35);
        x = 300;
        Coin coin36 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin36);
        x = 320;
        Coin coin37 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin37);
        x = 70;
        y = 98;
        Coin coin38 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin38);
        x = 95;
       Stopper stopper = new Stopper(x,y,Color.WHITE,root);
       coins.add(stopper);
        x = 120;
        Coin coin39 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin39);
        x = 145;
        Coin coin40 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin40);
        x = 170;
        Coin coin41 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin41);
        x = 195;
        Coin coin42 = new Coin(x,y,Color.ORANGE,root);
        coins.add(coin42);
    }
    public ArrayList<Coin> getCoins() {
        return coins;
    }
}