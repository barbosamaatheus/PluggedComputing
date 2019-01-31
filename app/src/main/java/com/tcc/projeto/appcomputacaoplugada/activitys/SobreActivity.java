package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;

public class SobreActivity extends AppCompatActivity {
    private TextView textoSobre, textCreditos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        textoSobre = (TextView) findViewById(R.id.textoSobre);
        textCreditos = (TextView) findViewById(R.id.creditos);

        setConfigurations();
    }
    private void setConfigurations(){
        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 720) {
            this.textoSobre.setTextSize(25);
            this.textCreditos.setTextSize(35);
        }
    }
}
