package game;

import com.badlogic.gdx.graphics.Texture;

public class GameObject {
    private String name;
    private int x, y, width, height, accelerationX = 0, accelerationY=0;
    private Collider collider;

    public GameObject(String name, int x, int y, int width, int height, Collider collider) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.collider = collider;
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
    private Direction direction = Direction.Front;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public enum State{
        Staying, Running, Attacking
    }

    public enum Direction{
        Left, Right, Front, Back
    }
}
