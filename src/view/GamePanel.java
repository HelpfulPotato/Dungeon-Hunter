import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;



//GamePanel contains two panels,
public class GamePanel extends JPanel{
    private Game game;

    //Constructor
    public GamePanel(Game g,JPanel Container) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.game = g;
        //Two views of game model
        MainPanel mainPanel = new MainPanel(game);
        SidePanel sidePanel = new SidePanel(game, Container);
        this.add(sidePanel);
        this.add(mainPanel);
    }

    //MainPanel is a observer of Game, receive updates from Game.
    public class MainPanel extends JPanel implements Observer {
        private Game game;

        //player position
        private int x, y;

        //hp bar Offset
        private final int hpOffset = 5;

        // size of each block on the board
        private final int  blockSize = 40;

        private final int fps = 30;

        //Constructor
        public MainPanel(Game game) {
        this.game = game;
        game.addObserver(this);
        setPreferredSize(new Dimension(600,600));
        setDoubleBuffered(true);
        //Listen to user input
        addKeyListener(new KeyAdapter () {
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_W:

                        break;
                    case KeyEvent.VK_S:

                        break;
                    case KeyEvent.VK_A:

                        break;
                    case KeyEvent.VK_D:

                        break;
                }
            }
        });

        this.setFocusable(true);
        this.requestFocusInWindow();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            switch (game.mode) {
                case Lost:
                    break;
                case Win:
                    break;
                case Idle:
                    //Loop through the game board
                    for (int i = 0; i < game.col; i++) {
                        for (int j = 0; j < game.row; j++) {
                            //Get block type
                            GameObject obj = game.getBlock(i,j);
                            //Draw  block based on block type
                            
                            //If block type is enemy or player, draw hp bar
                            drawHpBar(g,x * blockSize,y * blockSize - hpOffset,
                                    (int) (Math.round(blockSize * obj.getAttribute().getPercent())));
                        }
                    }
            }
            return;
        }


        private void drawHpBar(Graphics g , int x, int y , int width){
            g.setColor(Color.black);
            g.fillRect(x, y, blockSize,2);
            g.setColor(Color.red);
            g.fillRect(x, y, width,2);
        }

        //Be called when there is something needs to be updated.
        public void update(Object observable, GameEvent e) {

        }
    }

    //SidePanel is a observer of Game, receive updates from Game.
    public class SidePanel extends JPanel implements Observer{
        private Game game;

        //Constructor
        public SidePanel(Game game ,JPanel Container) {
        }

        //Be called when there is something needs to be updated.
        public void update(Object observable, GameEvent e) {
            this.repaint();
        }
    }
}
