package com.dyvoker.canvastest;

/**
 * Class for in-game map objects (blocks, trees, etc)
 */

public class MapObject {
    static MapObject BLOCK = new MapObject(R.drawable.block);
    static MapObject TREE = new MapObject(R.drawable.tree);
    private int pictureResource; //Picture of the object

    public MapObject(int pictureResource) {
        this.pictureResource = pictureResource;
    }

    public int getPictureResource() {
        return pictureResource;
    }
}
