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
        Map map = new Map(3, 4);
        return map;
    }
}
