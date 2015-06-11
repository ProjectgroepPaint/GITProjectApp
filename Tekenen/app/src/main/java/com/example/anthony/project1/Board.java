package com.example.anthony.project1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;


public class Board extends Activity implements OnClickListener {

    public static String stringImage;

    public static void setString(String s){
        stringImage = s;
    }
    private ImageView eraser;
    private ImageButton btnClear;

    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        if (savedInstanceState == null) {

            drawingView = (DrawingView) findViewById(R.id.drawing);

            btnClear = (ImageButton) findViewById(R.id.btnClear);
            btnClear.setOnClickListener(this);


            eraser = (ImageView) findViewById(R.id.eraser);
            eraser.setOnClickListener(this);
        }
        //setContentView(R.layout.activity_board);

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





//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}


    public void onClick(View v) {

        if (v == eraser) {

            if (drawingView.isEraserActive()) {

                drawingView.deactivateEraser();

            } else {

                drawingView.activateEraser();

            }

        } else if (v == btnClear) {

            drawingView.reset();
        }
    }

}
