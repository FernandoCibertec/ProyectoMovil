package com.example.proyectomovil.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomovil.Adaptador.AdaptadorCURSO
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.CURSORESPONSE
import com.example.proyectomovil.pojo.ObjCURSO
import com.example.proyectomovil.pojo.ObjListaCURSO
import com.example.proyectomovil.rest.RestCurso
import com.example.proyectomovil.rest.iCurso
import kotlinx.android.synthetic.main.activity_curso_mnt.*
import retrofit2.Call
import retrofit2.Callback
import java.lang.Integer.parseInt

class CursoMnt : AppCompatActivity() {


    lateinit var oNuevoCurso: Dialog
    lateinit var oLista:List<ObjListaCURSO>
    lateinit var oAdaptadorCURSO: AdaptadorCURSO
    lateinit var oObjCURSO: ObjListaCURSO
    var TIPOACCION:String = "N"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curso_mnt)

        mntCbtnNuevo.setOnClickListener(){
            TIPOACCION="N"
            oNuevoCurso = Dialog(this)
            oNuevoCurso.requestWindowFeature(Window.FEATURE_NO_TITLE)
            oNuevoCurso.setCancelable(false)
            oNuevoCurso.setContentView(R.layout.activity_ingreso_curso)
            var obtnGrabar = oNuevoCurso.findViewById(R.id.ingresoCbtnGrabar) as Button
            var obtnCerrar = oNuevoCurso.findViewById(R.id.ingresoCbtnCerrar) as Button
            var obtnEliminar = oNuevoCurso.findViewById(R.id.ingresoCbtnEliminar) as Button

            obtnGrabar.setOnClickListener(){
                GrabarCurso()
                oNuevoCurso.dismiss()
            }
            obtnCerrar.setOnClickListener(){
                oNuevoCurso.dismiss()
            }
            obtnEliminar.isClickable=false
            obtnEliminar.isEnabled=false

            oNuevoCurso.show()
        }
        mntCConsulta.setOnClickListener(){
            BuscarCurso()
        }


    }
    public fun CargarVentanaCurso(){
        oNuevoCurso = Dialog(this)
        oNuevoCurso.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoCurso.setCancelable(false)
        oNuevoCurso.setContentView(R.layout.activity_ingreso_curso)
        var obtnGrabar = oNuevoCurso.findViewById(R.id.ingresoCbtnGrabar) as Button
        var obtnCerrar = oNuevoCurso.findViewById(R.id.ingresoCbtnCerrar) as Button
        var obtnEliminar = oNuevoCurso.findViewById(R.id.ingresoCbtnEliminar) as Button

        obtnGrabar.setOnClickListener(){
            GrabarCurso()
            oNuevoCurso.dismiss()
        }
        obtnCerrar.setOnClickListener(){
            oNuevoCurso.dismiss()
        }
        obtnEliminar.setOnClickListener(){
            EliminarCurso()
            oNuevoCurso.dismiss()
        }
        oNuevoCurso.show()
    }

    fun GrabarCurso(){
        val onuevoIdCurso = oNuevoCurso.findViewById(R.id.ingresoCtxtIdcurso) as EditText
        val onuevoNomCurso = oNuevoCurso.findViewById(R.id.ingresoCtxtNomCurso) as EditText

        if (TIPOACCION=="N"){
            oObjCURSO = ObjListaCURSO()
            oObjCURSO.idcurso=0;
        }
        oObjCURSO.nomcurso = onuevoNomCurso.text.toString()

        val oiCurso:iCurso
        oiCurso= RestCurso().getCURSO()!!.create(iCurso::class.java)
        val call: Call<ObjCURSO> = oiCurso.getRegistraModifica(TIPOACCION, oObjCURSO.idcurso, oObjCURSO.nomcurso)
        call.enqueue(object : Callback<ObjCURSO?> {
            override fun onResponse(    call: Call<ObjCURSO?>?,
                                        response: retrofit2.Response<ObjCURSO?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oObjCURSO.idcurso = response.body()!!.idcurso

                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<ObjCURSO?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })

    }

    public fun BuscarCurso(){
        oLista = ArrayList<ObjListaCURSO>()
        val oiCurso:iCurso
        oiCurso= RestCurso().getCURSO()!!.create(iCurso::class.java)
        val call: Call<CURSORESPONSE> = oiCurso.getLista(0, "")
        call.enqueue(object : Callback<CURSORESPONSE?> {
            override fun onResponse(    call: Call<CURSORESPONSE?>?,
                                        response: retrofit2.Response<CURSORESPONSE?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oLista = response.body()!!.objListaCURSO

                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<CURSORESPONSE?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }

    fun MostrarListado(){
        oAdaptadorCURSO = AdaptadorCURSO(oLista){
            oObjCURSO = it
            TIPOACCION = "A"
            CargarVentanaCurso()
            MostrarRegistro()
        }
        recyclerViewCurso.setAdapter(oAdaptadorCURSO)
        val ll= LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        recyclerViewCurso.setLayoutManager(ll)
        recyclerViewCurso.setHasFixedSize(true)
        recyclerViewCurso.setAdapter(oAdaptadorCURSO)
    }

    fun MostrarRegistro(){
        val onuevoIdCurso = oNuevoCurso.findViewById(R.id.ingresoCtxtIdcurso) as EditText
        val onuevoNomCurso = oNuevoCurso.findViewById(R.id.ingresoCtxtNomCurso) as EditText


        onuevoIdCurso.setText(oObjCURSO.idcurso.toString())
        onuevoNomCurso.setText(oObjCURSO.nomcurso)
    }

    fun EliminarCurso(){
        val onuevoIdCurso = oNuevoCurso.findViewById(R.id.ingresoCtxtIdcurso) as EditText

        val oiCurso:iCurso
        oiCurso= RestCurso().getCURSO()!!.create(iCurso::class.java)
        val call: Call<ObjCURSO> = oiCurso.getElimina(parseInt(onuevoIdCurso.text.toString()))
        call.enqueue(object : Callback<ObjCURSO?> {
            override fun onResponse(    call: Call<ObjCURSO?>?,
                                        response: retrofit2.Response<ObjCURSO?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oObjCURSO.idcurso = response.body()!!.idcurso

                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<ObjCURSO?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }

}