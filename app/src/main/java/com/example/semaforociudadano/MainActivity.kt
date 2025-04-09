package com.example.semaforociudadano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.semaforociudadano.db.DBmanager


class MainActivity : AppCompatActivity() {

    lateinit var  dbManager: DBmanager
    var admin: User = User(1,"administrador", "admin", "123456", "activo", "superadmin");

    override fun onCreate(savedInstanceState: Bundle?) {
        println("************")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGuest = findViewById<Button>(R.id.btnGuest)
        val btnAdmin = findViewById<Button>(R.id.btnAdmin)
        dbManager = DBmanager(this);
        dbManager.open();
        val result:Boolean=dbManager.insertUser(admin);
        if(result){
            println("Se insertó correctamente el registro")
            Log.d("INSERT","Se insertó correctamente el registro")
        }else{
            Log.d("INSERT","No se pudo insertar el registro")
        }
        dbManager.close();


        btnGuest.setOnClickListener {
            // Abre la actividad de invitado
            val intent = Intent(this@MainActivity, MapaBarrios::class.java)
            startActivity(intent)
        }

        btnAdmin.setOnClickListener {
            // Abre la actividad de administrador
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
        }
    }
}



