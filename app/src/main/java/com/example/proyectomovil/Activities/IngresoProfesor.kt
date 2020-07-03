package com.example.proyectomovil.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.proyectomovil.R

class IngresoProfesor : AppCompatActivity() {



    lateinit var opciones:Spinner
    private var arrayAdapter: ArrayAdapter<String>? = null
    private var array = arrayOf("0265 - Matemática", "0250 - Razonamiento Verbal", "0300 - Biología", "0150 - Geografía")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_profesor)

        opciones = findViewById<Spinner>(R.id.ingresoPspidcurso)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, array)
        opciones?.adapter = arrayAdapter

    }


}