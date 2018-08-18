package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.Main;
import model.Game;
import sun.plugin.com.event.COMEventHandler;


public class MenuPanel extends JPanel {
    private Game game;
    //Constructor
    public MenuPanel(Game g,JPanel Container) {
        this.game = g;

        //Add listener, Press space bar to play
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                    //Switch to game panel, Start game
                    CardLayout cardLayout = (CardLayout) Container.getLayout();
                    game.initNewGame();
                    cardLayout.show(Container, "Game");
                    // hard code index in order to get MainPanel without passing reference
                    GamePanel.MainPanel gamePanel = (GamePanel.MainPanel) ((JPanel) MenuPanel.this.getParent().getComponent(1)).getComponent(1);
                    gamePanel.start();
                    Container.revalidate();
                }
            }
        });
        this.setFocusable(true);
    }
}