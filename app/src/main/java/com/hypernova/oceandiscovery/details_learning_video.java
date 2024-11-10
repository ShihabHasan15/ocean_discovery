package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.material.card.MaterialCardView;

public class details_learning_video extends AppCompatActivity {

    MaterialCardView nextBtn;
    ImageView cross_btn;
    public static int lay_count = 0;
    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_learning_video);


        cross_btn = findViewById(R.id.cross_btn);
        nextBtn = findViewById(R.id.next_btn);

        cross_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (lay_count==0 || lay_count==3 || lay_count==7){
            //lesson2
            nextBtn.setOnClickListener(new View.OnClickListener() {
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
                    emoji.setImageDrawable(ContextCompat.getDrawable(details_learning_video.this, R.drawable.excited));

                    AlertDialog.Builder builder = new AlertDialog.Builder(details_learning_video.this);
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
        } else if (lay_count==1 || lay_count==4 || lay_count==8) {
            //level1 lesson2
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                    TextView detail_text = view.findViewById(R.id.detail_txt);
                    TextView header_text = view.findViewById(R.id.textView3);
                    ImageView emoji = view.findViewById(R.id.imageView9);
                    MaterialCardView dialog_next_btn = view.findViewById(R.id.next_btn);

                    header_text.setText("Congratulations!!");

                    detail_text.setText("Lesson 3 Completed");
                    detail_text.setTextSize(35);
                    emoji.setImageDrawable(ContextCompat.getDrawable(details_learning_video.this, R.drawable.excited));

                    AlertDialog.Builder builder = new AlertDialog.Builder(details_learning_video.this);
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
        } else if (lay_count==2 || lay_count==6) {
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                    TextView detail_text = view.findViewById(R.id.detail_txt);
                    TextView header_text = view.findViewById(R.id.textView3);
                    ImageView emoji = view.findViewById(R.id.imageView9);
                    MaterialCardView dialog_next_btn = view.findViewById(R.id.next_btn);

                    header_text.setText("Congratulations!!");

                    detail_text.setText("Lesson 1 Completed");
                    detail_text.setTextSize(35);
                    emoji.setImageDrawable(ContextCompat.getDrawable(details_learning_video.this, R.drawable.excited));

                    AlertDialog.Builder builder = new AlertDialog.Builder(details_learning_video.this);
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
        } else if (lay_count==5) {
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                    TextView detail_text = view.findViewById(R.id.detail_txt);
                    TextView header_text = view.findViewById(R.id.textView3);
                    ImageView emoji = view.findViewById(R.id.imageView9);
                    MaterialCardView dialog_next_btn = view.findViewById(R.id.next_btn);

                    header_text.setText("Congratulations!!");

                    detail_text.setText("Lesson 4 Completed");
                    detail_text.setTextSize(35);
                    emoji.setImageDrawable(ContextCompat.getDrawable(details_learning_video.this, R.drawable.excited));

                    AlertDialog.Builder builder = new AlertDialog.Builder(details_learning_video.this);
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
        }


        Animation swipe_anim = AnimationUtils.loadAnimation(details_learning_video.this, R.anim.swipe_anim);
        Animation button_anim = AnimationUtils.loadAnimation(details_learning_video.this, R.anim.button_anim);
        Animation pop_up_anim = AnimationUtils.loadAnimation(details_learning_video.this, R.anim.pop_up);


        if (lay_count==0){

            //lesson2

        } else if (lay_count==1) {


        }else if (lay_count==2) {
            //level2 lesson1

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

            view.startAnimation(swipe_anim);

            TextView header_txt = view.findViewById(R.id.textView3);
            TextView details_txt = view.findViewById(R.id.detail_txt);


            ImageView emoji = view.findViewById(R.id.imageView9);

            MaterialCardView next_btn = view.findViewById(R.id.next_btn);

            header_txt.setText("PACE");
            details_txt.setText("Aerosols help form clouds that have a high reflectivity, meaning they reflect sunlight back into space. This reduces the amount of solar energy absorbed by the Earth's surface, helping to cool the planet.");


            emoji.setImageDrawable(ContextCompat.getDrawable(details_learning_video.this, R.drawable.smiley_face));

            AlertDialog.Builder builder = new AlertDialog.Builder(details_learning_video.this);
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

                    header_txt.setText("PACE");
                    details_txt.setText("Let's Learn more about PACE");

                    details_txt.setTextSize(35);

                    emoji.setImageDrawable(ContextCompat.getDrawable(details_learning_video.this, R.drawable.smiley_face));

                    AlertDialog.Builder builder = new AlertDialog.Builder(details_learning_video.this);
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
                        }
                    });
                }
            });
        }


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "";
    }
}