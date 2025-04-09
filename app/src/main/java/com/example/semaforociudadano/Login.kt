package com.example.semaforociudadano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.semaforociudadano.db.DBmanager

class Login : AppCompatActivity() {
    lateinit var dbManager: DBmanager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val editTextUser = findViewById<EditText>(R.id.Usuario)
        val editTextClave = findViewById<EditText>(R.id.Clave)
        val btnAcceder = findViewById<Button>(R.id.btnAcceder)
        // val btnBuscar = findViewById<Button>(R.id.btnBuscar)

        dbManager = DBmanager(this)
        dbManager.open()

        btnAcceder.setOnClickListener{
            val usuario = editTextUser.text.toString()
            val clave = editTextClave.text.toString()

            val user = dbManager.getUser(usuario)
            if (user != null) {
                if (user.password == clave) {
                    println("usuario logueado")

                    val intent = Intent(this@Login, home::class.java)
                    startActivity(intent)
                    finish() // Esto cierra la actividad actual para que el usuario no pueda volver atrás con el botón de retroceso


                } else {
                    Toast.makeText(this, "Clave incorrecta", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.close()
    }
}
