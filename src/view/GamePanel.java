package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import enums.State;
import model.Game;
import structure.basic.Observer;
import structure.basic.GameObject;
import enums.Rotation;
import enums.Key;


//GamePanel contains two panels,
public class GamePanel extends JPanel{
    private Game game;

    //Constructor
    public GamePanel(Game g,JPanel Container) {
        this.setLayout(new BorderLayout());
        // this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.game = g;
        //Two views of game model
        MainPanel mainPanel = new MainPanel(game);
        SidePanel sidePanel = new SidePanel(game, Container);
        this.add(sidePanel, BorderLayout.EAST);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    //MainPanel is a observer of Game, receive updates from Game.
    public class MainPanel extends JPanel{
        private Game game;

        private Timer animationTimer;

        //player position offside;
        private int x, y;

        //player direction
        private Rotation rotation;

        //hp bar Offset
        private final int hpOffset = 5;

        // size of each block on the board
        private final int  blockSize = 40;

        private final int fps = 30;

        //Constructor
        public MainPanel(Game game) {
            this.game = game;
            this.x = 0;
            this.y = 0;
            setPreferredSize(new Dimension(600,600));
            setDoubleBuffered(true);

            // creates a thread pool with one thread as the fixed pool size
            ExecutorService pool = Executors.newFixedThreadPool(1);

            // Listen to user input, and passes the Task to the pool to execute user command
            addKeyListener(new KeyAdapter () {
                public void keyPressed(KeyEvent e) {
                    switch(e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            rotation = Rotation.up;
                            pool.execute(new Task(Key.up));
                            break;
                        case KeyEvent.VK_S:
                            rotation = Rotation.down;
                            pool.execute(new Task(Key.down));
                            break;
                        case KeyEvent.VK_A:
                            rotation = Rotation.left;
                            pool.execute(new Task(Key.left));
                            break;
                        case KeyEvent.VK_D:
                            rotation = Rotation.right;
                            pool.execute(new Task(Key.right));
                            break;
                    }
                }
            });
            this.animationTimer = new Timer(1000 / fps, event -> {
                this.repaint();
            });
            this.setFocusable(true);
        }

        public void start() {
            this.animationTimer.start();
            this.requestFocus();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw floor first
            drawFloor(g);
            drawBoard(g);
        }

        //Draw floor image
        private void drawFloor(Graphics g) {
            //Loop through the game board
            for (int i = 0; i < game.row; i++) {
                for (int j = 0; j < game.col; j++) {
                    g.drawImage(game.getFloorImage(i, j), j * blockSize, i * blockSize, null);
                }
            }
        }

        //Draw board
        private void drawBoard(Graphics g){
            //Loop through the game board
            for (int i = 0; i < Game.row; i++) {
                for (int j = 0; j < Game.col; j++) {
                    //Get block type
                    GameObject obj = game.getBlock(i, j);
                    if (obj == null) continue;
                    switch(obj.getTag()){
                        case player:
                            g.drawImage(obj.getSprite().getImage(),
                                    j * blockSize, i * blockSize, null);
                            drawHpBar(g, j * blockSize, i * blockSize - hpOffset,
                                    (int) (Math.round(blockSize * obj.getAttribute().getPercent())));

                            //draw moving animation
                            if(game.getState() == State.move){

                                switch(rotation) {
                                    case left:
                                        x -= 2;
                                    case right:
                                        x += 2;
                                    case up:
                                        y -= 2;
                                    case down:
                                        y += 2;
                                }
                                //if player moves one block,
                                if( x % blockSize == 0 && y % blockSize == 0){
                                    //reset player offset and notify game
                                    x = 0;
                                    y = 0;
                                    game.setState(State.idle);
                                }
                            }

                            break;

                        case enemy:
                            g.drawImage(obj.getSprite().getImage(),
                                    j * blockSize, i * blockSize, null);

                            drawHpBar(g, j * blockSize, i * blockSize - hpOffset,
                                    (int) (Math.round(blockSize * obj.getAttribute().getPercent())));
                            break;

                         default:
                             g.drawImage(obj.getSprite().getImage(),
                                     j * blockSize, i * blockSize, null);
                    }
                }
            }
        }


        //Draw battle animation
        private void drawPlayerBattle(Graphics g){

        }

<<<<<<< HEAD:src/view/GamePanel.java
        private void drawHpBar(Graphics g , int hpx, int hpy , int width){
            g.setColor(Color.black);
            g.fillRect(hpx, hpy, blockSize,2);
            g.setColor(Color.red);
            g.fillRect(hpx, hpy, width,2);
=======
        private void drawHpBar(Graphics g , int x, int y , int width){
            g.setColor(Color.red);
            g.fillRect(x, y, blockSize,2);
            g.setColor(Color.green\);
            g.fillRect(x, y, width,2);
>>>>>>> NewPotato:Src/view/GamePanel.java
        }

    }

    //SidePanel is a observer of Game, receive updates from Game.
    public class SidePanel extends JPanel implements Observer{
        private Game game;

        //Constructor
        public SidePanel(Game game ,JPanel Container) {
        }

        //Be called when there is something needs to be updated.
        public void update(Object observable) {
            this.repaint();
        }
    }
}