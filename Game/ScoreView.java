package Game;

import javax.swing.*;

public class ScoreView extends JFrame{
    private final ScoreModel model;
    private final JList<String> list;

    public ScoreView(ScoreModel model){
        this.model=model;
        JScrollPane scroll = new JScrollPane();
        list = new JList<>();
        scroll.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        add(scroll);
        setSize(300,300);
        setTitle("Scores");
    }
    public void updateScores(){
        DefaultListModel<String> modelList = new DefaultListModel<>();
        for (int i = 0; i < model.getScores().size(); i++) {
            modelList.addElement(model.getScores().get(i).toString());
        }
        list.setModel(modelList);
    }
    public void showScore() {
        setVisible(true);
    }
}
