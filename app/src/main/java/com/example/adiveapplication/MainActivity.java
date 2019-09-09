package com.example.adiveapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.colorSpace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//object of the Relative Layout
        RelativeLayout relativeLayout=findViewById(R.id.Layout_Parent);
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();
    }

    public void play_btn(View view) {
        final Button button= (Button) view;

        MediaPlayer mediaPlayer=MediaPlayer.create(MainActivity.this,getResources().getIdentifier((String) button.getTag(),"raw",getPackageName()));
        mediaPlayer.start();

        if(mediaPlayer.isPlaying()){
            button.setBackgroundColor(RED);
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                button.setBackgroundColor(GREEN);
                button.setTextColor(Color.GRAY);
            }
        });
    }
}
