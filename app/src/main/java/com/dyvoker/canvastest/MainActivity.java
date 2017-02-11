package com.dyvoker.canvastest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapCanvas mapCanvas = (MapCanvas) findViewById(R.id.mapCanvas);
        Map map = new Map();
        mapCanvas.setMap(map);
    }
}
