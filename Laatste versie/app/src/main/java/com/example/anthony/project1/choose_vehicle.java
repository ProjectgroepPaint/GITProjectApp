package com.example.anthony.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class choose_vehicle extends Activity implements View.OnClickListener {

    private ImageView imageView25;
    private ImageView imageView26;
    private ImageView imageView27;
    private ImageView imageView28;
    private ImageView imageView29;
    private ImageView imageView30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_vehicle);

        imageView25 = (ImageView) findViewById(R.id.imageView25);
        imageView25.setOnClickListener(this);

        imageView26 = (ImageView) findViewById(R.id.imageView26);
        imageView26.setOnClickListener(this);

        imageView27 = (ImageView) findViewById(R.id.imageView27);
        imageView27.setOnClickListener(this);

        imageView28 = (ImageView) findViewById(R.id.imageView28);
        imageView28.setOnClickListener(this);

        imageView29 = (ImageView) findViewById(R.id.imageView29);
        imageView29.setOnClickListener(this);

        imageView30 = (ImageView) findViewById(R.id.imageView30);
        imageView30.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_vehicle, menu);
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
