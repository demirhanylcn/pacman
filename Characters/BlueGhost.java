package Characters;
import Game.Animated;
import Inputs.Inputs;
public class BlueGhost extends GameCharacter{
    public BlueGhost(int row, int column, int speed) {
        super(row, column, speed);
        animation.put(Inputs.UP, new String[]{ "src/resources/blueUp.png"});
        animation.put(Inputs.DOWN, new String[]{ "src/resources/blueDown.png" });
        animation.put(Inputs.RIGHT, new String[]{ "src/resources/blueRight.png" });
        animation.put(Inputs.LEFT, new String[]{ "src/resources/blueLeft.png" });
        animated = new Animated(animation.get(inputs), 0.25);
    }
}