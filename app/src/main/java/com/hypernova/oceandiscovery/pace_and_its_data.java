package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.card.MaterialCardView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pace_and_its_data extends AppCompatActivity {

    MaterialCardView next_btn;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_and_its_data);


        Animation swipe_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swipe_anim);

        next_btn = findViewById(R.id.next_btn);
        videoView = findViewById(R.id.video);


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

                detail_text.setText("Lesson 1 Completed");
                detail_text.setTextSize(35);
                emoji.setImageDrawable(ContextCompat.getDrawable(pace_and_its_data.this, R.drawable.excited));

                AlertDialog.Builder builder = new AlertDialog.Builder(pace_and_its_data.this);
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

        header_txt.setText("PACE mission");
        details_txt.setText("The PACE (Plankton, Aerosol, Cloud, ocean Ecosystem) satellite is a NASA mission focused on studying Earth's oceans and atmosphere");


        emoji.setImageDrawable(ContextCompat.getDrawable(pace_and_its_data.this, R.drawable.smiley_face));

        AlertDialog.Builder builder = new AlertDialog.Builder(pace_and_its_data.this);
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

                header_txt.setText("pace mission");
                details_txt.setText("It aims to monitor ocean health, detect phytoplankton, and measure how aerosols and clouds affect climate.");

                emoji.setImageDrawable(ContextCompat.getDrawable(pace_and_its_data.this, R.drawable.smiley_face));

                AlertDialog.Builder builder = new AlertDialog.Builder(pace_and_its_data.this);
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

                        header_txt.setText("pace mission");
                        details_txt.setText("PACE collects data on ocean color, aerosols, and clouds to understand carbon cycles, marine ecosystems, and their impact on climate change");

                        emoji.setImageDrawable(ContextCompat.getDrawable(pace_and_its_data.this, R.drawable.smiley_face));

                        AlertDialog.Builder builder = new AlertDialog.Builder(pace_and_its_data.this);
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

                                LayoutInflater inflater = getLayoutInflater();
                                View view = inflater.inflate(R.layout.ocean_cover_dialog2, null);

                                view.startAnimation(swipe_anim);

                                TextView header_txt = view.findViewById(R.id.textView3);
                                TextView details_txt = view.findViewById(R.id.detail_txt);


                                ImageView emoji = view.findViewById(R.id.imageView9);

                                MaterialCardView next_btn = view.findViewById(R.id.next_btn);

                                header_txt.setText("pace mission");
                                details_txt.setText("Let's Learn More About PACE");

                                details_txt.setTextSize(35);

                                emoji.setImageDrawable(ContextCompat.getDrawable(pace_and_its_data.this, R.drawable.smiley_face));

                                AlertDialog.Builder builder = new AlertDialog.Builder(pace_and_its_data.this);
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

                                    }
                                });
                            }
                        });

                    }
                });
            }
        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://images-api.nasa.gov/asset/KSC-20240129-MH-CSH01-0001-PACE_Encapsulation-M3694";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject collection_object = response.getJSONObject("collection");

                    JSONArray items_array = collection_object.getJSONArray("items");

                    JSONObject image = items_array.getJSONObject(3);

                    String result = image.getString("href");

                    Uri video_uri = Uri.parse(result);

                    videoView.setVideoURI(video_uri);
                    videoView.requestFocus();
                    videoView.start();

                    Log.d("image", ""+result);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);

    }
}