package com.example.anthony.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class choose_roadsigns extends Activity implements View.OnClickListener {


    private ImageView imageView17;
    private ImageView imageView18;
    private ImageView imageView19;
    private ImageView imageView20;
    private ImageView imageView21;
    private ImageView imageView22;
    private ImageView imageView23;
    private ImageView imageView24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_roadsigns);


        imageView17 = (ImageView) findViewById(R.id.imageView17);
        imageView17.setOnClickListener(this);

        imageView18 = (ImageView) findViewById(R.id.imageView18);
        imageView18.setOnClickListener(this);

        imageView19 = (ImageView) findViewById(R.id.imageView19);
        imageView19.setOnClickListener(this);

        imageView20 = (ImageView) findViewById(R.id.imageView20);
        imageView20.setOnClickListener(this);

        imageView21 = (ImageView) findViewById(R.id.imageView21);
        imageView21.setOnClickListener(this);

        imageView22 = (ImageView) findViewById(R.id.imageView22);
        imageView22.setOnClickListener(this);

        imageView23 = (ImageView) findViewById(R.id.imageView23);
        imageView23.setOnClickListener(this);

        imageView24 = (ImageView) findViewById(R.id.imageView24);
        imageView24.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.choose_road_signs, menu);
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
