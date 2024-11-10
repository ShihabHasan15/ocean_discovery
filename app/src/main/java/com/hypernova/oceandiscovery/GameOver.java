package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class GameOver extends AppCompatActivity {
    TextView points, score;
    MaterialCardView done_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        points = findViewById(R.id.rewardAmount);

        Animation swipe_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swipe_anim);

        int points_count = getIntent().getExtras().getInt("points");

        done_btn = findViewById(R.id.okButton);

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(swipe_anim);

                Home_frag.start_btn2.setVisibility(View.VISIBLE);
                Home_frag.complete_dialog.show();
                finish();
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);




    }
}