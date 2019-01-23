package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {
    private Button mInicar, mSobre;
    private ImageButton mSound;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        initViews();
        myApplication.showNotification("Bem vindo!");

        mInicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myApplication.setPositionExercicio(0);
                myApplication.readDataBase();
                //myApplication.deleteDataBase();
                Intent intent = new Intent(getApplicationContext(), AtividadesActivity.class);
                startActivity(intent);
            }
        });

        mSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog();
            }
        });

        mSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myApplication.isOnSound()) {
                    mSound.setImageResource(R.drawable.ic_volume_off_black_24dp);
                    myApplication.onPauseMusic();
                    myApplication.setOnSound(false);
                } else {
                    mSound.setImageResource(R.drawable.ic_volume_up_black_24dp);
                    myApplication.onStartMusic(R.raw.music);
                    myApplication.setOnSound(true);
                }

            }
        });

    }

    private void initViews() {
        myApplication = (MyApplication) getApplicationContext();
        mInicar = (Button) findViewById(R.id.btn_iniciar);
        mSobre = (Button) findViewById(R.id.btn_sobre);
        mSound = (ImageButton) findViewById(R.id.sound);
    }

    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogThemeOld);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme);
            builder.setView(R.layout.alert_sobre);
        }else{
            builder.setMessage(R.string.sobre_total).setTitle("Sobre").setIcon(R.drawable.ic_help_outline_black_24dp);
        }
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
