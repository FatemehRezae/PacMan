package ir;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Handler {
    private static Random random = new Random();
    private int stopper = 0;
    private Label label;
    private BlueGhost blueGhost;
    private RedGhost redGhost;
    private PinkGhost pinkGhost;
    private CyanGhost cyanGhost;
    private PacMan pacMan;
    private AnimationTimer animationTimer;
    private ArrayList<Coin> coins;

    public Handler() {
        pacMan = new PacMan();
    }

    public void start(Group root, Scene scene, ArrayList<Coin> coins, Stage stage) {
        this.coins = coins;
        root.getChildren().add(pacMan.getPacMan());
        pacMan.setLife(2);
        blueGhost = new BlueGhost(23.0, 52.0, root, 0.8, 8);
        pinkGhost = new PinkGhost(575.0, 170.0, root, 2, 8);
        redGhost = new RedGhost(247.0, 14.0, root, 2, 8);
        cyanGhost = new CyanGhost(300.0, 142.0, root, 1.5, 8);
        label = new Label("0");
        root.getChildren().add(label);
        label.setTranslateY(91.5);
        label.setTranslateX(294.5);
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (stopper == 0) {
                    cyanGhost.move(pacMan.getPacMan());
                    if (cyanGhost.hitPacMan(pacMan.getPacMan()))
                        checkPacMan(root, stage, scene);
                    redGhost.move(pacMan.getPacMan());
                    if (redGhost.hitPacMan(pacMan.getPacMan()))
                        checkPacMan(root, stage, scene);
                    pinkGhost.move(pacMan.getPacMan());
                    if (pinkGhost.hitPacMan(pacMan.getPacMan()))
                        checkPacMan(root, stage, scene);
                    blueGhost.move(pacMan.getPacMan());
                    if (blueGhost.hitPacMan(pacMan.getPacMan()))
                        checkPacMan(root, stage, scene);

                } else stopper--;
            }
        };
        animationTimer.start();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT) {
                    pacMan.left();
                    eatenByPacMan(root,root, stage,scene);
                } else if (keyEvent.getCode() == KeyCode.UP) {
                    pacMan.up();
                    eatenByPacMan(root, root, stage,scene);
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    pacMan.right();
                    eatenByPacMan(root,root, stage,scene);
                } else if (keyEvent.getCode() == KeyCode.DOWN) {
                    pacMan.down();
                    eatenByPacMan(root, root, stage,scene);
                }

            }
        });
    }

    public void checkPacMan(Group group, Stage stage, Scene sc) {
        pacMan.setLife(pacMan.getLife()-1);
        if (pacMan.getLife() == 0) {
            animationTimer.stop();
            setOver(group, stage, "Game Over!",sc);
        } else {
            int score = pacMan.getScore();
            Paint color = pacMan.getColor();
            group.getChildren().remove(pacMan.getPacMan());
            pacMan = new PacMan();
            pacMan.getPacMan().setFill(color);
            group.getChildren().add(pacMan.getPacMan());
            pacMan.setScore(score);
        }
    }

    public static Random getRandom() {
        return random;
    }


    public void setOver(Group group, Stage primaryStage, String s,Scene scene) {
        group.getChildren().clear();
        Text text = new Text(290, 70, s);
        if (s.equals("Game Over!"))
            text.setFill(Color.RED);
        else text.setFill(Color.GREEN);
        group.getChildren().add(text);
        pacMan = new PacMan();
        Button start = new Button("Start");
        Button end = new Button("Exit");
        MenuItem yellow = new MenuItem("Yellow");
        MenuItem purple = new MenuItem("purple");
        MenuItem deepPink = new MenuItem("deep pink");
        MenuButton menuButton = new MenuButton("PacMan Color", null, yellow, purple, deepPink);
        MenuItem black = new MenuItem("black");
        MenuItem darkGrey = new MenuItem("dark grey");
        MenuButton menuButton1 = new MenuButton("background Color", null, black, darkGrey);
        start.setTranslateY(100);
        start.setTranslateX(300);
        end.setTranslateY(130);
        end.setTranslateX(302.5);
        menuButton.setTranslateX(330);
        menuButton.setTranslateY(160);
        menuButton1.setTranslateX(200);
        menuButton1.setTranslateY(160);
        group.getChildren().addAll(start,menuButton,end,menuButton1);
        darkGrey.setOnAction(actionEvent ->{
            scene.setFill(Color.DARKGREY);
        } );
        black.setOnAction(actionEvent -> {
            scene.setFill(Color.BLACK);
        });
        purple.setOnAction(actionEvent -> {
            getPacMan().setFill(Color.PURPLE);
        });
        deepPink.setOnAction(actionEvent -> {
            getPacMan().setFill(Color.DEEPPINK);
        });
        start.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    group.getChildren().removeAll(end, menuButton, start, menuButton1, text);
                    MapMaker mapMaker = new MapMaker(group);
                    start(group, scene, mapMaker.getCoins(), primaryStage);
                }
            }
        });
        end.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    primaryStage.close();
                }
            }
        });

    }

    public void eatenByPacMan(Group root, Group group, Stage primSt,Scene sc) {
        for (int i = 0; i < coins.size(); i++) {
            if (circlesTouch(pacMan.getPacMan(), coins.get(i).getCircle()) == 1) {
                pacMan.addSc();
                label.setText(Integer.toString(pacMan.getScore()));
                if (coins.get(i).getColor().equals(Color.WHITE)) {
                    stopper = 500;
                    root.getChildren().remove(coins.get(i).getCircle());
                    coins.remove(coins.get(i));
                } else if (coins.get(i).getColor().equals(Color.GREEN)) {
                    root.getChildren().remove(coins.get(i).getCircle());
                    coins.remove(coins.get(i));
                    if (coins.size() <= 5) {
                        for (int j = 0; j < coins.size(); j++) {
                            root.getChildren().remove(coins.get(j).getCircle());
                            coins.remove(coins.get(j));
                        }
                    } else {
                        for (int j = 0; j < 5; j++) {
                            int r = random.nextInt(coins.size());
                            root.getChildren().remove(coins.get(r).getCircle());
                            coins.remove(coins.get(r));
                        }

                    }
                } else if (coins.get(i).getColor().equals(Color.ORANGE)) {
                    root.getChildren().remove(coins.get(i).getCircle());
                    coins.remove(coins.get(i));
                } else if (coins.get(i).getColor().equals(Color.BROWN.desaturate())) {
                    root.getChildren().remove(coins.get(i).getCircle());
                    coins.remove(coins.get(i));
                    int p = 0;
                    int x;
                    int y;
                    while (p < 5) {
                        x = random.nextInt(580) + 11;
                        y = random.nextInt(180) + 11;
                        if (PacMan.move(x, y, 4)) {
                            coins.add(new Coin(x, y, Color.ORANGE, root));
                            p++;
                        }
                    }

                }
            }
        }
        if (coins.isEmpty()) {
            animationTimer.stop();
            setOver(group, primSt, "congratulations!!\n" + "  You Won!!", sc);
        }
    }

    public Circle getPacMan() {
        return pacMan.getPacMan();
    }

    public static int circlesTouch(Circle circle, Circle otherCircle) {
        double distance = (circle.getCenterX() - otherCircle.getCenterX()) * (circle.getCenterX() - otherCircle.getCenterX()) +
                (circle.getCenterY() - otherCircle.getCenterY()) * (circle.getCenterY() - otherCircle.getCenterY());
        double radius = circle.getRadius() + otherCircle.getRadius();
        radius = Math.pow(radius, 2);
        if (distance <= radius)
            return 1;
        else return 0;
    }
}
