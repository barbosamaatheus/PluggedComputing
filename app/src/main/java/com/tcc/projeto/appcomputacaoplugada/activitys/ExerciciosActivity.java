package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.RecyclerViewOnClickListener;
import com.tcc.projeto.appcomputacaoplugada.adapter.ExercicioAdapter;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;


import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class ExerciciosActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private RecyclerView mRecyclerView;
    private ExercicioAdapter mAdapter;
    private MyApplication myApplication;
    private boolean inAplication = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        initviews();

    }
    @Override
    public void onBackPressed() {
        inAplication = true;
        Intent intent = new Intent(this, AtividadesActivity.class);
        finish();
        startActivity(intent);
    }

    private void initviews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_exercicios);
        mRecyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mLayoutManager);
        myApplication = (MyApplication) getApplicationContext();
        mAdapter = new ExercicioAdapter(this, getExerciciosList(), myApplication.getPositionExercicio());
        mAdapter.setRecyclerViewOnClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public String[] getExerciciosList() {
        String[] exerciciosList = new String[]{
                "Introdução", "Números Binários", "Trabalhar com Números Binários", "Enviar Mensagens Secretas",
                "Correio Eletrônico", "Contar acima de 31", "Mais Sobre Números Binários","De que se trata tudo isso?"
        };
        return exerciciosList;
    }


    @Override
    public void onClickListener(View view, int positon) {
        if (positon <= myApplication.getPositionExercicio()) {
            inAplication = true;
            callNextActivity(positon);
        } else {
            vibrar();
            showAnimation(view);
            myApplication.onCreateDialog("Algo deu errado","Você ainda não liberou este exercicio. Complete as atividades anteriores para desbloquear"
            ,1, this);
            //callNextActivity(positon);
        }

    }

    private void callNextActivity(int positon) {
        Intent intent = new Intent(getApplicationContext(), TarefaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("positon", positon + 1);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    private void vibrar(){
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long milliseconds = 700;
        vibrator.vibrate(milliseconds);
    }
    private void showAnimation(View view){
        YoYo.with(Techniques.Shake)
                .duration(700)
                .repeat(0)
                .playOn(view);
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

