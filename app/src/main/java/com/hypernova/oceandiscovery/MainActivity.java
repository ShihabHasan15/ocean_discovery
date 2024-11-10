package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

//    ImageView start_btn;
//    Animation button_anim;

    public static boolean show = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        start_btn = findViewById(R.id.start_btn);
//        button_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);

        Animation swipe_anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.swipe_anim);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, new Home_frag());
        fragmentTransaction.commit();


        Animation button_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.age_level_selection);

        AlertDialog.Builder al = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View dialog_view = inflater.inflate(R.layout.age_level_selection, null);

        MaterialCardView materialCardView = dialog_view.findViewById(R.id.materialCardView);
        MaterialCardView materialCardView2 = dialog_view.findViewById(R.id.materialCardView2);
        MaterialCardView materialCardView3 = dialog_view.findViewById(R.id.materialcardview3);
        MaterialCardView materialCardView4 = dialog_view.findViewById(R.id.materialCardView4);
        MaterialCardView submit_btn = dialog_view.findViewById(R.id.submit_btn);

        al.setView(dialog_view);


        AlertDialog dialog = al.create();

        materialCardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                materialCardView.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));

                v.startAnimation(button_anim);
            }
        });

        materialCardView2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                materialCardView2.setCardBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_light));
            }
        });

        materialCardView3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                materialCardView3.setCardBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_light));
            }
        });

        materialCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                materialCardView4.setCardBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_light));
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                LayoutInflater inflater1 = getLayoutInflater();
                View view = inflater1.inflate(R.layout.ocean_cover_dialog2, null);

                view.startAnimation(swipe_anim);

                TextView header_txt = view.findViewById(R.id.textView3);
                TextView detail_text = view.findViewById(R.id.detail_txt);
                TextView next_btn_txt = view.findViewById(R.id.next_btn_txt);
                ImageView emoji = view.findViewById(R.id.imageView9);

                next_btn_txt.setText("Next");

                MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                header_txt.setText("");
                detail_text.setText("you are a ocean Explorer. You have to save the ocean ecosystem by learning.");
                detail_text.setTextSize(30);

                emoji.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.happy_emoji));

                builder.setView(view);

                AlertDialog dialog4 = builder.create();

                dialog4.setCancelable(false);

                dialog4.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams layoutParams = dialog4.getWindow().getAttributes();
                layoutParams.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
                dialog4.getWindow().setAttributes(layoutParams);

                dialog4.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                dialog4.show();

                next_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog4.dismiss();

                        LayoutInflater inflater1 = getLayoutInflater();
                        View view = inflater1.inflate(R.layout.ocean_cover_dialog2, null);

                        view.startAnimation(swipe_anim);

                        TextView header_txt = view.findViewById(R.id.textView3);
                        TextView detail_text = view.findViewById(R.id.detail_txt);
                        TextView next_btn_txt = view.findViewById(R.id.next_btn_txt);
                        ImageView emoji = view.findViewById(R.id.imageView9);

                        emoji.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cool_emoji));

                        next_btn_txt.setText("Go");

                        MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                        header_txt.setText("");
                        detail_text.setText("So, Get Ready to dive in the oceanic world");
                        detail_text.setTextSize(35);

                        builder.setView(view);

                        AlertDialog dialog5 = builder.create();

                        dialog5.setCancelable(false);

                        dialog5.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        WindowManager.LayoutParams layoutParams = dialog5.getWindow().getAttributes();
                        layoutParams.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
                        dialog5.getWindow().setAttributes(layoutParams);

                        dialog5.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                        dialog5.show();

                        next_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog5.dismiss();
                            }
                        });

                    }
                });

            }
        });

        dialog.setCancelable(false);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
        dialog.getWindow().setAttributes(lp);

        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.show();


        String url = "";


        if (show==true){

            LayoutInflater inflater2 = getLayoutInflater();
            View view = inflater2.inflate(R.layout.ocean_cover_dialog2, null);

            builder.setView(view);

            view.startAnimation(swipe_anim);

            TextView header_txt = view.findViewById(R.id.textView3);
            TextView detail_text = view.findViewById(R.id.detail_txt);
            TextView next_btn_txt = view.findViewById(R.id.next_btn_txt);
            ImageView emoji = view.findViewById(R.id.imageView9);

            next_btn_txt.setText("Next");

            MaterialCardView next_btn = view.findViewById(R.id.next_btn);

            header_txt.setText("");
            detail_text.setText("Now, you know many things about our ocean");
            detail_text.setTextSize(30);

            emoji.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.happy_emoji));

            builder.setView(view);

            AlertDialog dialog5 = builder.create();

            dialog5.setCancelable(false);

            dialog5.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            WindowManager.LayoutParams layoutParams = dialog5.getWindow().getAttributes();
            layoutParams.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
            dialog5.getWindow().setAttributes(layoutParams);

            dialog5.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

            dialog5.show();
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}