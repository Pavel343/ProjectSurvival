package game.guardians;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import game.MultimediaContainer;
import java.util.*;

public class AnimationGuardian implements Guardian {

    private MultimediaContainer multimediaContainer;
    private Map<String,AnimationConfig> animationsConfigs = new HashMap<String, AnimationConfig>();
    private Map<String,Animation> animations = new HashMap<String, Animation>();

    public AnimationGuardian(MultimediaContainer multimediaContainer) {
        this.multimediaContainer = multimediaContainer;
    }

    public Map<String, Animation> getAnimations() {
        return animations;
    }

    @Override
    public void parse(LinkedList<String> strings) {
        Iterator<String> iterator = strings.iterator();
        String s = null;
        String name=null;


        AnimationConfig animationConfig = null;
        while(iterator.hasNext())
        {
            s = iterator.next();
            if(s.equals("begin")) {name = null; animationConfig = new AnimationConfig(); continue;}
            String[] strs = s.split(":");

            if(name==null) {name = strs[1]; animationsConfigs.put(name,animationConfig);}

            animationConfig.putParam(strs[0],strs[1]);
        }
        parseToAnimationObjects();

    }

    private void parseToAnimationObjects() {

        Animation animation =null;
        Array<TextureRegion> array = null;
        AnimationConfig animationConfig=null;

        for (String s: animationsConfigs.keySet())
        {
            animationConfig = animationsConfigs.get(s);

            array = new Array<TextureRegion>();
            for(int i=0;i<Integer.parseInt(animationConfig.getParam("frames"));i++)
                array.add(multimediaContainer.getTexture(animationConfig.getParam("texture"+i)));

            animation = new Animation(Float.parseFloat(animationConfig.getParam("speed")),array);
            animations.put(animationConfig.getParam("name"),animation);
        }

        multimediaContainer.setAnimations(animations);

    }

    @Override
    public Object create(String name, int x, int y) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    class AnimationConfig{

        private  Map<String, String> params = new HashMap<String, String>();

        public String getParam(String name)
        {
            System.out.println(name+":"+params.containsKey(name));
            return params.get(name);
        }

        public void putParam(String name, String object ){
            params.put(name, object);
        }
    }
}
