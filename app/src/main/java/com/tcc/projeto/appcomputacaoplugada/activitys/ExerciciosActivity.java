package com.tcc.projeto.appcomputacaoplugada.activitys;

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
import com.tcc.projeto.appcomputacaoplugada.objetos.Atividade;
import com.tcc.projeto.appcomputacaoplugada.objetos.Exercicio;

import java.util.ArrayList;
import java.util.List;

public class ExerciciosActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private RecyclerView mRecyclerView;
    private ExercicioAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);
        initviews();
        mostrarFinalizados();
    }

    private void mostrarFinalizados() {

    }

    private void initviews(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_exercicios);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ExercicioAdapter(this, getExerciciosList());
        mAdapter.setRecyclerViewOnClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public String[] getExerciciosList() {
        String [] exerciciosList = new String[]{
                "Introdução","Números Binários","Trabalhar com Números Binários","Enviar Mensagens Secretas","Correio Eletrônico e Modems","Contar acima de 31","Mais Sobre Números Binários",
                "De que se trata tudo isso?"
        };

        Log.d("onBindViewHolder", "getExerciciosList: " + exerciciosList.toString());
        return exerciciosList;
    }


    @Override
    public void onClickListener(View view, int positon) {
        Intent intent = new Intent(getApplicationContext(), TarefaActivity.class);
        startActivity(intent);
        finish();


    }
}

