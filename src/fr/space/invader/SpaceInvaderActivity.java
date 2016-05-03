package fr.space.invader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class SpaceInvaderActivity extends Activity implements View.OnTouchListener {
    /** Called when the activity is first created. */
    private ImageButton leftBut,rightBut;
    private SpaceInvaderView spView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        leftBut=(ImageButton) findViewById(R.id.left);
        rightBut = (ImageButton) findViewById(R.id.right);
        leftBut.setOnTouchListener(this);
        rightBut.setOnTouchListener(this);
        spView=(SpaceInvaderView) findViewById(R.id.spaceInvaderView1);
        spView.setBottom(dm.heightPixels);
        spView.setdm(dm);
        spView.startGame();


    }
/*
    @Override
    public void onClick(View v) {
        spView.click(v);
    }
*/


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            if(v.getId()==R.id.left) spView.moveShip(true,false);
            if(v.getId()==R.id.right) spView.moveShip(false,true);

        }
        else if(event.getAction()==MotionEvent.ACTION_UP) spView.moveShip(false,false);
        return true;
    }

    /*
    @Override
    public boolean onLongClick(View v) {

        spView.click(v);
        return false;
    }
    */
}