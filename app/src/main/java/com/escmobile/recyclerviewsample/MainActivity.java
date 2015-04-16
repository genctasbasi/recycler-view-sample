package com.escmobile.recyclerviewsample;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import adapter.ViewAdapter;

public class MainActivity extends ActionBarActivity {

    private static final int SPAN_COUNT = 4;
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

        final Context thisContext = this;
        ((Button)findViewById(R.id.btn_load_images)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAdapter adapter = new ViewAdapter(thisContext, getImageUrls());
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String[] getImageUrls() {
        String[] imageUrls = {
                "http://placehold.it/300x300/FF0000/ffffff&text=1",
                "http://placehold.it/300x300/FFFF00/ffffff&text=2",
                "http://placehold.it/300x300/FFC125/ffffff&text=3",
                "http://placehold.it/300x300/71C671/ffffff&text=4",
                "http://placehold.it/300x300/00CED1/ffffff&text=5",
                "http://placehold.it/300x300/FF1493/ffffff&text=6",
                "http://placehold.it/300x300/9B30FF/ffffff&text=7",
                "http://placehold.it/300x300/000000/ffffff&text=8",
                "http://placehold.it/300x300/FFA07A/ffffff&text=9"
        };

        return imageUrls;
    }
}
