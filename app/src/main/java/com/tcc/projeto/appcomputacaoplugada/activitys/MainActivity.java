package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tcc.projeto.appcomputacaoplugada.R;

public class MainActivity extends AppCompatActivity {
    private Button mInicar, mSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        mInicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AtividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void initViews(){
        mInicar = (Button) findViewById(R.id.btn_iniciar);
        mSobre = (Button) findViewById(R.id.btn_sobre);
    }
}
