package Characters;

import Game.Animated;
import Inputs.Inputs;

public class OrangeGhost  extends GameCharacter{
    public OrangeGhost(int row, int column, int speed) {
        super(row, column, speed);
        animation.put(Inputs.UP, new String[]{ "src/resources/orangeUp.png"});
        animation.put(Inputs.DOWN, new String[]{ "src/resources/orangeDown.png" });
        animation.put(Inputs.RIGHT, new String[]{ "src/resources/orangeRight.png" });
        animation.put(Inputs.LEFT, new String[]{ "src/resources/orangeLeft.png" });
        animated = new Animated(animation.get(inputs), 0.25);
    }
}
