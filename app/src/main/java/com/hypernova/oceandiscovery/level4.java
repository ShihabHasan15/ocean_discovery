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

public class level4 extends AppCompatActivity {

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
        setContentView(R.layout.activity_level4);

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
        sliderItems.add(new SliderItem(R.drawable.understanding_ocean_color_photo));
        sliderItems.add(new SliderItem(R.drawable.ocean_quiz_photo));


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

                if (position==0) {
                    details_learning_video.lay_count=9;
                    lesson_name.setText("Sea Level Analysis");
                    play_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(level4.this, sea_level_statistics.class));
                        }
                    });
                } else if (position==1) {
                    lesson_name.setText("Ocean Quiz");
                    play_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            startActivity(new Intent(getApplicationContext(), details_learning_video.class));
//                            finish();
                        }
                    });
                }
            }
        });

    }
}