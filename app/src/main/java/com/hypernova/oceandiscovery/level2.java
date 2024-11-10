package com.hypernova.oceandiscovery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class level2 extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TextView lesson_name;
    private ImageView cross_btn;
    public static int learning_content = 0;
    MaterialCardView play_btn;
    public static int levels = 0;
    public static List<SliderItem> sliderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);


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
        sliderItems.add(new SliderItem(R.drawable.pace_in_space));
        sliderItems.add(new SliderItem(R.drawable.oci_photo));
        sliderItems.add(new SliderItem(R.drawable.harp2));
        sliderItems.add(new SliderItem(R.drawable.spexone_photo));
        sliderItems.add(new SliderItem(R.drawable.match_the_words_photo));

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
                    lesson_name.setText("PACE Satellite and Its Data");
                    play_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(level2.this, pace_and_its_data.class));
                        }
                    });
                } else if (position==1) {
                    lesson_name.setText("OCI (Ocean color instrument)");
                    play_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(level2.this, oci.class));
                        }
                    });
                } else if (position==2) {
                    details_learning_video.lay_count=4;
                    lesson_name.setText("HARP2");
                    play_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(level2.this, Harp2.class));
                        }
                    });
                }else if (position==3) {
                    details_learning_video.lay_count=5;
                    lesson_name.setText("SPEXONE");
                    play_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getApplicationContext(), spex_one.class));
                        }
                    });
                } else if (position==4) {
                    lesson_name.setText("Match the words");
                    play_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getApplicationContext(), word_game.class));
                            finish();
                        }
                    });
                }
            }
        });



    }
}