package com.example.semaforociudadano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class cargardatos : AppCompatActivity() {
    private lateinit var editTextLimpieza: EditText
    private lateinit var editTextMantenimiento: EditText
    private lateinit var editTextEspaciosVerdes: EditText
    private lateinit var editTextInfraestructuras: EditText
    private lateinit var editTextSeguridad: EditText
    private lateinit var editTextActividades: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargardatos)

        val barrioSeleccionado = intent.getStringExtra("barrio")
        val textViewBarrio = findViewById<TextView>(R.id.textViewBarrio)
        textViewBarrio.text = barrioSeleccionado

        editTextLimpieza = findViewById(R.id.editTextLimpieza)
        editTextMantenimiento = findViewById(R.id.editTextMantenimiento)
        editTextEspaciosVerdes = findViewById(R.id.editTextEspaciosVerdes)
        editTextInfraestructuras = findViewById(R.id.editTextInfraestructuras)
        editTextSeguridad = findViewById(R.id.editTextSeguridad)
        editTextActividades = findViewById(R.id.editTextActividades)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener {
            if (validarDatos()) {
                val puntuacionLimpieza = editTextLimpieza.text.toString().toInt()
                val puntuacionMantenimiento = editTextMantenimiento.text.toString().toInt()
                val puntuacionEspaciosVerdes = editTextEspaciosVerdes.text.toString().toInt()
                val puntuacionInfraestructuras = editTextInfraestructuras.text.toString().toInt()
                val puntuacionSeguridad = editTextSeguridad.text.toString().toInt()
                val puntuacionActividades = editTextActividades.text.toString().toInt()

                // Aquí puedes hacer lo que desees con los datos ingresados
                // Por ejemplo, guardarlos en la base de datos

                Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingrese valores válidos para todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnIrAHome = findViewById<Button>(R.id.btnIrAHome)
        btnIrAHome.setOnClickListener {
            startActivity(Intent(this, home::class.java))
            finish()
        }
    }

    private fun validarDatos(): Boolean {
        val puntuacionLimpieza = editTextLimpieza.text.toString()
        val puntuacionMantenimiento = editTextMantenimiento.text.toString()
        val puntuacionEspaciosVerdes = editTextEspaciosVerdes.text.toString()
        val puntuacionInfraestructuras = editTextInfraestructuras.text.toString()
        val puntuacionSeguridad = editTextSeguridad.text.toString()
        val puntuacionActividades = editTextActividades.text.toString()

        return (puntuacionLimpieza.isNotEmpty() && puntuacionMantenimiento.isNotEmpty() &&
                puntuacionEspaciosVerdes.isNotEmpty() && puntuacionInfraestructuras.isNotEmpty() &&
                puntuacionSeguridad.isNotEmpty() && puntuacionActividades.isNotEmpty())
    }
}
