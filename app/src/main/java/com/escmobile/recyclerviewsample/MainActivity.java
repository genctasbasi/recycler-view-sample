package com.escmobile.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import adapter.ViewAdapter;

public class MainActivity extends ActionBarActivity {

    private static final int SPAN_COUNT = 3;
    private static final int NUMBER_OF_IMAGES = 1500;

    final String[] Colours = {
            "FF0000", "FFFF00", "FFC125",
            "71C671", "00CED1", "FF1493",
            "9B30FF", "000000", "FFA07A"};

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT);

        recyclerView.setLayoutManager(gridLayoutManager);

        ((Button) findViewById(R.id.btn_load_images)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAdapter adapter = new ViewAdapter(MainActivity.this, getImageUrlList());
                recyclerView.setAdapter(adapter);
            }
        });
    }

    /**
     * a very loooong list of images
     *
     * @return
     */
    public ArrayList<String> getImageUrlList() {

        ArrayList<String> urls = new ArrayList<>();

        // we are adding many many many images here (1500 images!)
        for (int i = 0; i < NUMBER_OF_IMAGES; i++) {
            int n = i % Colours.length;
            urls.add("http://placehold.it/300x300/" + Colours[n] + "/ffffff&text=" + String.valueOf(n + 1));
        }

        return urls;
    }
}
