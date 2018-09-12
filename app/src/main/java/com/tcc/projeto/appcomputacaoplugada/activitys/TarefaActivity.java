package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.fragments.IntroducaoFragment;

public class TarefaActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);
        initFragment();
    }
    private void initFragment() {
        FragmentTransaction ft = fm.beginTransaction();
        IntroducaoFragment introducaoFragment = new IntroducaoFragment();
        ft.add(R.id.fragment_content, introducaoFragment);
        ft.commit();
    }

}
