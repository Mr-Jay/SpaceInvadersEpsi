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
    public static boolean isPressed=false;
    public static char pos='l';

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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            isPressed=true;
            if(v.getId() == leftBut.getId()){
                pos = 'l';
            }
            else if(v.getId() == rightBut.getId()){
                pos = 'r';
            }
        }
        else if(event.getAction()==MotionEvent.ACTION_UP)
        {
            isPressed=false;
        }
        spView.click(v);
        return true;
    }
}