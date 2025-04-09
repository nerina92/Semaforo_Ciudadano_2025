package com.example.semaforociudadano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class home : AppCompatActivity() , AdapterView.OnItemSelectedListener{
    private lateinit var spinner: Spinner
    private var selectedOption: String =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        spinner = findViewById(R.id.spinner)
        selectedOption = ""

        // Lista de opciones para el Spinner
        val barrios = arrayOf(
            "Seleccione Barrio",
            "Barrio Padre Miguel Pou",
            "Barrio Parque Rural",
            "Barrio Presidente Arturo Humberto Illia",
            "Barrio Jardin",
            "Barrio Pueyrredon",
            "Barrio Tradición Argentina",
            "Barrio \"17 de Octubre\"",
            "Barrio Mercantil \"13 de Julio\"",
            "Barrio Santa Teresa del Niño Jesús",
            "Barrio Santa Rita",
            "Barrio Chacarita",
            "Barrio Centro Civico de la Ciudad de Laboulaye",
            "Barrio Estudiantil",
            "Barrio La Terminal",
            "Barrio Las Cortinas",
            "Barrio F.E.L."
        )

        // Adaptador para el Spinner
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, barrios)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            if (selectedOption != "Seleccione Barrio") {
                // Aquí puedes hacer lo que desees con la opción seleccionada
                Toast.makeText(this, "Opción seleccionada: $selectedOption", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@home, cargardatos::class.java)
                intent.putExtra("barrio", selectedOption)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Seleccione una opción válida", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        selectedOption = spinner.selectedItem.toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Manejar el caso cuando no se ha seleccionado ninguna opción
    }
}
