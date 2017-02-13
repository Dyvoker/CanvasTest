package com.dyvoker.canvastest;

/**
 * Game map with objects
 */

public class Map {
    private MapCell[][] map;

    public Map() {
        MapCell[][] defaultMap;
        {
            defaultMap = new MapCell[3][4];
            for (int x = 0; x < defaultMap.length; x++) {
                for (int y = 0; y < defaultMap[x].length; y++) {
                    defaultMap[x][y] = new MapCell();
                }
            }
            defaultMap[0][0].setBlock(MapBlock.SEND);
            defaultMap[0][2].setBlock(MapBlock.SEND);
            defaultMap[1][1].setBlock(MapBlock.SEND);
            defaultMap[1][2].setBlock(MapBlock.SEND);
            defaultMap[2][2].setBlock(MapBlock.SEND);
            defaultMap[2][3].setBlock(MapBlock.SEND);

            defaultMap[2][2].setObject(MapObject.TREE);
            defaultMap[0][2].setObject(MapObject.TREE);
        }
        map = defaultMap;
    }

    public Map(MapCell[][] map) {
        this.map = map;
    }

    public MapCell getCellAtPosition(int x, int y) {
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
