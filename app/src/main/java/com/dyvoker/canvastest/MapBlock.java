package com.dyvoker.canvastest;

/**
 * Class for in-game map block_send (send, water, grass, etc)
 */

public class MapBlock extends DrawableOnMap {
    public static final MapBlock SEND = new MapBlock(R.drawable.block_send);
    public static final MapBlock GRASS = new MapBlock(R.drawable.block_grass);
    public static final MapBlock DIRT = new MapBlock(R.drawable.block_dirt);
    public static final MapBlock ICE = new MapBlock(R.drawable.block_ice);

    private MapBlock(int drawableResourceId) {
        super(drawableResourceId);
    }

}
