package game;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;

public class Main {
    public static void main(String[] args) {
        Texture.setEnforcePotImages(false);
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 480;
        config.vSyncEnabled = true;
        new LwjglApplication(new MyGame(), config);
    }
}
