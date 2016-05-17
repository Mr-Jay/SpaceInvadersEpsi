package fr.space.invader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jerem on 17/05/2016.
 */
public class GameOverActivity extends Activity {
    private Button playButton;
    private TextView text;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        playButton=(Button) findViewById(R.id.play);
        text= (TextView) findViewById(R.id.SpaceText);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("GameOverActivity","<<<<<<<<<<<<<<<");
                Intent intent = new Intent(GameOverActivity.this, SpaceInvaderActivity.class);
                startActivity(intent);
            }
        });
    }
}