package com.example.proyectomovil.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomovil.Adaptador.AdaptadorESTUDIANTE
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.*
import com.example.proyectomovil.rest.RestEstudiante
import com.example.proyectomovil.rest.iEstudiante
import kotlinx.android.synthetic.main.activity_estudiante_mnt.*
import retrofit2.Call
import retrofit2.Callback
import java.lang.Integer.parseInt

class EstudianteMnt : AppCompatActivity() {

    lateinit var oNuevoEstudiante: Dialog
    lateinit var oLista:List<ObjListaESTUDIANTE>
    lateinit var oAdaptadorESTUDIANTE: AdaptadorESTUDIANTE
    lateinit var oObjESTUDIANTE: ObjListaESTUDIANTE
    var TIPOACCION:String = "N"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiante_mnt)

        mntEConsulta.setOnClickListener(){
            BuscarEstudiante()
        }
        mntENuevo.setOnClickListener(){
            oNuevoEstudiante = Dialog(this)
            oNuevoEstudiante.requestWindowFeature(Window.FEATURE_NO_TITLE)
            oNuevoEstudiante.setCancelable(false)
            oNuevoEstudiante.setContentView(R.layout.activity_ingreso_estudiante)
            var obtnGrabar = oNuevoEstudiante.findViewById(R.id.ingresoEbtnGrabar) as Button
            var obtnCerrar = oNuevoEstudiante.findViewById(R.id.ingresoEbtnCerrar) as Button
            var obtnEliminar = oNuevoEstudiante.findViewById(R.id.ingresoEbtnElimina) as Button

            obtnGrabar.setOnClickListener(){
                GrabarEstudiante()
                oNuevoEstudiante.dismiss()
            }
            obtnCerrar.setOnClickListener(){
                oNuevoEstudiante.dismiss()
            }
            obtnEliminar.isEnabled=false
            obtnEliminar.isClickable=false
            oNuevoEstudiante.show()
        }
    }

    public fun BuscarEstudiante(){
        oLista = ArrayList<ObjListaESTUDIANTE>()
        val oiEstudiante: iEstudiante
        oiEstudiante= RestEstudiante().getESTUDIANTE()!!.create(iEstudiante::class.java)
        val call: Call<ESTUDIANTERESPONSE> = oiEstudiante.getLista(0, "","","", "", "", "")
        call.enqueue(object : Callback<ESTUDIANTERESPONSE?> {
            override fun onResponse(
                call: Call<ESTUDIANTERESPONSE?>,
                response: retrofit2.Response<ESTUDIANTERESPONSE?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oLista = response.body()!!.objListaESTUDIANTE
                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<ESTUDIANTERESPONSE?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }

    public fun CargarVentanaEstudiante(){
        oNuevoEstudiante = Dialog(this)
        oNuevoEstudiante.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoEstudiante.setCancelable(false)
        oNuevoEstudiante.setContentView(R.layout.activity_ingreso_estudiante)
        var obtnGrabar = oNuevoEstudiante.findViewById(R.id.ingresoEbtnGrabar) as Button
        var obtnCerrar = oNuevoEstudiante.findViewById(R.id.ingresoEbtnCerrar) as Button
        var obtnEliminar = oNuevoEstudiante.findViewById(R.id.ingresoEbtnElimina) as Button

        obtnGrabar.setOnClickListener(){
            GrabarEstudiante()
            oNuevoEstudiante.dismiss()
        }
        obtnCerrar.setOnClickListener(){
            oNuevoEstudiante.dismiss()
        }
        obtnEliminar.setOnClickListener(){
            EliminarRegistroEstudiante()
            oNuevoEstudiante.dismiss()
        }
        oNuevoEstudiante.show()
    }

    fun MostrarListado(){
        oAdaptadorESTUDIANTE = AdaptadorESTUDIANTE(oLista){
            oObjESTUDIANTE = it
            TIPOACCION = "A"
            CargarVentanaEstudiante()
            MostrarRegistro()
        }
        recyclerviewEstudiante.setAdapter(oAdaptadorESTUDIANTE)
        val ll= LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        recyclerviewEstudiante.setLayoutManager(ll)
        recyclerviewEstudiante.setHasFixedSize(true)
        recyclerviewEstudiante.setAdapter(oAdaptadorESTUDIANTE)
    }

    fun MostrarRegistro(){
        var onuevoIdDocente = oNuevoEstudiante.findViewById(R.id.ingresoEtxtidestudiante) as EditText
        var onuevoNombre = oNuevoEstudiante.findViewById(R.id.ingresoEtxtNombres) as EditText
        var onuevoApellido = oNuevoEstudiante.findViewById(R.id.ingresoEtxtApellidos) as EditText
        var onuevoDni = oNuevoEstudiante.findViewById(R.id.ingresoEtxtDni) as EditText
        var onuevoIdgrado = oNuevoEstudiante.findViewById(R.id.ingresoEtxtIdgrado) as EditText
        var onuevoCodigo = oNuevoEstudiante.findViewById(R.id.ingresoEtxtCod) as EditText
        var onuevoIdUsuario = oNuevoEstudiante.findViewById(R.id.ingresoEtxtIdusuario) as EditText


        onuevoIdDocente.setText(oObjESTUDIANTE.idEstudiante.toString())
        onuevoNombre.setText(oObjESTUDIANTE.nombre)
        onuevoApellido.setText(oObjESTUDIANTE.apellido)
        onuevoDni.setText(oObjESTUDIANTE.dni)
        onuevoIdgrado.setText(oObjESTUDIANTE.idGrado.toString())
        onuevoCodigo.setText(oObjESTUDIANTE.codEstado.toString())
        onuevoIdUsuario.setText(oObjESTUDIANTE.idUsuario.toString())
    }

    fun GrabarEstudiante(){
        val onuevoIdDocente = oNuevoEstudiante.findViewById(R.id.ingresoEtxtidestudiante) as EditText
        val onuevoNombre = oNuevoEstudiante.findViewById(R.id.ingresoEtxtNombres) as EditText
        val onuevoApellido = oNuevoEstudiante.findViewById(R.id.ingresoEtxtApellidos) as EditText
        val onuevoDni = oNuevoEstudiante.findViewById(R.id.ingresoEtxtDni) as EditText
        val onuevoIdgrado = oNuevoEstudiante.findViewById(R.id.ingresoEtxtIdgrado) as EditText
        val onuevoCodigo = oNuevoEstudiante.findViewById(R.id.ingresoEtxtCod) as EditText
        val onuevoIdUsuario = oNuevoEstudiante.findViewById(R.id.ingresoEtxtIdusuario) as EditText

        if (TIPOACCION=="N"){
            oObjESTUDIANTE = ObjListaESTUDIANTE()
            oObjESTUDIANTE.idEstudiante=0;
        }
        oObjESTUDIANTE.nombre = onuevoNombre.text.toString()
        oObjESTUDIANTE.apellido = onuevoApellido.text.toString()
        oObjESTUDIANTE.dni = onuevoDni.text.toString()
        oObjESTUDIANTE.idGrado = Integer.parseInt(onuevoIdgrado.text.toString())
        oObjESTUDIANTE.codEstado = onuevoCodigo.text.toString()
        oObjESTUDIANTE.idUsuario = Integer.parseInt(onuevoIdUsuario.text.toString())

        val oiEstudiante: iEstudiante
        oiEstudiante= RestEstudiante().getESTUDIANTE()!!.create(iEstudiante::class.java)
        val call: Call<ObjESTUDIANTE> = oiEstudiante.getRegistraModifica(oObjESTUDIANTE.idEstudiante, oObjESTUDIANTE.nombre,oObjESTUDIANTE.apellido,
            oObjESTUDIANTE.dni, oObjESTUDIANTE.idGrado.toString(), oObjESTUDIANTE.codEstado, oObjESTUDIANTE.idUsuario.toString(), TIPOACCION)
        call.enqueue(object : Callback<ObjESTUDIANTE?> {
            override fun onResponse(
                call: Call<ObjESTUDIANTE?>,
                response: retrofit2.Response<ObjESTUDIANTE?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oObjESTUDIANTE.idEstudiante = response.body()!!.idEstudiante

                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<ObjESTUDIANTE?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }

    fun EliminarRegistroEstudiante(){
        val onuevoIdEstudiante = oNuevoEstudiante.findViewById(R.id.ingresoEtxtidestudiante) as EditText

        val oiEstudiante: iEstudiante
        oiEstudiante= RestEstudiante().getESTUDIANTE()!!.create(iEstudiante::class.java)
        val call: Call<ObjESTUDIANTE> = oiEstudiante.getElimina(parseInt(onuevoIdEstudiante.text.toString()))
        call.enqueue(object : Callback<ObjESTUDIANTE?> {
            override fun onResponse(
                call: Call<ObjESTUDIANTE?>,
                response: retrofit2.Response<ObjESTUDIANTE?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oObjESTUDIANTE.idEstudiante = response.body()!!.idEstudiante

                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<ObjESTUDIANTE?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }
}