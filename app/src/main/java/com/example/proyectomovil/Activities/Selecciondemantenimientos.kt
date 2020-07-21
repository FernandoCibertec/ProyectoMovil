package com.example.proyectomovil.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectomovil.R
import kotlinx.android.synthetic.main.activity_selecciondemantenimientos.*

class Selecciondemantenimientos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecciondemantenimientos)

        ivProfesor.setOnClickListener(){
            var ointento: Intent = Intent(applicationContext, ProfesorMnt::class.java)
            startActivity(ointento)
        }
        ivEstudiante.setOnClickListener(){
            var ointento: Intent = Intent(applicationContext, EstudianteMnt::class.java)
            startActivity(ointento)
        }
        ivCurso.setOnClickListener(){
            var ointento: Intent = Intent(applicationContext, CursoMnt::class.java)
            startActivity(ointento)
        }
    }
}