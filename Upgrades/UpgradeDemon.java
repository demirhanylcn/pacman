package Upgrades;

import Characters.Pacman;
import Game.GameModel;
import Upgrades.Upgrade;

public class UpgradeDemon extends Upgrade {
    public UpgradeDemon(){
        duration = 5000;
        image = "src/resources/demon.png";
    }
    @Override
    public void start(GameModel model) {
        Pacman pacman = model.getPacman();
        pacman.setSpeed(pacman.getSpeed() / 2);
    }

    @Override
    public void reset(GameModel model) {
        Pacman pacman = model.getPacman();
        pacman.setSpeed(pacman.getSpeed() * 2);
    }
}
