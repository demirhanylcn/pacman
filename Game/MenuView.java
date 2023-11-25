package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuView extends JFrame {
    private GameController gameController;
    private ScoreController scoreController;
    public MenuView(GameController gameController, ScoreController scoreController){
        this.gameController = gameController;
        this.scoreController = scoreController;
        setTitle("Pac-Man");
        setResizable(false);
        setVisible(true);

        setSize(1261, 720);
        Image background = getToolkit().createImage("src/resources/backgroundpacman.jpg");
        Image startGame = getToolkit().createImage("src/resources/start.png");
        Image scores = getToolkit().createImage("src/resources/high.png");
        Image exit = getToolkit().createImage("src/resources/exit.png");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(1);
            }
        });
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, this);
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10, 10, 10, 10);
        JButton startButton= customButton(startGame);
        startButton.addActionListener(e -> this.gameController.showGame());
        JButton scoresButton = customButton(scores);
        scoresButton.addActionListener(e-> this.scoreController.showScore());
        JButton exitButton = customButton(exit);
        exitButton.addActionListener(e-> System.exit(1));
        gbc.gridy=0;
        panel.add(startButton,gbc);
        gbc.gridy=1;
        panel.add(scoresButton,gbc);
        gbc.gridy=2;
        panel.add(exitButton,gbc);
        gbc.gridy=3;
        getContentPane().add(panel);
    }
    public void showMenu(){
        setVisible(true);
    }
    private JButton customButton(Image image){
        JButton button= new JButton();
        button.setIcon(new ImageIcon(image));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }
}
