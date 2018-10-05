package com.tcc.projeto.appcomputacaoplugada.aplication;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.activitys.MainActivity;
import com.tcc.projeto.appcomputacaoplugada.database.BD;

public class MyApplication extends Application {
    private static final String CHANNEL_ID = "channel_id";
    private int positionExercicio;
    private BD database;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
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
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "notification", importance);
            channel.setDescription("notification");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showNotification(String msg){
        Intent intent = new Intent(this, ExerciciosActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_sentiment_satisfied_black_24dp)
                .setContentTitle("Computação Plugada")
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, mBuilder.build());
    }

}
