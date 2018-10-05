package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {
    private Button mInicar, mSobre;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        initViews();
        onCreateDialog("Notas da versão 1.8.+", "1. Correção do bug com textos com acento; \n" +
                "2. Correção do bug com textos com espaço; \n " +
                "3. Melhoria na tela de Correio eletronico e modems; \n" +
                "4. Mudança na cor de destaque dos campos de captura de texto de preto para branco \n" +
                "5. Correção de alguns textos no app; \n" +
                "6. Implementado Floating nos campos de captura de texto; \n" +
                "7. Melhorias no codigo; \n" +
                "8. Notas da versão atualizadas; \n" +
                "9. Tarefas: Mais sobre numeros binarios e De que se trata tudo isso\n" +
                "10. Vibrações implementadas\n" +
                "11. Mudança na tela de escolha de exercicios" +
                "*Cadeados desativados para versão de testes", R.drawable.ic_error_outline_black_24dp);
        mInicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myApplication.readDataBase();
                myApplication.setPositionExercicio(0);
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

    }

    private void initViews() {
        myApplication = (MyApplication) getApplicationContext();
        mInicar = (Button) findViewById(R.id.btn_iniciar);
        mSobre = (Button) findViewById(R.id.btn_sobre);
    }

    @SuppressLint("NewApi")
    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(R.layout.alert_sobre);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void onCreateDialog(String title, String mensagem, int icon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyle);
        builder.setMessage(mensagem).setTitle(title).setIcon(icon);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
