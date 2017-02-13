package com.dyvoker.canvastest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MapCanvas mapCanvas = (MapCanvas) findViewById(R.id.mapCanvas);
        mapCanvas.setMap(generateMap1());

        Button buttonSetMap1 = (Button) findViewById(R.id.buttonMap1);
        Button buttonSetMap2 = (Button) findViewById(R.id.buttonMap2);
        Button buttonSetMap3 = (Button) findViewById(R.id.buttonMap3);

        buttonSetMap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapCanvas.setMap(generateMap1());
            }
        });

        buttonSetMap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapCanvas.setMap(generateMap2());
            }
        });

        buttonSetMap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapCanvas.setMap(generateMap3());
            }
        });
    }

    private Map generateMap1() {
        Map map = new Map(3, 4);
        map.setCellBlock(0, 0, MapBlock.SEND);
        map.setCellBlock(0, 1, MapBlock.SEND);
        map.setCellBlock(0, 2, MapBlock.SEND);
        map.setCellBlock(0, 3, MapBlock.SEND);
        map.setCellBlock(1, 1, MapBlock.SEND);
        map.setCellBlock(2, 1, MapBlock.SEND);
        map.setCellBlock(1, 3, MapBlock.SEND);

        map.setCellObject(0, 0, MapObject.TREE);
        return map;
    }

    private Map generateMap2() {
        Map map = new Map(3, 4);
        map.setCellBlock(0, 0, MapBlock.SEND);
        map.setCellBlock(0, 2, MapBlock.SEND);
        map.setCellBlock(1, 1, MapBlock.SEND);
        map.setCellBlock(1, 2, MapBlock.SEND);
        map.setCellBlock(2, 2, MapBlock.SEND);
        map.setCellBlock(2, 3, MapBlock.SEND);

        map.setCellObject(0, 2, MapObject.TREE);
        map.setCellObject(2, 2, MapObject.TREE);
        return map;
    }

    private Map generateMap3() {
        Map map = new Map(11, 10);
        map.setCellBlock(0, 2, MapBlock.SEND);
        map.setCellBlock(0, 3, MapBlock.DIRT);
        map.setCellBlock(0, 4, MapBlock.SEND);

        map.setCellBlock(1, 1, MapBlock.SEND);
        map.setCellBlock(1, 2, MapBlock.ICE);
        map.setCellBlock(1, 3, MapBlock.DIRT);
        map.setCellBlock(1, 4, MapBlock.SEND);
        map.setCellBlock(1, 5, MapBlock.GRASS);

        map.setCellBlock(2, 0, MapBlock.SEND);
        map.setCellBlock(2, 1, MapBlock.DIRT);
        map.setCellBlock(2, 2, MapBlock.SEND);
        map.setCellBlock(2, 3, MapBlock.ICE);
        map.setCellBlock(2, 4, MapBlock.SEND);
        map.setCellBlock(2, 5, MapBlock.GRASS);
        map.setCellBlock(2, 6, MapBlock.SEND);

        map.setCellBlock(3, 0, MapBlock.SEND);
        map.setCellBlock(3, 1, MapBlock.SEND);
        map.setCellBlock(3, 2, MapBlock.ICE);
        map.setCellBlock(3, 3, MapBlock.GRASS);
        map.setCellBlock(3, 5, MapBlock.DIRT);
        map.setCellBlock(3, 6, MapBlock.SEND);
        map.setCellBlock(3, 7, MapBlock.SEND);

        map.setCellBlock(4, 1, MapBlock.SEND);
        map.setCellBlock(4, 2, MapBlock.SEND);
        map.setCellBlock(4, 6, MapBlock.ICE);
        map.setCellBlock(4, 7, MapBlock.SEND);
        map.setCellBlock(4, 8, MapBlock.GRASS);

        map.setCellBlock(5, 2, MapBlock.SEND);
        map.setCellBlock(5, 3, MapBlock.SEND);
        map.setCellBlock(5, 7, MapBlock.DIRT);
        map.setCellBlock(5, 8, MapBlock.SEND);
        map.setCellBlock(5, 9, MapBlock.SEND);

        map.setCellBlock(6, 1, MapBlock.SEND);
        map.setCellBlock(6, 2, MapBlock.ICE);
        map.setCellBlock(6, 6, MapBlock.GRASS);
        map.setCellBlock(6, 7, MapBlock.SEND);
        map.setCellBlock(6, 8, MapBlock.SEND);

        map.setCellBlock(7, 0, MapBlock.SEND);
        map.setCellBlock(7, 1, MapBlock.DIRT);
        map.setCellBlock(7, 2, MapBlock.DIRT);
        map.setCellBlock(7, 3, MapBlock.GRASS);
        map.setCellBlock(7, 5, MapBlock.SEND);
        map.setCellBlock(7, 6, MapBlock.DIRT);
        map.setCellBlock(7, 7, MapBlock.SEND);

        map.setCellBlock(8, 0, MapBlock.SEND);
        map.setCellBlock(8, 1, MapBlock.ICE);
        map.setCellBlock(8, 2, MapBlock.GRASS);
        map.setCellBlock(8, 3, MapBlock.ICE);
        map.setCellBlock(8, 4, MapBlock.SEND);
        map.setCellBlock(8, 5, MapBlock.DIRT);
        map.setCellBlock(8, 6, MapBlock.SEND);

        map.setCellBlock(9, 1, MapBlock.SEND);
        map.setCellBlock(9, 2, MapBlock.SEND);
        map.setCellBlock(9, 3, MapBlock.GRASS);
        map.setCellBlock(9, 4, MapBlock.ICE);
        map.setCellBlock(9, 5, MapBlock.SEND);

        map.setCellBlock(10, 2, MapBlock.GRASS);
        map.setCellBlock(10, 3, MapBlock.ICE);
        map.setCellBlock(10, 4, MapBlock.SEND);

        map.setCellObject(0, 4, MapObject.BUSH);
        map.setCellObject(2, 1, MapObject.TREE);
        map.setCellObject(3, 2, MapObject.BUSH);
        map.setCellObject(4, 2, MapObject.ROCK);
        map.setCellObject(5, 7, MapObject.TREE);
        map.setCellObject(5, 9, MapObject.BUSH);
        map.setCellObject(7, 5, MapObject.ROCK);
        map.setCellObject(8, 5, MapObject.BUSH);
        map.setCellObject(9, 1, MapObject.TREE);
        map.setCellObject(9, 3, MapObject.ROCK);
        return map;
    }
}
