package com.hypernova.oceandiscovery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.res.ResourcesCompat;

import java.util.Random;
import java.util.logging.LogRecord;

public class GameView extends View {

    int dWidth, dHeight, handX, handY, wasteX, wasteY, handSpeed, wasteSpeed, binX, binY;
    Bitmap waste, hand, bin, background;
    Handler handler;
    Runnable runnable;
    long UPDATE_MILLIS = 30;
    Random random;
    boolean wasteAnim = false;
    int points = 0, life = 1; // Life is set to 1
    Paint text_paint;
    Context context;

    public GameView(Context context) {
        super(context);
        this.context = context;
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;


        // Load and scale bitmaps to smaller sizes
        waste = BitmapFactory.decodeResource(getResources(), R.drawable.wastage);
        hand = BitmapFactory.decodeResource(getResources(), R.drawable.hand);
        bin = BitmapFactory.decodeResource(getResources(), R.drawable.bin);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.save_the_ocean_game_bg);

        // Scale bitmaps down to smaller sizes
        waste = Bitmap.createScaledBitmap(waste, waste.getWidth() / 6, waste.getHeight() / 6, false);
        hand = Bitmap.createScaledBitmap(hand, hand.getWidth() / 6, hand.getHeight() / 6, false);
        bin = Bitmap.createScaledBitmap(bin, bin.getWidth() / 6, bin.getHeight() / 6, false);
        background = Bitmap.createScaledBitmap(background, dWidth, dHeight, false);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate(); // Redraw the screen
            }
        };

        random = new Random();

        resetPositions();

        Typeface typeface = ResourcesCompat.getFont(context, R.font.digitalt);

        text_paint = new Paint();
        text_paint.setColor(Color.BLACK);
        text_paint.setTypeface(typeface);
        text_paint.setTextSize(60); // Set to 18sp equivalent
        text_paint.setTextAlign(Paint.Align.CENTER); // Align text to the top-right

        binX = dWidth / 2 - bin.getWidth() / 2;
        binY = dHeight - bin.getHeight() - 50; // Bin moved slightly up
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        // Draw the background
        canvas.drawBitmap(background, 0, 0, null);

        // Update the hand and waste positions
        if (!wasteAnim) {
            handX -= handSpeed; // Hand keeps moving from right to left
            wasteX = handX; // Waste follows hand's horizontal movement
            wasteY = handY + hand.getHeight(); // Waste is just below the hand\\

        } else {
            wasteY += wasteSpeed; // Waste falls down when wasteAnim is true
        }

        // Draw the objects
        canvas.drawBitmap(bin, binX, binY, null); // Draw bin
        canvas.drawBitmap(hand, handX, handY, null); // Draw hand
        canvas.drawBitmap(waste, wasteX, wasteY, null); // Draw waste

        // Check if waste is caught by the bin
        if (wasteAnim && wasteY + waste.getHeight() >= binY && wasteX + waste.getWidth() >= binX && wasteX <= binX + bin.getWidth()) {
            points++; // Increment points
            resetPositions(); // Reset hand and waste positions
            wasteAnim = false; // Waste has been caught
        }

        // Check if waste has fallen off the screen (missed by the bin)
        if (wasteY + waste.getHeight() >= dHeight) {
            life--; // Decrease life
            if (life == 0) {
                endGame(); // Trigger game over if the waste was missed
            } else {
                resetPositions(); // Reset positions for the next round
                wasteAnim = false;
            }
        }

        // If hand moves out of the screen, reset its position for continuous movement
        if (handX + hand.getWidth() < 0) {
            resetHand(); // Hand moves back from the right side
        }

        // Draw the points on the screen in the top-right corner
        canvas.drawText("" + points, dWidth - 370, 100, text_paint);

        // Post the update
        if (life != 0) {
            handler.postDelayed(runnable, UPDATE_MILLIS);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                // Move the bin to follow the horizontal touch movement
                binX = (int) touchX - bin.getWidth() / 2;
                break;
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (!wasteAnim && touchX >= handX && touchX <= (handX + hand.getWidth())
                    && event.getY() >= handY && event.getY() <= (handY + hand.getHeight())) {
                wasteAnim = true; // Activate waste animation when hand is touched
            }
        }
        return true;
    }

    private void resetPositions() {
        // Random position for the hand
        handX = dWidth + random.nextInt(300); // Hand starts off-screen to the right
        handY = random.nextInt(600); // Random vertical position
        // Position waste just below the hand
        wasteX = handX;
        wasteY = handY + hand.getHeight();
        // Random speed for the hand and waste
        handSpeed = 15 + random.nextInt(10); // Hand speed varies
        wasteSpeed = 10 + random.nextInt(20); // Waste speed varies
    }

    private void resetHand() {
        // Reset hand position off-screen to the right for continuous movement
        handX = dWidth + random.nextInt(300);
        handY = random.nextInt(600);
        wasteX = handX;
        wasteY = handY + hand.getHeight();
        handSpeed = 15 + random.nextInt(10); // Adjust speed for variability
    }

    private void endGame() {
        Intent intent = new Intent(context, GameOver.class);
        intent.putExtra("points", points);
        context.startActivity(intent);

        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }

    }
}






