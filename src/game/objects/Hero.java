package game.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.Collider;
import game.objects.GameObject;

public class Hero  extends GameObject {

    public TextureRegion stayingFront;
    public TextureRegion stayingBack;
    public TextureRegion stayingLeft;
    public TextureRegion stayingRight;

    public TextureRegion walkingFront;
    public TextureRegion walkingBack;
    public TextureRegion walkingLeft;
    public TextureRegion walkingRight;

    public Animation walkAnimationFront;
    public Animation walkAnimationBack;
    public Animation walkAnimationLeft;
    public Animation walkAnimationRight;

    public TextureRegion[] walkFront;
    public TextureRegion[] walkBack;
    public TextureRegion[] walkLeft;
    public TextureRegion[] walkRight;



    public Hero(String name, int x, int y, int width, int height, Collider collider) {
        super(name, x, y, width, height, collider);
    }

    @Override
    public void updateCurrFrame(float stateTime)
    {
        System.out.println("updateCurrFrame "+stateTime);

        /*walkingFront=walkAnimationFront.getKeyFrame(stateTime,true);
        walkingBack= walkAnimationBack. getKeyFrame(stateTime,true);
        walkingLeft= walkAnimationLeft. getKeyFrame(stateTime,true);
        walkingRight=walkAnimationRight.getKeyFrame(stateTime,true);*/

        switch (getState()){

                case Staying:
                    System.out.println("State Staying");
                    switch (direction)
                    {
                        case Front: currFrame = stayingFront;break;
                        case Back:  currFrame = stayingBack;break;
                        case Left:  currFrame = stayingLeft;break;
                        case Right: currFrame = stayingRight;break;
                    }
                    break;
            case Running:
                System.out.println("State Running");
                switch (direction)
                {
                    case Front:currFrame=walkAnimationFront.getKeyFrame(stateTime,true);break;
                    case Back:currFrame=walkAnimationBack. getKeyFrame(stateTime,true);break;
                    case Left:currFrame=walkAnimationLeft. getKeyFrame(stateTime,true);break;
                    case Right:currFrame=walkAnimationRight.getKeyFrame(stateTime,true);break;
                }
                break;
                case Attacking:
                    System.out.println("Пиздец");
                    //TODO добавить атаку
                    break;
        }
    }
}
