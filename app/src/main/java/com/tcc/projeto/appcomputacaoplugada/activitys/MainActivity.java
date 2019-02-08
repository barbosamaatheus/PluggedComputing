package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {
    private Button mInicar, mSobre;
    private ImageButton mSound;
    private MyApplication myApplication;
    private boolean sair = false;
    private boolean inAplication = false;

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
                //myApplication.setPositionExercicio(0);
                myApplication.readDataBase();
                //myApplication.deleteDataBase();
                inAplication = true;
                Intent intent = new Intent(getApplicationContext(), AtividadesActivity.class);
                startActivity(intent);
            }
        });

        mSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inAplication = true;
                Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(intent);
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(!inAplication){
            myApplication.onPauseMusicInAplication();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (myApplication.isOnSound()){
            myApplication.onStartMusic(R.raw.music);
        }
    }
    @Override
    public void onBackPressed() {
        if(sair){
            myApplication.updateDataBase();
            myApplication.onStopMusic();
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Prescione novamente para sair", Toast.LENGTH_SHORT).show();
            sair = true;
        }
    }

    private void initViews() {
        myApplication = (MyApplication) getApplicationContext();
        mInicar = (Button) findViewById(R.id.btn_iniciar);
        mSobre = (Button) findViewById(R.id.btn_sobre);
        mSound = (ImageButton) findViewById(R.id.sound);
    }

}
