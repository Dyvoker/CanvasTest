package com.dyvoker.canvastest;

import android.graphics.Point;

/**
 * Controller for map
 */

public class MapController {
    private Map map;
    private MapCell selectedCell;

    public MapController(Map map) {
        setMap(map);
    }

    public void setMap(Map map) {
        this.map = map;
        selectedCell = null;
    }

    public void onMapCellClick(Point pos) {
        MapCell clickedCell = map.getCell(pos.x, pos.y);

        //Can click cells only with block
        if (clickedCell.getBlock() == null) {
            return;
        }

        //If clicked cell is the same as selected cell, then deselect it
        if (clickedCell == selectedCell) {
            selectedCell = null;
            return;
        }

        //Select new cell, if clicked cell have object
        if (clickedCell.getObject() != null) {
            selectedCell = clickedCell;
            return;
        }

        //If selected cell is set and clicked cell don't have object, then try to move object
        if (selectedCell != null) {
            if (clickedCell.setObject(selectedCell.getObject())) { //If object successfully moved
                selectedCell.setObject(null);
                selectedCell = null;
            }
        }
    }

    public boolean isCellSelected(MapCell cell) {
        return selectedCell == cell;
    }
}
