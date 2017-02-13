package com.dyvoker.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Class for map cell, it's consist of block and object on it
 */

public class MapCell {
    private MapBlock block;
    private MapObject object;

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

    public boolean setObject(MapObject object) {
        if (block != null) { //can set object only on block ;)
            if (this.object == null || object == null) {
                this.object = object;
                return true;
            }
        }
        return false;
    }

    public MapBlock getBlock() {
        return block;
    }

    public MapObject getObject() {
        return object;
    }

    public void draw(Context context, Canvas canvas, Point pos, boolean isSelected) {
        if (block != null) {
            block.draw(context, canvas, pos);
        }
        if (isSelected) {
//            isSelected = 1;
        }
        if (object != null) {
            object.draw(context, canvas, pos);
        }
    }
}
