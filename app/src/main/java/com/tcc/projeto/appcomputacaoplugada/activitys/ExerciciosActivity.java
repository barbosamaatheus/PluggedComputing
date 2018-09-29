package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.RecyclerViewOnClickListener;
import com.tcc.projeto.appcomputacaoplugada.adapter.ExercicioAdapter;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;
import com.tcc.projeto.appcomputacaoplugada.objetos.Atividade;
import com.tcc.projeto.appcomputacaoplugada.objetos.Exercicio;

import java.util.ArrayList;
import java.util.List;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class ExerciciosActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private RecyclerView mRecyclerView;
    private ExercicioAdapter mAdapter;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        initviews();

    }

    private void initviews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_exercicios);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        myApplication = (MyApplication) getApplicationContext();
        mAdapter = new ExercicioAdapter(this, getExerciciosList(), myApplication.getPositionExercicio());
        mAdapter.setRecyclerViewOnClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public String[] getExerciciosList() {
        String[] exerciciosList = new String[]{
                "Introdução", "Números Binários", "Trabalhar com Números Binários", "Enviar Mensagens Secretas", "Correio Eletrônico e Modems", "Contar acima de 31", "Mais Sobre Números Binários",
                "De que se trata tudo isso?"
        };
        return exerciciosList;
    }


    @Override
    public void onClickListener(View view, int positon) {
        Intent intent = new Intent(getApplicationContext(), TarefaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("positon", positon + 1);
        intent.putExtras(bundle);
        startActivity(intent);
       /* if (positon >= myApplication.getPositionExercicio()) {
            Intent intent = new Intent(getApplicationContext(), TarefaActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("positon", positon + 1);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            onCreateDialog();
        }*/

    }

    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ExerciciosActivity.this, R.style.DialogStyle);
        builder.setMessage("Você ainda não liberou este exercicio. Complete as atividades anteriores para desbloquear")
                .setTitle("Algo deu errado :(");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

