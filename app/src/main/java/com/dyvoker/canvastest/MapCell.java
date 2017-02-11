package com.dyvoker.canvastest;

/**
 * Class for map cell, it's consist of block and object on it
 */

public class MapCell {
    private MapBlock block;
    private MapObject object;
    private boolean isSelected = false;

    public MapCell() {
        this(null);
    }

    public MapCell(MapBlock block) {
        this(block, null);
    }

    public MapCell(MapBlock block, MapObject object) {
        this.block = block;
        setObject(object);
    }

    public void setBlock(MapBlock block) {
        this.block = block;
    }

    public void setObject(MapObject object) {
        if (block != null && this.object == null) { //can set object only on block ;)
            this.object = object;
        }
    }

    public MapBlock getBlock() {
        return block;
    }

    public MapObject getObject() {
        return object;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
