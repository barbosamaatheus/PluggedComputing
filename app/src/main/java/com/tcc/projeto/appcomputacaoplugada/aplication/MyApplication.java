package com.tcc.projeto.appcomputacaoplugada.aplication;

import android.app.Application;

import com.tcc.projeto.appcomputacaoplugada.database.BD;

public class MyApplication extends Application {
    private int positionExercicio;
    private BD database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = new BD(this);
    }

    public void addDataBase() {
        database.add(getPositionExercicio());
    }

    public void updateDataBase() {
        database.update(getPositionExercicio());
    }

    public void deleteDataBase() {
        database.delete(getPositionExercicio());
    }

    public void readDataBase() {
        setPositionExercicio(database.read().get(0));
    }

    public int getPositionExercicio() {
        return positionExercicio;
    }

    public void setPositionExercicio(int positionExercicio) {
        this.positionExercicio = positionExercicio;
    }
}
