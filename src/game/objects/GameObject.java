package game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.Collider;

public abstract class GameObject {
    private String name;
    private int x, y, width, height, accelerationX = 0, accelerationY=0;
    private Collider collider;
    public TextureRegion currFrame;
    public float seed;

    public GameObject(String name, int x, int y, int width, int height, Collider collider) {
        seed = Gdx.graphics.getDeltaTime();
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.collider = collider;
    }

    public abstract void updateCurrFrame(float stateFrame);


    public TextureRegion getCurrFrame() {
        return currFrame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccelerationX() {
        return accelerationX;
    }

    public void setAccelerationX(int accelerationX) {
        this.accelerationX = accelerationX;
    }

    public int getAccelerationY() {
        return accelerationY;
    }

    public void setAccelerationY(int accelerationY) {
        this.accelerationY = accelerationY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Collider getCollider() {
        return collider;
    }

    private State state =  State.Staying;
    protected Direction direction = Direction.Front;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println(name+"||"+state);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public enum State{
        Staying, Running, Attacking;
        public boolean Animated(State state)
        {
            switch (state)
            {
                case Staying:
                    return false;
                case Running:
                    return true;
                case Attacking:
                    return true;
            }
            return false;
        }
    }

    public enum Direction{
        Left, Right, Front, Back
    }

    public TextureRegion getTexture(){
        return currFrame;
        //TODO сделать возвращение текстуры
    }

    public void updateTexture(){
        //TODO сделать обновление текстуры
    }
}
