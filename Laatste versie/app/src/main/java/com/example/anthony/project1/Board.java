package com.example.anthony.project1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.ArrayList;
import android.content.ClipData;
import android.content.ClipDescription;
import android.widget.RelativeLayout;
import android.util.Log;


public class Board extends Activity implements OnClickListener
{

    String msg;

    public static String ImagePath;
    public static int BGint = 0;
    private static boolean SpawnImage = false;
    public static View ImageV;
    public static int Imageheight;
    public static int Imagewidth;

    public static float a = 0;


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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        BG.add("kruispunt");
        BG.add("rotonde");
        BG.add("tsplit");
        BG.add("invoegstrook");
        if (savedInstanceState == null)
        {
            drawingView = (DrawingView) findViewById(R.id.drawing);

            btnClear = (ImageButton) findViewById(R.id.btnClear);
            btnClear.setOnClickListener(this);


            eraser = (ImageView) findViewById(R.id.eraser);
            eraser.setOnClickListener(this);



            ImageView img=(ImageView)
            findViewById(R.id.wegdek);
            img.setImageResource(getImageId(this, BG.get(BGint)));

        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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

    public void newBoardPage(View V)
    {
        Intent toBintent = new Intent(this, choose_board.class);
        toBintent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(toBintent);
        drawingView.activateEraser();
    }

    public void newSignPage(View V)
    {
        Intent toBintent = new Intent(this, choose_roadsigns.class);
        toBintent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(toBintent);
        drawingView.activateEraser();
    }

    public void newVerhiclePage(View V)
    {
        Intent toBintent = new Intent(this, choose_vehicle.class);
        toBintent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(toBintent);
        drawingView.activateEraser();
    }

    public static int getImageId(Context context, String imageName)
    {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }


    public static void ImageTrue() {SpawnImage = true;}
    public static void ImageFalse() {SpawnImage = false;}


    public void createbord()
    {
        final ImageView Image = new ImageView(this);
        Image.setImageResource(getImageId(this, ImagePath));
        int ViewID=View.generateViewId();
        Image.setId(ViewID);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout5);
        rl.addView(Image);
        ImageFalse();
        Image.setX(300);
        Image.setY(300);
        Image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(Image);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        drawingView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout5);
                        float x = event.getX();
                        float left = drawingView.getLeft();
                        float top = drawingView.getTop();
                        float Trashtop = drawingView.getTop() - 100;
                        float Trashright = drawingView.getRight() - 100;
                        float turnleft = drawingView.getLeft() + 100;
                        float y = event.getY();

                        if (left + x > Trashright && y > Trashtop)
                        {
                            rl.removeView(ImageV);
                        }

                        ImageV.setX((left + x) - Imagewidth);
                        ImageV.setY((y + top) - Imageheight);

                        if (left + x < turnleft && y > Trashtop)
                        {
                            rotate();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        Image.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    setview(v);
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(Image);
                    Image.startDrag(data, shadowBuilder, Image, 0);
                    Image.setVisibility(View.VISIBLE);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });
        setview(Image);
    }


    public void onBackPressed()
    {/*do nothing*/}

    public void setview(View v)
    {
        ImageV = v;
        Imageheight = ImageV.getMeasuredHeight()/2;
        Imagewidth = ImageV.getMeasuredWidth()/2;
        //v.setLayoutParams(new RelativeLayout.LayoutParams(Imagewidth * 2, Imagewidth * 2));
    }



    public void rotate()
    {
        ImageView img = (ImageView)ImageV;

        Matrix m = new Matrix();
        if (a == 360f){a = 0;}
        a = a + 45;
        //ImageV.setLayoutParams(new RelativeLayout.LayoutParams(Imagewidth * 2, Imagewidth * 2));
        m.postRotate(a, Imagewidth, Imageheight);
        img.setScaleType(ImageView.ScaleType.MATRIX);
        img.setImageMatrix(m);
    }

    public void onClick(View v)
    {

        if (v == eraser)
        {

            rotate();
            if (drawingView.isEraserActive())
            {

                drawingView.deactivateEraser();

            }
            else
            {

                drawingView.activateEraser();

            }
        }
        else if (v == btnClear)
        {

            drawingView.reset();

        }
    }
}
