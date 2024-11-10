package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class lesson_list extends AppCompatActivity {

    ImageView cross_btn;
    public static int lesson_count = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        cross_btn = findViewById(R.id.cross_btn);

        cross_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        if (lesson_count==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new level_1())
                    .commit();
        } else if (lesson_count==2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new level_2())
                    .commit();
        } else if (lesson_count==3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new level_3())
                    .commit();
        } else if (lesson_count==4) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new level_4())
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}