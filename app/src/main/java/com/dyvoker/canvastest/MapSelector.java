package com.dyvoker.canvastest;

/**
 * Class for in-game map selector (for selecting block with objects)
 */

public class MapSelector extends DrawableOnMap {
    public static final MapSelector SIMPLE_SELECTOR = new MapSelector(R.drawable.selector_block);

    private MapSelector(int drawableResourceId) {
        super(drawableResourceId);
    }
}
