package com.dyvoker.canvastest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Game map with objects
 */

public class Map {
    private ArrayList<MapObject>[][] map;

    public Map() {
        ArrayList<MapObject>[][] defaultMap;
        {
            defaultMap = new ArrayList[3][4];
            for (int x = 0; x < defaultMap.length; x++) {
                for (int y = 0; y < defaultMap[x].length; y++) {
                    defaultMap[x][y] = new ArrayList<>();
                }
            }
            defaultMap[0][0].add(MapObject.BLOCK);
            defaultMap[0][1].add(MapObject.BLOCK);
            defaultMap[0][2].add(MapObject.BLOCK);
            defaultMap[1][1].add(MapObject.BLOCK);
            defaultMap[1][2].add(MapObject.BLOCK);
            defaultMap[2][2].add(MapObject.BLOCK);
            defaultMap[2][3].add(MapObject.BLOCK);

            defaultMap[2][2].add(MapObject.TREE);
        }
        map = defaultMap;
    }

    public Map(ArrayList[][] map) {
        this.map = map;
    }

    public List<MapObject> getObjectsAtPosition(int x, int y) {
        if (x < 0 || y < 0 || x >= getXSize() || y >= getYSize()) {
            return Collections.emptyList();
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
