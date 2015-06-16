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


public class choose_board extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_board);
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
    }
}