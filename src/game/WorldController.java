package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import game.objects.GameObject;

import java.util.LinkedList;

public class WorldController {
    World world;
    boolean xChanged=false, yChanged=false;
    boolean xChanged2=false, yChanged2=false;
    GameObject hero;
    GameObject hero2;
    public WorldController(World world) {
        this.world = world;
        hero = world.objects.get(0);
        hero2 = world.objects.get(1);
    }

    public void update()
    {
        inputCheck();
        collisionsCheck();
        moveUpdate();

    }

    private void inputCheck() {
        xChanged = false;
        yChanged = false;


        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            hero.setAccelerationX(5);
            hero.setDirection(GameObject.Direction.Right);
            xChanged=true;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            hero.setAccelerationX(-5);
            hero.setDirection(GameObject.Direction.Left);
            xChanged = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            hero.setAccelerationY(5);
            hero.setDirection(GameObject.Direction.Back);
            yChanged = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            hero.setAccelerationY(-5);
            hero.setDirection(GameObject.Direction.Front);
            yChanged = true;
        }
        if(!yChanged)hero.setAccelerationY(0);
        if(!xChanged)hero.setAccelerationX(0);

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            hero2.setAccelerationX(5);
            hero2.setDirection(GameObject.Direction.Right);
            xChanged2=true;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            hero2.setAccelerationX(-5);
            hero2.setDirection(GameObject.Direction.Left);
            xChanged2 = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W))
        {
            hero2.setAccelerationY(5);
            hero2.setDirection(GameObject.Direction.Back);
            yChanged2 = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S))
        {
            hero2.setAccelerationY(-5);
            hero2.setDirection(GameObject.Direction.Front);
            yChanged2 = true;
        }
        if(!yChanged2)hero2.setAccelerationY(0);
        if(!xChanged2)hero2.setAccelerationX(0);
    }

    private void collisionsCheck()
    {
        if(yChanged || xChanged)
            for(GameObject object : world.objects)
            if(isCollision(hero.getCollider().getX()+hero.getAccelerationX(), hero.getCollider().getY()+hero.getAccelerationY(),hero.getCollider().getWidth(),hero.getCollider().getHeight(),
                           object.getCollider().getX(), object.getCollider().getY(), object.getCollider().getWidth(), object.getCollider().getHeight()))
            {
                if(hero==object)continue;
                if(hero.getAccelerationX()>0)hero.setAccelerationX(0);//hero.setAccelerationX(hero.getAccelerationX()+1);
                if(hero.getAccelerationX()<0)hero.setAccelerationX(0);//hero.setAccelerationX(hero.getAccelerationX()-1);
                if(hero.getAccelerationY()<0)hero.setAccelerationY(0);//hero.setAccelerationY(hero.getAccelerationY()-1);
                if(hero.getAccelerationY()>0)hero.setAccelerationY(0);//hero.setAccelerationY(hero.getAccelerationY()+1);
            }
    }

    private boolean isCollision(int x, int y, int w, int h,int x2, int y2, int w2, int h2)
    {
        boolean result = false;
        result |= isCollisionForRectangle(x,y,      x2,y2,w2,h2);
        result |= isCollisionForRectangle(x+w,y,    x2,y2,w2,h2);
        result |= isCollisionForRectangle(x,  y+h,  x2,y2,w2,h2);
        result |= isCollisionForRectangle(x+w,y+h,  x2,y2,w2,h2);
        return result;
    }

    private boolean isCollisionForRectangle(int x, int y, int x2, int y2, int w2, int h2)
    {
        boolean xYes = false, yYes = false;
        if(x>=x2 && x<=(x2+w2)) xYes = true;
        if(y>=y2 && y<=(y2+h2)) yYes = true;
        if(xYes&&yYes) System.out.println(x+"|| "+y+"|| "+y2+"|| "+x2+"|| "+w2+"|| "+h2+"|| ");
        return xYes&&yYes;
    }

    private void moveUpdate()
    {
        System.out.println("Мир изменен: "+world.changed);
        if(world.changed)
            world.setObjects(sortObjectList(world.objects));
        world.changed=false;
        for(GameObject object: world.objects)
        {
            //object.setState(GameObject.State.Staying);
            if(object.getAccelerationY()!=0 || object.getAccelerationX()!=0){
                world.changed=true;
                object.setState(GameObject.State.Running);
                System.out.println("Двинулся!");}
            else
            object.setState(GameObject.State.Staying);

            object.setX(object.getX()+object.getAccelerationX());
            object.setY(object.getY() + object.getAccelerationY());
            object.getCollider().setX(object.getCollider().getX()+object.getAccelerationX());
            object.getCollider().setY(object.getCollider().getY()+object.getAccelerationY());
        }
    }

    private LinkedList<GameObject> sortObjectList(LinkedList<GameObject> objects)
    {
        System.out.println("Сортировка!");
        boolean changed =true;
        Object[] arrObjects= null;
        arrObjects = objects.toArray();
        while(changed)
        {
            changed = false;

            for(int i =0; i<arrObjects.length-1; i++)
            {
                System.out.println("Итерация");
                if(((GameObject)arrObjects[i]).getY()<((GameObject)arrObjects[i+1]).getY())
                {
                    System.out.println("перестановка!y[i]:"+((GameObject)arrObjects[i]).getY()+"y[i+1]"+((GameObject)arrObjects[i+1]).getY());
                    Object temp = arrObjects[i];
                    System.out.println(((GameObject)temp).getY());
                    arrObjects[i]=arrObjects[i+1];
                    System.out.println(((GameObject)arrObjects[i]).getY());
                    arrObjects[i+1] = temp;
                    System.out.println(((GameObject)arrObjects[i+1]).getY());
                    changed = true;
                }
            }
        }
        LinkedList<GameObject> newObjects = new LinkedList<GameObject>();
        for(int i =0; i<arrObjects.length; i++)
        {
            newObjects.add((GameObject)arrObjects[i]);
        }
        return newObjects;
    }
}
