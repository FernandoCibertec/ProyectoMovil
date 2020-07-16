package com.example.proyectomovil.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomovil.Adaptador.AdaptadorPROFESOR2
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.ObjListaPROFESOR
import com.example.proyectomovil.pojo.ObjPROFESOR
import com.example.proyectomovil.pojo.PROFESORRESPONSE
import com.example.proyectomovil.rest.RestProfesor
import com.example.proyectomovil.rest.iProfesor
import kotlinx.android.synthetic.main.activity_ingreso_profesor.*
import kotlinx.android.synthetic.main.activity_profesor_mnt.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.lang.Integer.parseInt

class ProfesorMnt : AppCompatActivity() {

    lateinit var oNuevoProfesor: Dialog
    lateinit var oLista:List<ObjListaPROFESOR>
    lateinit var oAdaptadorPROFESOR2: AdaptadorPROFESOR2
    lateinit var oObjPROFESOR:ObjListaPROFESOR
    var TIPOACCION:String = "N"

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
        var obtnEliminar = oNuevoProfesor.findViewById(R.id.ingresoPbtnEliminar) as Button



        obtnGrabar.setOnClickListener(){
            GrabarProfesor()
            oNuevoProfesor.dismiss()
        }
        obtnCerrar.setOnClickListener(){
            oNuevoProfesor.dismiss()
        }
        obtnEliminar.isEnabled= false
        obtnEliminar.isClickable=false
        oNuevoProfesor.show()
    }

    fun GrabarProfesor(){
        val onuevoIdDocente = oNuevoProfesor.findViewById(R.id.ingresoPtxtidprofesor) as EditText
        val onuevoNombre = oNuevoProfesor.findViewById(R.id.ingresoPtxtnombres) as EditText
        val onuevoApellido = oNuevoProfesor.findViewById(R.id.ingresoPtxtapellidos) as EditText
        val onuevoUsuario = oNuevoProfesor.findViewById(R.id.ingresoPtxtusuario) as EditText
        val onuevoClave = oNuevoProfesor.findViewById(R.id.ingresoPtxtclave) as EditText
        val onuevoIdCurso = oNuevoProfesor.findViewById(R.id.ingresoPtxtidcurso) as EditText
        val onuevoIdUsuario = oNuevoProfesor.findViewById(R.id.ingresoPtxtIdUsuario) as EditText

        if (TIPOACCION=="N"){
            oObjPROFESOR = ObjListaPROFESOR()
            oObjPROFESOR.idDocente=0;
        }
        oObjPROFESOR.nombre = onuevoNombre.text.toString()
        oObjPROFESOR.apellido = onuevoApellido.text.toString()
        oObjPROFESOR.usuario = onuevoUsuario.text.toString()
        oObjPROFESOR.clave = onuevoClave.text.toString()
        oObjPROFESOR.idCurso = parseInt(onuevoIdCurso.text.toString())
        oObjPROFESOR.idUsuario = parseInt(onuevoIdUsuario.text.toString())

        val oiProfesor:iProfesor
        oiProfesor= RestProfesor().getPROFESOR()!!.create(iProfesor::class.java)
        val call: Call<ObjPROFESOR> = oiProfesor.getRegistraModifica(oObjPROFESOR.idDocente, oObjPROFESOR.nombre,
            oObjPROFESOR.apellido, oObjPROFESOR.usuario, oObjPROFESOR.clave,
            oObjPROFESOR.idCurso.toString(),oObjPROFESOR.idUsuario.toString() , TIPOACCION)
        call.enqueue(object :Callback<ObjPROFESOR?>{
            override fun onResponse(    call: Call<ObjPROFESOR?>?,
                                        response: retrofit2.Response<ObjPROFESOR?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oObjPROFESOR.idDocente = response.body()!!.idDocente

                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<ObjPROFESOR?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })

    }

    public fun BuscarProfesor(){
        oLista = ArrayList<ObjListaPROFESOR>()
        val oiProfesor:iProfesor
        oiProfesor= RestProfesor().getPROFESOR()!!.create(iProfesor::class.java)
        val call: Call<PROFESORRESPONSE> = oiProfesor.getLista(0, edtBuscarProfesor.text.toString(), "", "", "", "", "")
        call.enqueue(object :Callback<PROFESORRESPONSE?>{
            override fun onResponse(
                call: Call<PROFESORRESPONSE?>,
                response: retrofit2.Response<PROFESORRESPONSE?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oLista = response.body()!!.objListaPROFESOR
                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<PROFESORRESPONSE?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }

    public fun CargarVentanaProfesor(){
        oNuevoProfesor = Dialog(this)
        oNuevoProfesor.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoProfesor.setCancelable(false)
        oNuevoProfesor.setContentView(R.layout.activity_ingreso_profesor)
        var obtnGrabar = oNuevoProfesor.findViewById(R.id.ingresoPbtnGrabar) as Button
        var obtnCerrar = oNuevoProfesor.findViewById(R.id.ingresoPbtnCerrar) as Button
        var obtnEliminar = oNuevoProfesor.findViewById(R.id.ingresoPbtnEliminar) as Button

        obtnGrabar.setOnClickListener(){
            GrabarProfesor()
            oNuevoProfesor.dismiss()
        }
        obtnCerrar.setOnClickListener(){
            oNuevoProfesor.dismiss()
        }
        obtnEliminar.setOnClickListener(){
            EliminarRegistroProfesor()
            oNuevoProfesor.dismiss()
        }
        oNuevoProfesor.show()
    }

    fun MostrarListado(){
        oAdaptadorPROFESOR2 = AdaptadorPROFESOR2(oLista){
            oObjPROFESOR = it
            TIPOACCION = "A"
            CargarVentanaProfesor()
            MostrarRegistro()
        }
        mntPRecycler.setAdapter(oAdaptadorPROFESOR2)
        val ll=LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        mntPRecycler.setLayoutManager(ll)
        mntPRecycler.setHasFixedSize(true)
        mntPRecycler.setAdapter(oAdaptadorPROFESOR2)
    }

    fun MostrarRegistro(){
        var onuevoIdDocente = oNuevoProfesor.findViewById(R.id.ingresoPtxtidprofesor) as EditText
        var onuevoNombre = oNuevoProfesor.findViewById(R.id.ingresoPtxtnombres) as EditText
        var onuevoApellido = oNuevoProfesor.findViewById(R.id.ingresoPtxtapellidos) as EditText
        var onuevoUsuario = oNuevoProfesor.findViewById(R.id.ingresoPtxtusuario) as EditText
        var onuevoClave = oNuevoProfesor.findViewById(R.id.ingresoPtxtclave) as EditText
        var onuevoIdCurso = oNuevoProfesor.findViewById(R.id.ingresoPtxtidcurso) as EditText
        var onuevoIdUsuario = oNuevoProfesor.findViewById(R.id.ingresoPtxtIdUsuario) as EditText


        onuevoIdDocente.setText(oObjPROFESOR.idDocente.toString())
        onuevoNombre.setText(oObjPROFESOR.nombre)
        onuevoApellido.setText(oObjPROFESOR.apellido)
        onuevoUsuario.setText(oObjPROFESOR.usuario)
        onuevoClave.setText(oObjPROFESOR.clave)
        onuevoIdCurso.setText(oObjPROFESOR.idCurso.toString())
        onuevoIdUsuario.setText(oObjPROFESOR.idUsuario.toString())
    }
    fun EliminarRegistroProfesor(){
        val onuevoIdDocente = oNuevoProfesor.findViewById(R.id.ingresoPtxtidprofesor) as EditText

        val oiProfesor:iProfesor
        oiProfesor= RestProfesor().getPROFESOR()!!.create(iProfesor::class.java)
        val call: Call<ObjPROFESOR> = oiProfesor.getElimina(parseInt(onuevoIdDocente.text.toString()))
        call.enqueue(object :Callback<ObjPROFESOR?>{
            override fun onResponse(    call: Call<ObjPROFESOR?>?,
                                        response: retrofit2.Response<ObjPROFESOR?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oObjPROFESOR.idDocente = response.body()!!.idDocente
                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<ObjPROFESOR?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }
}