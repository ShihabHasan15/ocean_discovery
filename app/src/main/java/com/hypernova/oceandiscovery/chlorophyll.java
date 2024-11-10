package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

public class chlorophyll extends AppCompatActivity {

    MaterialCardView next_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chlorophyll);

        Animation swipe_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swipe_anim);


        next_btn = findViewById(R.id.next_btn);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                TextView detail_text = view.findViewById(R.id.detail_txt);
                TextView header_text = view.findViewById(R.id.textView3);
                ImageView emoji = view.findViewById(R.id.imageView9);
                MaterialCardView dialog_next_btn = view.findViewById(R.id.next_btn);

                header_text.setText("Congratulations!!");

                detail_text.setText("Lesson 2 Completed");
                detail_text.setTextSize(35);
                emoji.setImageDrawable(ContextCompat.getDrawable(chlorophyll.this, R.drawable.excited));

                AlertDialog.Builder builder = new AlertDialog.Builder(chlorophyll.this);
                builder.setView(view);

                dialog_next_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                AlertDialog complete_dialog = builder.create();

                complete_dialog.setCancelable(false);

                complete_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams lp = complete_dialog.getWindow().getAttributes();
                lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
                complete_dialog.getWindow().setAttributes(lp);

                complete_dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                complete_dialog.show();
            }
        });

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

        view.startAnimation(swipe_anim);

        TextView header_txt = view.findViewById(R.id.textView3);
        TextView details_txt = view.findViewById(R.id.detail_txt);


        ImageView emoji = view.findViewById(R.id.imageView9);

        MaterialCardView next_btn = view.findViewById(R.id.next_btn);

        header_txt.setText("ChloroPhyll");
        details_txt.setText("Chlorophyll is a green pigment found in plants, algae, and some bacteria that plays a crucial role in photosynthesis");


        emoji.setImageDrawable(ContextCompat.getDrawable(chlorophyll.this, R.drawable.smiley_face));

        AlertDialog.Builder builder = new AlertDialog.Builder(chlorophyll.this);
        builder.setView(view);

        AlertDialog dialog = builder.create();

        dialog.setCancelable(false);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
        dialog.getWindow().setAttributes(lp);

        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        dialog.show();

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                view.startAnimation(swipe_anim);

                TextView header_txt = view.findViewById(R.id.textView3);
                TextView details_txt = view.findViewById(R.id.detail_txt);


                ImageView emoji = view.findViewById(R.id.imageView9);

                MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                header_txt.setText("ChloroPhyll");
                details_txt.setText("It absorbs sunlight, primarily in the blue and red wavelengths, and reflects green light, giving plants their characteristic color");


                emoji.setImageDrawable(ContextCompat.getDrawable(chlorophyll.this, R.drawable.smiley_face));

                AlertDialog.Builder builder = new AlertDialog.Builder(chlorophyll.this);
                builder.setView(view);

                AlertDialog dialog1 = builder.create();

                dialog1.setCancelable(false);

                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams lp = dialog1.getWindow().getAttributes();
                lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
                dialog1.getWindow().setAttributes(lp);

                dialog1.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                dialog1.show();

                next_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();

                        LayoutInflater inflater = getLayoutInflater();
                        View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                        view.startAnimation(swipe_anim);

                        TextView header_txt = view.findViewById(R.id.textView3);
                        TextView details_txt = view.findViewById(R.id.detail_txt);


                        ImageView emoji = view.findViewById(R.id.imageView9);

                        MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                        header_txt.setText("ChloroPhyll");
                        details_txt.setText("Let's Learn More About Chlorophyll");

                        details_txt.setTextSize(35);

                        emoji.setImageDrawable(ContextCompat.getDrawable(chlorophyll.this, R.drawable.smiley_face));

                        AlertDialog.Builder builder = new AlertDialog.Builder(chlorophyll.this);
                        builder.setView(view);

                        AlertDialog dialog2 = builder.create();

                        dialog2.setCancelable(false);

                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        WindowManager.LayoutParams lp = dialog2.getWindow().getAttributes();
                        lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
                        dialog2.getWindow().setAttributes(lp);

                        dialog2.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                        dialog2.show();

                        next_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                            }
                        });
                    }
                });
            }
        });


    }
}