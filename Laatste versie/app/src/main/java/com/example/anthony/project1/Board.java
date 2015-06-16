package com.example.anthony.project1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;


public class Board extends Activity implements OnClickListener {

    public static String ImagePath;
    public static int BGint = 0;
    private static boolean SpawnImage = false;

    public static void setImage(String s){
        ImagePath = s;
    }
    public static void setBGint(int s){
        BGint = s;
    }

    static ArrayList<String> BG = new ArrayList<String>();


    private ImageView eraser;
    private ImageButton btnClear;

    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        BG.add("kruispunt");
        BG.add("rotonde");
        BG.add("tsplit");
        BG.add("invoegstrook");
        if (savedInstanceState == null) {

            drawingView = (DrawingView) findViewById(R.id.drawing);

            btnClear = (ImageButton) findViewById(R.id.btnClear);
            btnClear.setOnClickListener(this);


            eraser = (ImageView) findViewById(R.id.eraser);
            eraser.setOnClickListener(this);
        }

        ImageView img=(ImageView)
        findViewById(R.id.wegdek);
        img.setImageResource(getImageId(this, BG.get(BGint)));

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        if (SpawnImage == true)
        {
            createbord();
        }
    }

    public void changeBG(View V)
    {
        BGint = BGint + 1;
        if (BGint == 4)
        {BGint = 0;}
        String achtergrond = BG.get(BGint);
        ImageView img=(ImageView)
                findViewById(R.id.wegdek);
        img.setImageResource(getImageId(this, achtergrond));
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

    public void newBoardPage(View V) {
        Intent toBintent = new Intent(this, choose_board.class);
        toBintent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(toBintent);
        drawingView.activateEraser();
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }


//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}

    public static void ImageTrue() {SpawnImage = true;}
    public static void ImageFalse() {SpawnImage = false;}

    int i = 100;
    public void createbord()
    {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, 100);
        i = i - 50;
        ImageView Image = new ImageView(this);
        Image.setImageResource(getImageId(this, ImagePath));
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout5);
        rl.addView(Image);
        Image.setLayoutParams(layoutParams);
        ImageFalse();
    }

    public void onBackPressed()
    {
        /*do nothing*/
    }

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
