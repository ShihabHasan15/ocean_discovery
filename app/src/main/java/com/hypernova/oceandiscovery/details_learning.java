package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class details_learning extends AppCompatActivity {

    ImageView imageView;
    MaterialCardView nextBtn;
    Context context;

    public static int inflate_will = 0;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_learning);

        Animation swipe_anim = AnimationUtils.loadAnimation(details_learning.this, R.anim.swipe_anim);
        Animation button_anim = AnimationUtils.loadAnimation(details_learning.this, R.anim.button_anim);
        Animation pop_up_anim = AnimationUtils.loadAnimation(details_learning.this, R.anim.pop_up);


        imageView = findViewById(R.id.image);
        nextBtn = findViewById(R.id.next_btn);


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
                emoji.setImageDrawable(ContextCompat.getDrawable(details_learning.this, R.drawable.excited));

                AlertDialog.Builder builder = new AlertDialog.Builder(details_learning.this);
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

        AlertDialog.Builder alert = new AlertDialog.Builder(details_learning.this);

        Animation swipeAnimation = AnimationUtils.loadAnimation(details_learning.this, R.anim.swipe_anim);



        if (inflate_will==0) {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.alert_learning_dialog, null);

            view.startAnimation(swipeAnimation);

            MaterialCardView option1 = view.findViewById(R.id.materialCardView3);
            MaterialCardView option2 = view.findViewById(R.id.materialCardView5);
            MaterialCardView option3 = view.findViewById(R.id.materialCardView6);
            MaterialCardView option4 = view.findViewById(R.id.materialCardView7);


            alert.setView(view);

            AlertDialog dialog1 = alert.create();

            option1.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {

                    dialog1.dismiss();

                    v.startAnimation(button_anim);
                    v.setBackgroundColor(R.color.red);

                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                    view.startAnimation(swipeAnimation);

                    TextView header_txt = view.findViewById(R.id.textView3);
                    TextView detail_text = view.findViewById(R.id.detail_txt);
                    ImageView emoji = view.findViewById(R.id.imageView9);

                    MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                    header_txt.setText("You Are Right!!");
                    detail_text.setText("Yes, oceans cover approximately 70% of the Earth's surface, making them a vital component of our planet's ecosystem.");

                    emoji.setImageDrawable(ContextCompat.getDrawable(details_learning.this, R.drawable.smiley_face));

                    AlertDialog.Builder builder = new AlertDialog.Builder(details_learning.this);
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
                            v.startAnimation(button_anim);

                            LayoutInflater inflater = getLayoutInflater();
                            View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                            view.startAnimation(swipeAnimation);

                            TextView header_txt = view.findViewById(R.id.textView3);
                            TextView detail_text = view.findViewById(R.id.detail_txt);

                            MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                            header_txt.setText("You Are Right!!");
                            detail_text.setText(" They play a crucial role in regulating the climate, supporting marine life, and providing resources for humans. The vast expanse of oceans also helps in carbon absorption and oxygen production, " +
                                    "contributing to the overall health of the planet.");


                            AlertDialog.Builder builder = new AlertDialog.Builder(details_learning.this);
                            builder.setView(view);

                            AlertDialog dialog3 = builder.create();

                            dialog3.setCancelable(false);

                            dialog3.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                            WindowManager.LayoutParams lp = dialog3.getWindow().getAttributes();
                            lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
                            dialog3.getWindow().setAttributes(lp);

                            dialog3.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                            dialog3.show();

                            next_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    dialog3.dismiss();
                                    v.startAnimation(button_anim);

                                    LayoutInflater inflater = getLayoutInflater();
                                    View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                                    view.startAnimation(swipeAnimation);

                                    TextView header_txt = view.findViewById(R.id.textView3);
                                    TextView detail_text = view.findViewById(R.id.detail_txt);
                                    TextView next_btn_txt = view.findViewById(R.id.next_btn_txt);

                                    MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                                    header_txt.setText("");
                                    detail_text.setText("Ok, Let's Learn more about ocean");
                                    detail_text.setTextSize(35);


                                    AlertDialog.Builder builder = new AlertDialog.Builder(details_learning.this);
                                    builder.setView(view);

                                    AlertDialog dialog4 = builder.create();

                                    dialog4.setCancelable(false);

                                    dialog4.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                                    WindowManager.LayoutParams lp = dialog4.getWindow().getAttributes();
                                    lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
                                    dialog4.getWindow().setAttributes(lp);

                                    dialog4.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                                    dialog4.show();

                                    next_btn_txt.setText("Go");

                                    next_btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog4.dismiss();
                                        }
                                    });

                                }
                            });
                        }
                    });


                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            dialog1.setCancelable(false);

            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            WindowManager.LayoutParams lp = dialog1.getWindow().getAttributes();
            lp.dimAmount = 0.6f;  // Adjust this value to increase or decrease the dim
            dialog1.getWindow().setAttributes(lp);

            dialog1.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialog1.show();


        } else if (inflate_will==1) {


        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}