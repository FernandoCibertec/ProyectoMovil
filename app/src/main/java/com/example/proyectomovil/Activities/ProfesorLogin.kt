package com.example.proyectomovil.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectomovil.R
import com.example.proyectomovil.data.ClaseBase
import com.example.proyectomovil.data.ProfesorDAO
import kotlinx.android.synthetic.main.activity_profesor_login.*

class ProfesorLogin : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor_login)

        ebtn_Ingresar.setOnClickListener{
            /*var oProfesorDAO:ProfesorDAO=ProfesorDAO()
            if(oProfesorDAO.Login(txtUsuario.text.toString(), txtContra.text.toString())){
                Toast.makeText(this, "Ingreso con éxito", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show()
            }*/
            val prfmnt = Intent(this, ProfesorMnt::class.java)
            startActivity(prfmnt)
        }
    }
}
