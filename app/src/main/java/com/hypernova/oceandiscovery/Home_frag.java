package com.hypernova.oceandiscovery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class Home_frag extends Fragment {
    Animation button_anim;
    public static ImageView start_btn1, start_btn2, start_btn3, start_btn4;
    public static AlertDialog complete_dialog;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View lay_view = inflater.inflate(R.layout.fragment_home_frag, container, false);

        button_anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_anim);

        start_btn1 = lay_view.findViewById(R.id.start_btn1);
        start_btn2 = lay_view.findViewById(R.id.start_btn2);
        start_btn3 = lay_view.findViewById(R.id.start_btn3);
        start_btn4 = lay_view.findViewById(R.id.start_btn4);

        Animation swipe_anim = AnimationUtils.loadAnimation(getContext(), R.anim.swipe_anim);


        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.ocean_cover_dialog2, null);

        TextView detail_text = view.findViewById(R.id.detail_txt);
        TextView header_text = view.findViewById(R.id.textView3);
        ImageView emoji = view.findViewById(R.id.imageView9);
        MaterialCardView dialog_next_btn = view.findViewById(R.id.next_btn);

        header_text.setText("Congratulations!!");

        detail_text.setText("Level 1 Completed");
        detail_text.setTextSize(35);
        emoji.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.excited));

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view);

        complete_dialog = builder.create();

        complete_dialog.setCancelable(false);

        complete_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams lp = complete_dialog.getWindow().getAttributes();
        lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
        complete_dialog.getWindow().setAttributes(lp);

        complete_dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        dialog_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                complete_dialog.dismiss();
            }
        });



        start_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                startActivity(new Intent(getContext(), learning_activity.class));
                getActivity().overridePendingTransition(R.anim.pop_up, R.anim.fade_out);
            }
        });

        start_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                startActivity(new Intent(getContext(), level2.class));
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        start_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                startActivity(new Intent(getContext(), level3.class));
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        start_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_anim);
                startActivity(new Intent(getContext(), level4.class));
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });




        return lay_view;
    }
}