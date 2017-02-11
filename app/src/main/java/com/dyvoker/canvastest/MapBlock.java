package com.dyvoker.canvastest;

/**
 * Class for in-game map block (send, water, grass, etc)
 */

public class MapBlock extends DrawableOnMap {
    static MapBlock SEND = new MapBlock(R.drawable.block);

    private MapBlock(int drawableResourceId) {
        super(drawableResourceId);
    }

}