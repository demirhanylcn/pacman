package Game;

import Cells.Cell;
import Inputs.Inputs;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameView  extends JFrame {
    private GameController controller;
    private final JTable gameBoardTable;
    private final GameBoardTableModel tableModel;
    private final GameModel model;
    private final JLabel score;
    private final JPanel bottomPanel;
    public GameView(GameModel model){
        this.model = model;
        this.bottomPanel = new JPanel(new BorderLayout());
        updateBottomPanel();
        setTitle("Pac-Man Game");
        JPanel upPanel = new JPanel(new FlowLayout());
        score = new JLabel("", SwingConstants.CENTER);
        score.setForeground(Color.WHITE);
        upPanel.add(score);
        upPanel.setBackground(Color.BLACK);
        updateScore();
        tableModel = new GameBoardTableModel(model.board);
        gameBoardTable = new JTable(tableModel);
        gameBoardTable.setDefaultRenderer(Object.class, new GameTableRenderer(model.getPlayers()));
        int blockSize = 30;
        gameBoardTable.setRowHeight(blockSize);
        gameBoardTable.setFocusable(false);
        gameBoardTable.setShowGrid(false);
        gameBoardTable.setShowVerticalLines(false);
        gameBoardTable.setShowHorizontalLines(false);
        gameBoardTable.setRowMargin(0);
        gameBoardTable.getColumnModel().setColumnMargin(0);
        setLayout(new BorderLayout());
        for (int i = 0; i < gameBoardTable.getColumnCount(); i++) {
            TableColumn column = gameBoardTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(blockSize);
        }
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        controller.setPacmanDirection(Inputs.UP);
                    }
                    case KeyEvent.VK_DOWN -> {
                        controller.setPacmanDirection(Inputs.DOWN);
                    }
                    case KeyEvent.VK_LEFT -> {
                        controller.setPacmanDirection(Inputs.LEFT);
                    }
                    case KeyEvent.VK_RIGHT -> {
                        controller.setPacmanDirection(Inputs.RIGHT);
                    }
                    default -> {

                    }
                }
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int down = KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK;
                if ((e.getModifiersEx() & down) == down && (e.getKeyCode() == KeyEvent.VK_Q))
                    controller.stopGame();
            }
        });
        add(upPanel, BorderLayout.NORTH);
        add(gameBoardTable, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setMinimumSize(new Dimension(600, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to finish the game?", "Finish Game?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    controller.stopGame();
                }
            }
        });
        pack();
    }
    public void repaintBoard(){
        gameBoardTable.repaint();
    }
    public void showGame(){
        setVisible(true);
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void setCellValue(Cell cell, int row, int column){
        tableModel.setValueAt(cell, row, column);
    }
    public void updateScore(){
        score.setText("Score : "+model.getScore());
    }
    public void updateBottomPanel(){
        bottomPanel.removeAll();
        bottomPanel.revalidate();
        bottomPanel.repaint();
        JPanel health = new JPanel(new FlowLayout(FlowLayout.LEADING));

        health.setBackground(Color.BLACK);
        bottomPanel.setBackground(Color.BLACK);
        for (int i = 0; i < model.getHealth(); i++){
            health.add(new JLabel(new ImageIcon("src/resources/pacman.png")));
        }
        bottomPanel.add(health, BorderLayout.WEST);
        JPanel bonuses = new JPanel(new FlowLayout());
        bonuses.setBackground(Color.BLACK);
        bottomPanel.setBackground(Color.BLACK);
        for (int i = 0; i < model.getUpgrades().size(); i++){
            bonuses.add(new JLabel(new ImageIcon(model.getUpgrades().get(i).getImage())));
        }
        bottomPanel.add(bonuses, BorderLayout.EAST);

    }

    public String askName() {
        return JOptionPane.showInputDialog("Enter your name");
    }
}
