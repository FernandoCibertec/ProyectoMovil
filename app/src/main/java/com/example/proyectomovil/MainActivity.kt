package com.example.proyectomovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectomovil.Activities.EstudianteLogin
import com.example.proyectomovil.Activities.ProfesorLogin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ibtnEstudiante.setOnClickListener{
            val stdlogin = Intent(this, EstudianteLogin::class.java)
            startActivity(stdlogin)
        }
        ibtnProfesor.setOnClickListener{
            val prflogin = Intent(this, ProfesorLogin::class.java)
            startActivity(prflogin)
        }
    }

}
