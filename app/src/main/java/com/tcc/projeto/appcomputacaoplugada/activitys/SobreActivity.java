package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;

public class SobreActivity extends AppCompatActivity {
    private TextView textoSobre, textCreditos;
    private MyApplication myApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        myApplication = (MyApplication) getApplicationContext();
        textoSobre = (TextView) findViewById(R.id.textoSobre);
        textCreditos = (TextView) findViewById(R.id.creditos);
    }
    @Override
    protected void onPause() {
        super.onPause();
        myApplication.onMusicInAplication();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (myApplication.isOnSound()){
            myApplication.onStartMusic(R.raw.music);
        }
    }
}
