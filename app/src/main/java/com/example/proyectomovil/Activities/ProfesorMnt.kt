package com.example.proyectomovil.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import com.example.proyectomovil.R

class ProfesorMnt : AppCompatActivity() {

    lateinit var oNuevoProfesor: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor_mnt)
    }



    public fun btnRegistro_OnClick(v: View){
        oNuevoProfesor = Dialog(this)
        oNuevoProfesor.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoProfesor.setCancelable(false)
        oNuevoProfesor.setContentView(R.layout.activity_ingreso_profesor)
        var obtnGrabar = oNuevoProfesor.findViewById(R.id.ingresoPbtnGrabar) as Button
        var obtnCerrar = oNuevoProfesor.findViewById(R.id.ingresoPbtnCerrar) as Button

        obtnGrabar.setOnClickListener(){
            oNuevoProfesor.dismiss()
        }
        obtnCerrar.setOnClickListener(){
            oNuevoProfesor.dismiss()
        }
        oNuevoProfesor.show()
    }

    /*oNuevoPaciente = Dialog(this)
        oNuevoPaciente.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoPaciente.setCancelable(false)
        oNuevoPaciente.setContentView(R.layout.activity_registro_paciente)
        var obtnGrabar = oNuevoPaciente.findViewById(R.id.btnGrabar) as Button
        var obtnCerrar = oNuevoPaciente.findViewById(R.id.btnCerrar) as Button

        obtnGrabar.setOnClickListener(){
            GrabarNuevoPaciente()
            oNuevoPaciente.dismiss()
        }
        obtnCerrar.setOnClickListener(){
            oNuevoPaciente.dismiss()
        }
        oNuevoPaciente.show()*/
}