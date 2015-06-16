package com.example.anthony.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class NewGameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_game, menu);
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

    public void newPageKruispunt(View V) {
        Board.setString("kruispunt");
        Intent intent = new Intent(this, Board.class);
        startActivity(intent);
        Log.d("startactivity", "end of new page method");
    }

    public void newPageRotonde (View V) {
        Board.setString("rotonde");
        Intent intent = new Intent(this, Board.class);
        startActivity(intent);
        Log.d("startactivity", "end of new page method");
    }

    public void newPageTsplit (View V) {
        Board.setString("tsplit");
        Intent intent = new Intent(this, Board.class);
        startActivity(intent);
        Log.d("startactivity", "end of new page method");
    }

    public void newPageInvoeg(View V) {
        Board.setString("invoegstrook");
        Intent intent = new Intent(this, Board.class);
        startActivity(intent);
        Log.d("startactivity", "end of new page method");
    }

}