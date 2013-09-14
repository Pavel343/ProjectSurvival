package game.guardians;

import java.util.LinkedList;

public interface Guardian {
    public void parse(LinkedList<String> strings);
    public Object create(String name, int x, int y);



    public class T{
        private LinkedList<String> params;
        public void putParam(){//TODO положить параметр
        }
        public String getParam(){//TODO вернуть параметр
            return null;}
    }
}
