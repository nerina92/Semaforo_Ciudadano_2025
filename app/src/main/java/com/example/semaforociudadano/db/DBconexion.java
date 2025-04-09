package com.example.semaforociudadano.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBconexion extends SQLiteOpenHelper  {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    public DBconexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    /*public void DatabaseHelper(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }*/
    // Método donde se crean las tablas correspondientes
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables
        db.execSQL(DBmanager.CREATE_USER);
        System.out.println("Tabla Usuarios creada");
    }
    // Métodos donde se actualizan las tablas
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
      db.execSQL("DROP TABLE IF EXISTS " + DBmanager.TABLA_USER);
        // Create tables again
        onCreate(db);
    }
}