package fr.space.invader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Jerem on 22/04/2016.
 */
public class HomeActivity extends Activity {
    private Button playButton;
    private TextView text;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        playButton=(Button) findViewById(R.id.play);
        text= (TextView) findViewById(R.id.SpaceText);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("HomeActivity","<<<<<<<<<<<<<<<");
                Intent intent = new Intent(HomeActivity.this, SpaceInvaderActivity.class);
                startActivity(intent);
            }
        });
    }
}