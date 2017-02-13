package com.dyvoker.canvastest;

/**
 * Game map with objects
 */

public class Map {
    private MapCell[][] map;

    /**
     * Create empty map
    */
    public Map(int sizeX, int sizeY) {
        map = new MapCell[sizeX][sizeY];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = new MapCell();
            }
        }
    }

    public void setCellBlock(int x, int y, MapBlock block) {
        map[x][y].setBlock(block);
    }

    public void setCellObject(int x, int y, MapObject object) {
        map[x][y].setObject(object);
    }

    public MapCell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= getXSize() || y >= getYSize()) {
            throw new ArrayIndexOutOfBoundsException("Map array out of bounds!");
        }
        if (map[x][y] == null) {
            throw new RuntimeException("Map object can't be null! Check initialization of Map!");
        }
        return map[x][y];
    }

    public int getXSize() {
        return map.length;
    }

    public int getYSize() {
        return map[0].length;
    }
}
