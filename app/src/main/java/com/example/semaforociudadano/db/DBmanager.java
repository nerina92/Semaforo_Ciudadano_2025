package com.example.semaforociudadano.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.semaforociudadano.User;
import com.example.semaforociudadano.Datos;

public class DBmanager {

    // Tabla User
    public static final String TABLA_USER = "user";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_USER = "user";
    public static final String COL_PASSWORD = "password";
    public static final String COL_STATE = "state";
    public static final String COL_TYPE = "type";

    // Tabla Datos
    public static final String TABLA_DATOS = "datos";
    public static final String COL_DATOS_ID = "id";
    public static final String COL_LIMPIEZA = "limpieza";
    public static final String COL_MANTENIMIENTO = "mantenimiento";
    public static final String COL_ORDENAMIENTO = "ordenamiento";
    public static final String COL_ESPACIO_VERDE = "espacio_verde";
    public static final String COL_MASCOTAS = "mascotas";
    public static final String COL_INFRAESTRUCTURA = "infraestructura";
    public static final String COL_SEGURIDAD = "seguridad";
    public static final String COL_TRATAMIENTO_BASURA = "tratamiento_basura";
    //public static final Object CREATE_USER = ;

    // Database Name
    private static final String DATABASE_NAME = "semaforo_ciudadano_db";
    private static final int DATABASE_VERSION = 1;

    // User table create statement
    public static final String CREATE_USER = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, user TEXT NOT NULL, password TEXT NOT NULL, state TEXT, type TEXT);";


    // Datos table create statement
    private static final String CREATE_DATOS_TABLE = "CREATE TABLE " + TABLA_DATOS + "("
            + COL_DATOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_LIMPIEZA + " INTEGER,"
            + COL_MANTENIMIENTO + " INTEGER,"
            + COL_ORDENAMIENTO + " INTEGER,"
            + COL_ESPACIO_VERDE + " INTEGER,"
            + COL_MASCOTAS + " INTEGER,"
            + COL_INFRAESTRUCTURA + " INTEGER,"
            + COL_SEGURIDAD + " INTEGER,"
            + COL_TRATAMIENTO_BASURA + " INTEGER"
            + ");";

    private DBconexion conexion;
    private SQLiteDatabase baseDeDatos;

    public DBmanager(Context context) {
        this.conexion = new DBconexion(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBmanager open() throws SQLException {
        baseDeDatos = conexion.getWritableDatabase();
        return this;
    }

    public void close() {
        conexion.close();
    }

    public boolean insertUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, user.getName());
        contentValues.put(COL_USER, user.getUser());
        contentValues.put(COL_PASSWORD, user.getPassword());
        contentValues.put(COL_STATE, user.getState());
        contentValues.put(COL_TYPE, user.getType());

        long resultado = baseDeDatos.insert(TABLA_USER, null, contentValues);
        return resultado != -1;
    }

    public User getUser(String username) {
        String[] columns = {COL_ID, COL_NAME, COL_USER, COL_PASSWORD, COL_STATE, COL_TYPE};
        String selection = COL_USER + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = baseDeDatos.query(TABLA_USER, columns, selection, selectionArgs, null, null, null);
        User user = null;

        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
            String userUsername = cursor.getString(cursor.getColumnIndex(COL_USER));
            String password = cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
            String state = cursor.getString(cursor.getColumnIndex(COL_STATE));
            String type = cursor.getString(cursor.getColumnIndex(COL_TYPE));

            user = new User(id, name, userUsername, password, state, type);
        }

        cursor.close();
        return user;
    }

    public boolean isUserExist(String username) {
        String[] columns = {COL_USER};
        String selection = COL_USER + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = baseDeDatos.query(TABLA_USER, columns, selection, selectionArgs, null, null, null);
        boolean exist = cursor.getCount() > 0;

        cursor.close();
        return exist;
    }

    public boolean insertDatos(Datos datos) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_LIMPIEZA, datos.getLimp());
        contentValues.put(COL_MANTENIMIENTO, datos.getMant());
        contentValues.put(COL_ORDENAMIENTO, datos.getOrden());
        contentValues.put(COL_ESPACIO_VERDE, datos.getEspacioVerde());
        contentValues.put(COL_MASCOTAS, datos.getMascotas());
        contentValues.put(COL_INFRAESTRUCTURA, datos.getInfra());
        contentValues.put(COL_SEGURIDAD, datos.getSeguridad());
        contentValues.put(COL_TRATAMIENTO_BASURA, datos.getBasura());

        long resultado = baseDeDatos.insert(TABLA_DATOS, null, contentValues);
        return resultado != -1;
    }
}
