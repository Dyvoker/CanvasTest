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
        MapCell clickedCell = map.getObjectsAtPosition(pos.x, pos.y);
        if (selectedCell != null) { //Try to move selected object
            if (clickedCell.setObject(selectedCell.getObject())) { //Object successfully moved
                selectedCell.setObject(null);
                selectedCell = null;
            }
        } else { //Try to select object
            if (clickedCell.getObject() != null) { //Can select only blocks with object
                selectedCell = clickedCell;
            }
        }
    }

    public boolean isCellSelected(MapCell cell) {
        return selectedCell == cell;
    }
}
