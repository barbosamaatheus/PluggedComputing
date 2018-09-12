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

    public List<Exercicio> getExerciciosList() {
        List<Exercicio> exerciciosList = new ArrayList<Exercicio>();
        Exercicio exercicio01 = new Exercicio("Introdução");
        Exercicio Exercicio02 = new Exercicio("Números Binários");
        Exercicio Exercicio03 = new Exercicio("Trabalhar com Números Binários");
        Exercicio Exercicio04 = new Exercicio("Enviar Mensagens Secretas");
        Exercicio Exercicio05 = new Exercicio("Correio Eletrônico e Modems");
        Exercicio Exercicio06 = new Exercicio("Contar acima de 31");
        Exercicio Exercicio07 = new Exercicio("Mais Sobre Números Binários");
        Exercicio Exercicio08 = new Exercicio("De que se trata tudo isso?");


        exerciciosList.add(exercicio01);
        exerciciosList.add(Exercicio02);
        exerciciosList.add(Exercicio03);
        exerciciosList.add(Exercicio04);
        exerciciosList.add(Exercicio05);
        exerciciosList.add(Exercicio06);
        exerciciosList.add(Exercicio07);
        exerciciosList.add(Exercicio08);



        Log.d("onBindViewHolder", "getExerciciosList: " + exerciciosList.toString());
        return exerciciosList;
    }


    @Override
    public void onClickListener(View view, int positon) {
        Intent intent = new Intent(getApplicationContext(), ExerciciosActivity.class);
        startActivity(intent);
        finish();


    }
}
/*
<ImageView
                android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_alignParentEnd="true"
                        android:layout_alignParentRight="true"
                        android:layout_centerVertical="true"
                        android:layout_marginEnd="16dp"
                        android:layout_marginRight="16dp"
                        android:src="@drawable/ic_check_black_24dp"
                        android:visibility="gone"/>*/
