package game.guardians;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import game.MultimediaContainer;
import game.MyGame;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ConfigLoader {

    Map<String,String> applicationConfig = null;
    Map<String,String> unitConfig = null;
    Map<String,String> objectConfig = null;
    Map<String,String> animationConfig = null;
    Map<String,String> textureConfig = null;
    MainGuardian mainGuardian;

    public MainGuardian getMainGuardian() {
        return mainGuardian;
    }



    public static void main(String[] args) {
        Texture.setEnforcePotImages(false);
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 480;
        config.vSyncEnabled = true;
        new LwjglApplication(new MyGame(), config);

    }

    public ConfigLoader(String address) {
        applicationConfig = parseConfig(loadConfig(address));
        //unitConfig = unitParse(loadConfig(applicationConfig.get("unitConfig")));
        mainGuardian = new MainGuardian(new CreatureGuardian(),null,null, new MultimediaContainer());
        mainGuardian.getCreatureGuardian().parse(loadConfig(applicationConfig.get("unitConfig")));

        TextureGuardian textureGuardian = new TextureGuardian();
        textureGuardian.parse(loadConfig(applicationConfig.get("textureConfig")));


        mainGuardian.getMultimediaContainer().setTextureRegions(((TextureGuardian) textureGuardian).getTextures());

        AnimationGuardian animationGuardian = new AnimationGuardian(mainGuardian.getMultimediaContainer());
        animationGuardian.parse(loadConfig(applicationConfig.get("animationConfig")));
    }

    public LinkedList<String> loadConfig(String address)
    {
        File file = new File(address);
        BufferedReader bufferedReader = null;
        LinkedList<String> strings=null;
        try {
            InputStream stream = new FileInputStream(address);
            bufferedReader = new BufferedReader(new InputStreamReader(stream));

            strings = new LinkedList<String>();
            while(bufferedReader.ready())
                strings.add(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

   /* public Map<String,String> unitParse(LinkedList<String> strings)
    {
        Map<String, String> result=new HashMap<String, String>();
        Iterator<String> iterator = strings.iterator();
        String s = null;
        String name=null;
        while(iterator.hasNext())
        {
            s = iterator.next();
            if(s.equals("End;")) {name = null;continue;}
            String[] strs = s.split(":");

            if(name==null) {name = strs[1];continue;}


            result.put(name+"-"+strs[0],strs[1]);
        }
        return result;

    }
     */
    private Map<String,String> parseConfig(LinkedList<String> strings)
    {
        Map result = new HashMap();
        Iterator iterator = strings.iterator();
        String s = null;
        while(iterator.hasNext())
        {
            s = (String)iterator.next();
            String[] strs = s.split(":");
            result.put(strs[0],strs[1]);
        }
        return result;
    }


}
