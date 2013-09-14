package game.guardians;

import game.MultimediaContainer;
import game.objects.BackgroundCell;
import game.objects.Creature;
import game.objects.MapObject;

public class MainGuardian {
    private Guardian            creatureGuardian;
    private Guardian            mapObjectGuardian;
    private Guardian            backgroundGuardian;
    private MultimediaContainer multimediaContainer;

    public MainGuardian(Guardian creatureGuardian, Guardian mapObjectGuardian, Guardian backgroundGuardian, MultimediaContainer multimediaContainer) {
        this.creatureGuardian = creatureGuardian;
        this.mapObjectGuardian = mapObjectGuardian;
        this.backgroundGuardian = backgroundGuardian;
        this.multimediaContainer = multimediaContainer;
    }

    public MultimediaContainer getMultimediaContainer() {
        return multimediaContainer;
    }

    public void setMultimediaContainer(MultimediaContainer multimediaContainer) {
        this.multimediaContainer = multimediaContainer;
    }

    public Guardian getCreatureGuardian() {
        return creatureGuardian;
    }

    public void setCreatureGuardian(Guardian creatureGuardian) {
        this.creatureGuardian = creatureGuardian;
    }

    public Guardian getMapObjectGuardian() {
        return mapObjectGuardian;
    }

    public void setMapObjectGuardian(Guardian mapObjectGuardian) {
        this.mapObjectGuardian = mapObjectGuardian;
    }

    public Guardian getBackgroundGuardian() {
        return backgroundGuardian;
    }

    public void setBackgroundGuardian(Guardian backgroundGuardian) {
        this.backgroundGuardian = backgroundGuardian;
    }

    public Creature createCreature(String name, int x, int y)
    {
        return (Creature)creatureGuardian.create(name, x, y);
    }

    public MapObject createMapObject(String name, int x, int y)
    {
        return (MapObject)mapObjectGuardian.create(name, x, y);
    }

    public BackgroundCell createBackgroundCell(String name, int x, int y)
    {
        return (BackgroundCell) backgroundGuardian.create(name, x,y);
    }
}
