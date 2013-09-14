package game.guardians;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TextureGuardian implements  Guardian{

    Map<String, TextureRegion> textures = new HashMap<String, TextureRegion>();

    public Map<String, TextureRegion> getTextures() {
        return textures;
    }

    @Override
    public void parse(LinkedList<String> strings) {
        Iterator iterator = strings.iterator();
        String s=null;
        String[] arrS= null;
        while(iterator.hasNext())
        {
            s = (String)iterator.next();
            arrS = s.split(":");
            textures.put(arrS[0],new TextureRegion(new Texture(arrS[1])));
        }
    }

    @Override
    public Object create(String name, int x, int y) {
        return textures.get(name);
    }
}
