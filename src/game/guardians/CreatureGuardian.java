package game.guardians;


import game.Collider;
import game.objects.Creature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class CreatureGuardian implements Guardian {

    private Map<String, CreatureConfig> creatures = new HashMap<String, CreatureConfig>();

    public Map<String, CreatureConfig> getCreatures() {
        return creatures;
    }

    @Override
    public void parse(LinkedList<String> strings) {
        Iterator<String> iterator = strings.iterator();
        String s = null;
        String name=null;


        CreatureConfig creatureConfig = null;
        while(iterator.hasNext())
        {
            s = iterator.next();
            if(s.equals("Begin")) {name = null; creatureConfig = new CreatureConfig(); continue;}
            String[] strs = s.split(":");

            if(name==null) {name = strs[1]; creatures.put(name,creatureConfig); continue;}

            creatureConfig.putParam(strs[0],strs[1]);
        }
    }

    @Override
    public Object create(String name, int x, int y) {
        CreatureConfig config = creatures.get(name);
        int width = Integer.parseInt(config.getParam("width")),
            height = Integer.parseInt((String)config.getParam("height")),
            colx = Integer.parseInt((String)config.getParam("colx")),
            coly = Integer.parseInt((String)config.getParam("coly")),
            colWidth = Integer.parseInt((String)config.getParam("colwidth")),
            colHeight = Integer.parseInt((String)config.getParam("colheight"));
        return new Creature(name, x,y,width,height,new Collider(colx+x,coly+y,colWidth, colHeight));
    }




    class CreatureConfig
    {

        Map<String, String> params = new HashMap<String, String>();

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
