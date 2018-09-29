package com.tcc.projeto.appcomputacaoplugada.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BD {
    private SQLiteDatabase database;

    public BD(Context context) {
        BDCore auxBD = new BDCore(context);
        database = auxBD.getWritableDatabase();
    }

    public void add(int position) {
        ContentValues values = new ContentValues();
        values.put("position", position);
        database.insert("registros", null, values);
    }

    public void update(int position) {
        ContentValues values = new ContentValues();
        values.put("position", position);
        database.update("registros", values, "_id = ?", new String[]{"1"});
    }

    public void delete(int position) {
        database.delete("registros", "_id = ?" + "1", null);
    }

    public List<Integer> read() {
        List<Integer> positions = new ArrayList<Integer>();
        String[] colunas = new String[]{"_id", "position"};

        Cursor cursor = database.query("registros", colunas, null, null, null, null, "position");
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                positions.add(cursor.getInt(1));
            }while (cursor.moveToNext());
        }
        return positions;
    }
}
