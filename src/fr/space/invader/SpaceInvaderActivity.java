package fr.space.invader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SpaceInvaderActivity extends Activity implements View.OnTouchListener {
    /** Called when the activity is first created. */
    private Button leftBut,rightBut;
    private SpaceInvaderView spView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        leftBut=(Button) findViewById(R.id.left);
        rightBut = (Button) findViewById(R.id.right);
        leftBut.setOnTouchListener(this);
        rightBut.setOnTouchListener(this);
        spView=(SpaceInvaderView) findViewById(R.id.spaceInvaderView1);
        spView.setBottom(dm.heightPixels);
        spView.setdm(dm);
        spView.startGame();


    }

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


}