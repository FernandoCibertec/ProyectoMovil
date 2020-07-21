package com.example.proyectomovil

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import com.example.proyectomovil.Activities.ConsultarNotas
import com.example.proyectomovil.Activities.EstudianteMnt
import com.example.proyectomovil.Activities.ProfesorMnt
import com.example.proyectomovil.Activities.Selecciondemantenimientos
import com.example.proyectomovil.pojo.UsuarioBE
import com.example.proyectomovil.rest.IUsuario
import com.example.proyectomovil.rest.RestUsuario
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    companion object {
        var globalVar = ""
        var NombreEstudiante = ""
        var idusuariovar = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ebtn_Ingresar.setOnClickListener {
            ValidarUsuario(txtUsuario.text.toString(), txtContra.text.toString())
        }
    }

    public fun ValidarUsuario(pLogin:String, pContrasenia:String)
    {
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        val oUsuario: IUsuario
        oUsuario = RestUsuario().getUsuario()!!.create(IUsuario::class.java)
        val oCall: Call<UsuarioBE> = oUsuario.ValidarUsuario(pLogin,pContrasenia)

        oCall.enqueue(object : Callback<UsuarioBE> {
            override fun onResponse(call: Call<UsuarioBE>, response: Response<UsuarioBE>) {
                if (txtUsuario.text.isEmpty() || txtContra.text.isEmpty())
                {
                    Toast.makeText(applicationContext,"Ingrese Usuario y/o Contraseña",
                        Toast.LENGTH_LONG).show()
                }
                else
                {
                    if(response.body()!!.idUsuario > 1)
                    {
                        if(response.body()!!.idTipo == 1)
                        {
                            Toast.makeText(applicationContext,"Bienvenido Alumno: ${response.body()!!.nomUsuario}",
                                Toast.LENGTH_LONG).show()

                            var ointento: Intent = Intent(applicationContext, ConsultarNotas::class.java)
                            startActivity(ointento)

                            globalVar = txtContra.text.toString()
                            NombreEstudiante = "${response.body()!!.nomUsuario}"
                            idusuariovar = "${response.body()!!.idUsuario}"
                        }

                        if (response.body()!!.idTipo == 2)
                        {
                            Toast.makeText(applicationContext,"Bienvenido Profesor(a): ${response.body()!!.nomUsuario}",
                                Toast.LENGTH_LONG).show()

                            var ointento: Intent = Intent(applicationContext, Selecciondemantenimientos::class.java)
                            startActivity(ointento)
                        }
                    }
                    else {
                        Toast.makeText(applicationContext,"Error al ingresar Usuario y/o Contraseña",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<UsuarioBE>, t: Throwable) {
                Toast.makeText(applicationContext,"Error: ${t.message}",
                    Toast.LENGTH_LONG).show()
            }
        })
    }

}
