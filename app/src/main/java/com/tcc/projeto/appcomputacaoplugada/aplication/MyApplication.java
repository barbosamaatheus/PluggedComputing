package com.tcc.projeto.appcomputacaoplugada.aplication;

import android.app.Application;

public class MyApplication extends Application {
    private int positionExercicio;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public int getPositionExercicio() {
        return positionExercicio;
    }

    public void setPositionExercicio(int positionExercicio) {
        this.positionExercicio = positionExercicio;
    }
}
