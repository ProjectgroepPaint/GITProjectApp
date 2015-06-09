package com.example.anthony.project1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;


public class Board extends Activity {

    public static String stringImage;

    public static void setString(String s){
        stringImage = s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        String source = "drawable/";

        String uri = source + stringImage;

        HashMap<String, Integer> images = new HashMap<String, Integer>();
        images.put( "kruispunt", Integer.valueOf( R.drawable.kruispunt ) );
        images.put( "rotonde", Integer.valueOf( R.drawable.rotonde ) );
        images.put("tsplit", Integer.valueOf(R.drawable.tsplit));
        images.put("invoegstrook", Integer.valueOf(R.drawable.invoegstrook));

        ImageView img=(ImageView)
        findViewById(R.id.wegdek);
        img.setImageResource(images.get(stringImage).intValue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_board, menu);
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


}
