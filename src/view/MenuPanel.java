import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Game;



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
                    cardLayout.show(Container, "Game");
                    game.initNewGame();
                    Container.revalidate();
                }
            }
        });
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
}