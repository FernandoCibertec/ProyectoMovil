package com.example.proyectomovil.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomovil.Adaptador.AdaptadorPROFESOR2
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.ObjListaPROFESOR
import com.example.proyectomovil.pojo.PROFESORRESPONSE
import com.example.proyectomovil.rest.RestProfesor
import com.example.proyectomovil.rest.iProfesor
import kotlinx.android.synthetic.main.activity_profesor_mnt.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ProfesorMnt : AppCompatActivity() {

    lateinit var oNuevoProfesor: Dialog
    lateinit var oLista:List<ObjListaPROFESOR>
    lateinit var oAdaptadorPROFESOR2: AdaptadorPROFESOR2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor_mnt)

        mntPbtnBuscar.setOnClickListener(){
            BuscarProfesor()
        }
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

    fun BuscarProfesor(){
        oLista = ArrayList<ObjListaPROFESOR>()
        var oiProfesor = RestProfesor().getPROFESOR()!!.create(iProfesor::class.java)
        var call: Call<PROFESORRESPONSE> = oiProfesor.getLista(0, edtBuscarProfesor.text.toString(), "", "", "", "")
        call.enqueue(object :Callback<PROFESORRESPONSE?>{
            override fun onResponse(
                call: Call<PROFESORRESPONSE?>,
                response: Response<PROFESORRESPONSE?>
            ) {
                try {
                    oLista = response.body()!!.objListaPROFESOR

                }catch (e:Exception){
                    Log.d("AppWs", "Error:${e.message}")
                }
            }

            override fun onFailure(call: Call<PROFESORRESPONSE?>, t: Throwable) {
                Log.d("AppWs", "Error:${call.toString()}")
            }
        })
    }

    fun MostrarListado(){
        oAdaptadorPROFESOR2 = AdaptadorPROFESOR2(oLista){

        }
        mntPRecycler.setAdapter(oAdaptadorPROFESOR2)
        val ll=LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        mntPRecycler.setLayoutManager(ll)
        mntPRecycler.setHasFixedSize(true)

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