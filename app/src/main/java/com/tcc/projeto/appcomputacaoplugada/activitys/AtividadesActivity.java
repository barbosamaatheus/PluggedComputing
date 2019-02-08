package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;
import com.tcc.projeto.appcomputacaoplugada.objetos.Atividade;
import com.tcc.projeto.appcomputacaoplugada.adapter.CardAdapter;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.RecyclerViewOnClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class AtividadesActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividades);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        initviews();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    private void initviews() {
        myApplication = (MyApplication) getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_atividades);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CardAdapter(this, getAtividadesList());
        mAdapter.setRecyclerViewOnClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<Atividade> getAtividadesList() {
        List<Atividade> atividadesList = new ArrayList<Atividade>();
        atividadesList.add(new Atividade("Contando os Pontos", "Números Binários", getString(R.string.descricao_card),
                "Matematica", "Contar,\nCorrelacionar,\nOrdenar", "A partir de 7 anos"));
        //atividadesList.add(new Atividade("Titulo", "SubTitulo", "Isso aqui é só uma demostração de como vai ficar quendo" +
        //"tiver mais de uma atividade para ser escolhida", "Materia", "Habilidades, Habilidades, Habilidades", "Idade"));
        return atividadesList;
    }

    @Override
    public void onClickListener(View view, int positon) {
        switch (positon + 1) {
            case 1:
                Intent intent = new Intent(getApplicationContext(), ExerciciosActivity.class);
                startActivity(intent);
                break;
        }

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
