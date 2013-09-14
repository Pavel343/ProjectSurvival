package game.objects;

import game.Collider;
import game.World;

public class Creature extends GameObject{
    public Creature(String name, int x, int y, int width, int height, Collider collider) {
        super(name, x, y, width, height, collider);
    }

    @Override
    public void updateCurrFrame(float stateFrame) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    class AI{
        private World world=null;
        private GameObject target=null;

        AI(World world) {
            this.world = world;
        }

        public void think()
        {

        }
    }
}
