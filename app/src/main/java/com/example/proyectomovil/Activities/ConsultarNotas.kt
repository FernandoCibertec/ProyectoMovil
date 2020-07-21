package com.example.proyectomovil.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectomovil.R
import kotlinx.android.synthetic.main.activity_consultar_notas.*
import com.example.proyectomovil.MainActivity.Companion.NombreEstudiante

class ConsultarNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_notas)
        txtBienvenida.setText("Bienvenido, " + NombreEstudiante)

        imageView2.setOnClickListener(){
            var ointento: Intent = Intent(applicationContext, VisualizarNotas::class.java)
            startActivity(ointento)
        }
    }
}