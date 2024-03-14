package com.alindedu.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        image = findViewById(R.id.imageViewSplash);
        title = findViewById(R.id.textViewSplash);

        int startColor = ContextCompat.getColor(this, R.color.gradient_text_color_start);
        int endColor = ContextCompat.getColor(this, R.color.gradient_text_color_end);
        LinearGradient gradient = new LinearGradient(0, 0, title.getWidth(), title.getLineHeight(), startColor, endColor, Shader.TileMode.CLAMP);
        TextPaint textPaint = title.getPaint();
        textPaint.setShader(gradient);
        title.setPaintFlags(title.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_anim);
        title.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, Login_Page.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}