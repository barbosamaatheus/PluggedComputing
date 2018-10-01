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

        onCreateDialog("Notas da versão 1.6.21", "1. Ajuste no posicionamento dos botões da tela inicial; \n" +
                "2. Correção na segunda questão da tela de NUMEROS BINARIOS; \n " +
                "3. Correção do bug na resposta do enviar mensagens secrestas; \n" +
                "4. Remoção de mensagem de erro nas perguntas; \n" +
                "5. Correção de alguns textos no app; \n" +
                "6. Captura automatica do EditText; \n" +
                "7. Botão de ajuda implementado em todas as terefas;" +
                "8. Melhorias no codigo; \n" +
                "9. Notas da versão implementado; \n" +
                "10. Mudança de estino nas mensagens de alerta \n" +
                "11. Tarefas: Correio eletronico e Modems e Contar a cima de 31 implementadas \n" +
                "12. Mudança na orientação das resposatas da terceira pergunta da segunda tela \n" +
                "13. *Cadeados desativados para versão de testes", R.drawable.ic_error_outline_black_24dp);
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
