package Characters;


import Game.Animated;
import Game.GameModel;
import Inputs.Inputs;

public class Pacman extends GameCharacter {
    public Pacman(int row, int column, int speed) {
        super(row, column, speed);
        animation.put(Inputs.UP, new String[]{ "src/resources/up1.png","src/resources/up2.png" ,"src/resources/up3.png" });
        animation.put(Inputs.DOWN, new String[]{ "src/resources/down1.png","src/resources/down2.png" ,"src/resources/down3.png" });
        animation.put(Inputs.RIGHT, new String[]{ "src/resources/right1.png","src/resources/right2.png" ,"src/resources/right3.png" });
        animation.put(Inputs.LEFT, new String[]{ "src/resources/left1.png","src/resources/left2.png" ,"src/resources/left3.png" });
        animated = new Animated(animation.get(inputs), 0.25);
    }

    @Override
    public void update(GameModel model) {
        lastMillisecondsUpdate = System.currentTimeMillis();
        int newRow = getRow();
        int newColumn = getColumn();

        switch (getInputs()) {
            case Inputs.UP -> newRow--;
            case Inputs.DOWN -> newRow++;
            case Inputs.LEFT -> newColumn--;
            case Inputs.RIGHT -> newColumn++;
        }
        if(newColumn==-1){
            this.column = model.getBoard().length-1;
            return;
        }
        if(newColumn==model.getBoard().length){
            this.column = 0;
            return;
        }
        if (model.getBoard()[newRow][newColumn].isMovable()) {
            setColumn(newColumn);
            setRow(newRow);
        }
    }


}
