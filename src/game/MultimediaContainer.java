package game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.guardians.AnimationGuardian;
import game.guardians.TextureGuardian;

import java.util.HashMap;
import java.util.Map;

public class MultimediaContainer {

    //TODO private List sound;
    private Map<String, Animation> animations = new HashMap<String, Animation>();
    private Map<String, TextureRegion> textureRegions = new HashMap<String, TextureRegion>();

    public Map<String, Animation> getAnimations() {
        return animations;
    }

    public Map<String, TextureRegion> getTextureRegions() {
        return textureRegions;
    }

    public void loadAnimations(AnimationGuardian guardian)
    {
        //TODO loadAnimation
    }

    public void loadTextures(TextureGuardian guardian)
    {
        //TODO loadTextures
    }

    public void setAnimations(Map<String, Animation> animations) {
        this.animations = animations;
    }

    public void setTextureRegions(Map<String, TextureRegion> textureRegions) {
        this.textureRegions = textureRegions;
    }

    public Animation getAnimation(String name)
    {
        //TODO getAnimation
        return null;
    }

    public TextureRegion getTexture(String name)
    {
        //TODO getTexture
        return textureRegions.get(name);
    }

}
