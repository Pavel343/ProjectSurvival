package game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {

    private World world;
    private Texture text1,tree, hero;
    ShapeRenderer debugRenderer = new ShapeRenderer();
    OrthographicCamera camera = new OrthographicCamera(800,480);

    private Texture stayingLeft, stayingRight, stayingFront, stayingBack;

    GameObject heroObject;

    public WorldRenderer(World world)
    {
        this.world = world;
        loadTextures();
        heroObject = world.objects.get(0);
    }

    public void render(SpriteBatch batch, float v)
    {
        for (int i= 0; i<world.back_height;i++)
            for (int j=0; j<world.back_width;j++)
                if(world.back[i][j]==1)
                    batch.draw(text1, world.size*j, world.size*i, world.size, world.size);

        for(GameObject object : world.objects)
        {
            batch.draw(getTextureByName(object.getName()), object.getX(), object.getY(), object.getWidth(), object.getHeight());
        }
    }

    public Texture getTextureByName(String name)
    {
        if(name.equals("Tree"))
            return tree;
        if(name.equals("Hero"))
        {
            switch (heroObject.getDirection()){
                case Front:
                    return stayingFront;
                case Back:
                    return stayingBack;
                case Left:
                    return stayingLeft;
                case Right:
                    return stayingRight;
            }
        }


        return null;
    }

    public void renderDebug()
    {
        //debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Rectangle);

        for(GameObject object: world.objects)
        {
            Rectangle rect = new Rectangle(object.getCollider().getX(),object.getCollider().getY(),object.getCollider().getWidth(), object.getCollider().getY());
            debugRenderer.setColor(1,0,0,1);
            debugRenderer.rect(object.getCollider().getX(),object.getCollider().getY(),object.getCollider().getWidth(), object.getCollider().getHeight());
        }

        debugRenderer.end();
    }

    public void loadTextures()
    {
        text1 = new Texture("img/1.png");
        hero = new Texture("img/hero.png");
        tree = new Texture("img/tree.png");
        stayingBack = new Texture("img/staying-back.png");
        stayingFront = new Texture("img/staying-front.png");
        stayingLeft = new Texture("img/staying-left.png");
        stayingRight = new Texture("img/staying-right.png");

    }
}
