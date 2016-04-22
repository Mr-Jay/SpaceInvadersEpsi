package fr.space.invader;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SpaceInvaderActivity extends Activity implements View.OnTouchListener {
    /** Called when the activity is first created. */
    private Button leftBut,rightBut;
    private SpaceInvaderView spView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        leftBut=(Button) findViewById(R.id.left);
        rightBut = (Button) findViewById(R.id.right);
        leftBut.setOnTouchListener(this);
        rightBut.setOnTouchListener(this);
        spView=(SpaceInvaderView) findViewById(R.id.spaceInvaderView1);

    }
/*
    @Override
    public void onClick(View v) {
        spView.click(v);
    }
*/


    @Override
    public boolean onTouch(View v, MotionEvent event) {



            spView.click(v);
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