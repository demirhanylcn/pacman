package Characters;

import Game.Animated;
import Inputs.Inputs;

public class RedGhost extends  GameCharacter {
    public RedGhost(int row, int column, int speed) {
        super(row, column, speed);
        animation.put(Inputs.DOWN, new String[]{ "src/resources/redDown.png" });
        animation.put(Inputs.RIGHT, new String[]{ "src/resources/redRight.png" });
        animation.put(Inputs.LEFT, new String[]{ "src/resources/redLeft.png" });
        animation.put(Inputs.UP, new String[]{ "src/resources/redUp.png" });
        animated = new Animated(animation.get(inputs), 0.25);
    }
}
