package game.objects;

import game.Collider;

public class BackgroundCell extends GameObject {
    public BackgroundCell(String name, int x, int y, int width, int height, Collider collider) {
        super(name, x, y, width, height, collider);
    }

    @Override
    public void updateCurrFrame(float stateFrame) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
