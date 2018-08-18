import java.awt.*;
import javax.swing.*;


public class Main extends JFrame {
    private JPanel Container;
    private Game game;
    //Constructor
    public Main() {
        setTitle("Dongeon Hunter");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a Container for Panels and set Container to CardLayout
        Container = new JPanel(new CardLayout());
        game = new Game();

        //Create Panels and add to Container, treat each panel as a card.
        MenuPanel menuPanel = new MenuPanel(game,Container);
        GamePanel gamePanel = new GamePanel(game,Container);
        Container.add(menuPanel, "Menu");
        Container.add(gamePanel, "Game");

        //Set BorderLayout
        getContentPane().add(Container, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Main();
    }
}