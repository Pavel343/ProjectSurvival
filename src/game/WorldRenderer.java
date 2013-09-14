package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import game.objects.GameObject;
import game.objects.Hero;

public class WorldRenderer {

    private World world;
    private TextureRegion text1,tree, hero;

    private TextureRegion walkSheet;
    ShapeRenderer debugRenderer = new ShapeRenderer();
    OrthographicCamera camera = new OrthographicCamera(800,480);

    private TextureRegion stayingLeft, stayingRight, stayingFront, stayingBack;

    Hero heroObject;
    float stateTime=0f;

    public WorldRenderer(World world)
    {
        this.world = world;
        heroObject = (Hero)world.objects.get(0);
        loadTextures();

    }



    public void render(SpriteBatch batch, float v)
    {

        stateTime += Gdx.graphics.getDeltaTime();




        for (int i= 0; i<world.back_height;i++)
            for (int j=0; j<world.back_width;j++)
                if(world.back[i][j]==1)
                    batch.draw(text1, world.size*j, world.size*i, world.size, world.size);

        for(GameObject object : world.objects)
        {
            if(object.getName().equals("Hero"))
            ((Hero)object).updateCurrFrame(stateTime);
            else
                object.updateCurrFrame(stateTime);
            batch.draw(getTextureByName(object.getName()), object.getX(), object.getY(), object.getWidth(), object.getHeight());
        }
    }

    public TextureRegion getTextureByName(String name)
    {
        if(name.equals("Tree"))
            return tree;
        if(name.equals("Hero"))
        {
            System.out.println("=============================================  "+GameObject.State.Staying.toString());
            return heroObject.getCurrFrame();
            /*switch (heroObject.getDirection()){
                case Front:
                    return heroObject.getAccelerationX()==0&&heroObject.getAccelerationY()==0?stayingFront:currentFrameFront;//stayingFront;
                case Back:
                    return heroObject.getAccelerationX()==0&&heroObject.getAccelerationY()==0?stayingBack: currentFrameBack;
                case Left:
                    return heroObject.getAccelerationX()==0&&heroObject.getAccelerationY()==0?stayingLeft: currentFrameLeft;
                case Right:
                    return heroObject.getAccelerationX()==0&&heroObject.getAccelerationY()==0?stayingRight:currentFrameRight;
            }*/
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
        text1 = new TextureRegion(new Texture("img/1.png"));
        hero = new TextureRegion(new Texture("img/hero.png"));
        tree = new TextureRegion(new Texture("img/tree.png"));

        heroObject.walkFront = new TextureRegion[4];
        heroObject.walkFront[0] = new TextureRegion(new Texture("img/walking-front0.png"));
        heroObject.walkFront[1] = new TextureRegion(new Texture("img/walking-front1.png"));
        heroObject.walkFront[2] = new TextureRegion(new Texture("img/walking-front2.png"));
        heroObject.walkFront[3] = new TextureRegion(new Texture("img/walking-front3.png"));

        heroObject.walkBack = new TextureRegion[4];
        for(int i=0;i<4;i++)
            heroObject.walkBack[i] = new TextureRegion(new Texture("img/walking-back"+i+".png"));
        heroObject.walkLeft = new TextureRegion[4];
        for(int i=0;i<4;i++)
            heroObject.walkLeft[i] = new TextureRegion(new Texture("img/walking-left"+i+".png"));
        heroObject.walkRight = new TextureRegion[4];
        for(int i=0;i<4;i++)
            heroObject.walkRight[i] = new TextureRegion(new Texture("img/walking-right"+i+".png"));

        heroObject.walkAnimationFront = new Animation(0.1f, heroObject.walkFront);
        heroObject.walkAnimationBack = new Animation(0.1f, heroObject.walkBack);
        heroObject.walkAnimationLeft = new Animation(0.1f, heroObject.walkLeft);
        heroObject.walkAnimationRight = new Animation(0.1f, heroObject.walkRight);


        heroObject.stayingBack = new TextureRegion(new Texture("img/staying-back.png"));
        heroObject.stayingFront = new TextureRegion(new Texture("img/staying-front.png"));
        heroObject.stayingLeft = new TextureRegion(new Texture("img/staying-left.png"));
        heroObject.stayingRight = new TextureRegion(new Texture("img/staying-right.png"));



    }
}
