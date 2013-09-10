package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.lwjgl.input.Keyboard;

public class TestScreen implements Screen {
    WorldRendererNew worldRenderer;
    WorldController worldController;
    SpriteBatch batch = new SpriteBatch();


    @Override
    public void render(float v) {

        worldController.update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        batch.begin();
        worldRenderer.render(batch, v);
        batch.end();
        worldRenderer.renderDebug();
    }

    @Override
    public void resize(int i, int i2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show() {
        World world = new World();
        worldRenderer = new WorldRendererNew(world);
        worldController = new WorldController(world);
        worldRenderer.loadTextures();

    }

    @Override
    public void hide() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resume() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void dispose() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
