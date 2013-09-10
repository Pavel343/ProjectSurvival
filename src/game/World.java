package game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;

public class World {
    public int back_width=10, back_height=10;
    public int size = 64;
    public int[][] back ;
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();


    public LinkedList<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(LinkedList<GameObject> objects) {
        this.objects = objects;
    }

    public boolean changed=true;

    public World()
    {

        back =new int[back_height][back_width];
        for (int i= 0; i<back_height;i++)
            for (int j=0; j<back_width;j++)
                back[i][j] = 1;

        objects.add(new Hero("Hero",10,100,32,32, new Collider(10,100,32,10)));
        objects.add(new Hero("Hero",10,10,32,32, new Collider(9,10,32,10)));

        objects.add(new GameObject("Tree",200,100,64,105, new Collider(216,100,32,32)));
        objects.add(new GameObject("Tree",300,100,64,105, new Collider(316,100,32,32)));
        objects.add(new GameObject("Tree",350,190,64,105, new Collider(362,190,32,32)));
    }
}
