package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tcc.projeto.appcomputacaoplugada.R;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class SplashActivity extends AppCompatActivity implements Runnable {
    private static final long delay = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        try {
            showAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Handler handler = new Handler();
        handler.postDelayed(this, delay);
    }

    private void showAnimation() {
        YoYo.with(Techniques.Tada)
                .duration(3000)
                .repeat(0)
                .playOn(findViewById(R.id.img_splash));
    }

    @Override
    public void run() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
