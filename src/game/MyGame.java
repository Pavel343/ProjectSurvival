package game;

import com.badlogic.gdx.Game;
import game.guardians.ConfigLoader;
import game.guardians.MainGuardian;

public class MyGame extends Game {
    //private MainGuardian mainGuardian = null;



    @Override
    public void create() {
        ConstContainer.configLoader = new ConfigLoader("cfg/MainConfig.txt");
        ConstContainer.mainGuardian =(ConstContainer.configLoader).getMainGuardian();

        this.setScreen(new TestScreen());
    }
}
