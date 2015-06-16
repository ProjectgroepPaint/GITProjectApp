package com.example.anthony.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class choose_board extends Activity implements View.OnClickListener {



    private ImageView bordknop;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;
    private ImageView imageView11;
    private ImageView imageView12;
    private ImageView imageView13;
    private ImageView imageView14;
    private ImageView imageView15;
    private ImageView imageView16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_board);

        bordknop = (ImageView) findViewById(R.id.bordknop);
        bordknop.setOnClickListener(this);

        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView3.setOnClickListener(this);

        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setOnClickListener(this);

        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView5.setOnClickListener(this);

        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView6.setOnClickListener(this);

        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView7.setOnClickListener(this);

        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView8.setOnClickListener(this);

        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView9.setOnClickListener(this);

        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView10.setOnClickListener(this);

        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView11.setOnClickListener(this);

        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView12.setOnClickListener(this);

        imageView13 = (ImageView) findViewById(R.id.imageView13);
        imageView13.setOnClickListener(this);

        imageView14 = (ImageView) findViewById(R.id.imageView14);
        imageView14.setOnClickListener(this);

        imageView15 = (ImageView) findViewById(R.id.imageView15);
        imageView15.setOnClickListener(this);

        imageView16 = (ImageView) findViewById(R.id.imageView16);
        imageView16.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_board, menu);
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

    public void goBack(View V) {

        Intent backIntent = new Intent(this, Board.class);
        backIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(backIntent);
        Board.setImage("stop");
        Board.ImageTrue();

    }
    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(this, Board.class);
        backIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(backIntent);
        finish();
    }
    public void onClick(View v)
    {
        Intent backIntent = new Intent(this, Board.class);
        backIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(backIntent);
        String Image = v.getTag().toString();
        Board.setImage(Image);
        Board.ImageTrue();
        finish();
    }
}