package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;

public class SobreActivity extends AppCompatActivity {
    private TextView textoSobre, textCreditos;
    private MyApplication myApplication;
    private boolean inAplication = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        myApplication = (MyApplication) getApplicationContext();
        textoSobre = (TextView) findViewById(R.id.textoSobre);
        textCreditos = (TextView) findViewById(R.id.creditos);
    }
    @Override
    public void onBackPressed() {
        inAplication = true;
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
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
}
