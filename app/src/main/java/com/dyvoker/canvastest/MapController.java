package com.dyvoker.canvastest;

/**
 * Controller for map
 */

public class MapController {
    private Map map;
    private MapCell selectedCell;

    public MapController(Map map) {
        this.map = map;
    }

    public void onMapCellClick(int x, int y) {
        if (selectedCell != null) { //Moving selected object
            MapCell currentCell = map.getObjectsAtPosition(x, y);
            currentCell.setObject(selectedCell.getObject());
            if (currentCell.getObject() == selectedCell.getObject()) {
                //Object successfully moved
                selectedCell.setSelected(false);
                selectedCell.setObject(null);
                selectedCell = null;
            }
        } else { //Select object
            selectedCell = map.getObjectsAtPosition(x, y);
            if (selectedCell.getObject() != null) { //Can select only blocks with object
                selectedCell.setSelected(true);
            }
        }
    }

}
