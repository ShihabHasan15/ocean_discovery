package com.hypernova.oceandiscovery;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class level_4 extends Fragment {
    Animation breath_anim;
    CardView lesson1, lesson2, lesson3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View level_4_view = inflater.inflate(R.layout.fragment_level_4, container, false);

        lesson1 = level_4_view.findViewById(R.id.lesson1);
        lesson2 = level_4_view.findViewById(R.id.lesson2);
        lesson3 = level_4_view.findViewById(R.id.lesson3);

        breath_anim = AnimationUtils.loadAnimation(getContext(), R.anim.breathe_anim);

        lesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learning_activity.learning_content = 10;
                startActivity(new Intent(getContext(), learning_activity.class));
            }
        });

        lesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learning_activity.learning_content = 11;
                startActivity(new Intent(getContext(), learning_activity.class));
            }
        });

        lesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learning_activity.learning_content = 12;
                startActivity(new Intent(getContext(), learning_activity.class));
            }
        });

        lesson1.startAnimation(breath_anim);
        lesson2.startAnimation(breath_anim);
        lesson3.startAnimation(breath_anim);

        return level_4_view;
    }
}