package com.hypernova.oceandiscovery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class learning_activity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private TextView lesson_name;
    private ImageView cross_btn;
    public static int learning_content = 0;
    MaterialCardView play_btn;
    public static int levels = 0;
    public static List<SliderItem> sliderItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        cross_btn = findViewById(R.id.cross_btn);
        viewPager2 = findViewById(R.id.viewpage);
        lesson_name = findViewById(R.id.lesson_name);
        play_btn = findViewById(R.id.play_btn);

        cross_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


            sliderItems = new ArrayList<>();
            sliderItems.add(new SliderItem(R.drawable.ocene_stories_slide_image));
            sliderItems.add(new SliderItem(R.drawable.phytoplankton_fighter));
            sliderItems.add(new SliderItem(R.drawable.aerosol_and_cloud));
            sliderItems.add(new SliderItem(R.drawable.save_the_ocean_photo));

            viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setOffscreenPageLimit(3);
            viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r*0.15f);
                }
            });



            viewPager2.setPageTransformer(compositePageTransformer);


            viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                    if (position==0){
                        lesson_name.setText("Ocean Stories");
                        play_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(learning_activity.this, details_learning.class));
                            }
                        });
                    } else if (position==1) {
                        lesson_name.setText("Phyto Fighters");
                        play_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(learning_activity.this, phyto_fighters.class));
                            }
                        });
                    } else if (position==2) {
                        lesson_name.setText("Aerosol and Cloud");
                        play_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                details_learning_video.lay_count=1;
                                startActivity(new Intent(learning_activity.this, aerosol_cloud.class));
                            }
                        });
                    }else if (position==3) {
                        lesson_name.setText("sAVE tHE OCEAN");
                        play_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getApplicationContext(), save_the_ocean_game.class));
                                finish();
                            }
                        });
                    }
                }
            });
        }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}