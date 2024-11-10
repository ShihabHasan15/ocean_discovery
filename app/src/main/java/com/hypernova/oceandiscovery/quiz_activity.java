package com.hypernova.oceandiscovery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class quiz_activity extends AppCompatActivity {

    private CardView optionACard, optionBCard, optionCCard, optionDCard;
    private TextView optionATxt, optionBTxt, optionCTxt, optionDTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        optionACard = findViewById(R.id.optionACard);
        optionBCard = findViewById(R.id.optionBCard);
        optionCCard = findViewById(R.id.optionCCard);
        optionDCard = findViewById(R.id.optionDCard);

        optionATxt = findViewById(R.id.optionATxt);
        optionBTxt = findViewById(R.id.optionBTxt);
        optionCTxt = findViewById(R.id.optionCTxt);
        optionDTxt = findViewById(R.id.optionDTxt);

        // Set up click listeners for each option
        optionACard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionATxt.getText().toString(), optionACard);
            }
        });

        optionBCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionBTxt.getText().toString(), optionBCard);
            }
        });

        optionCCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionCTxt.getText().toString(), optionCCard);
            }
        });

        optionDCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionDTxt.getText().toString(), optionDCard);
            }
        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void checkAnswer(String selectedAnswer, CardView selectedCard) {
        String correctAnswer = "Phytoplankton";

        if (selectedAnswer.equals(correctAnswer)) {
            // If correct, change the card background color to green
            selectedCard.setCardBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
        } else {
            // If incorrect, change the card background color to red
            selectedCard.setCardBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        }

        // Disable further selections by preventing further clicks
        disableAllOptions();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showResultDialog(selectedAnswer.equals(correctAnswer));
            }
        }, 900);

    }

    // Disable all option cards after the user makes a selection
    private void disableAllOptions() {
        optionACard.setClickable(false);
        optionBCard.setClickable(false);
        optionCCard.setClickable(false);
        optionDCard.setClickable(false);
    }



    private void showResultDialog(boolean isCorrect) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (isCorrect) {
            builder.setTitle("Yea!");
            builder.setMessage("That was the correct answer.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Home_frag.start_btn4.setVisibility(View.VISIBLE);
                    finish();
                }
            });
        } else {
            builder.setTitle("Oops!");
            builder.setMessage("That was not the correct answer.");

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Home_frag.start_btn4.setVisibility(View.VISIBLE);
                }
            });

        }
        builder.show();
    }
}