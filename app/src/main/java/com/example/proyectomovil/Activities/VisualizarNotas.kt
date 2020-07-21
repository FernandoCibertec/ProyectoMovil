package com.example.proyectomovil.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomovil.Adaptador.AdaptadorNOTA
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.NOTARESPONSE
import com.example.proyectomovil.pojo.ObjListaNOTum
import com.example.proyectomovil.rest.RestNota
import com.example.proyectomovil.rest.iNota
import kotlinx.android.synthetic.main.activity_visualizar_notas.*
import retrofit2.Call
import retrofit2.Callback
import com.example.proyectomovil.MainActivity.Companion.idusuariovar
import java.lang.Integer.parseInt

class VisualizarNotas : AppCompatActivity() {

    lateinit var oLista:List<ObjListaNOTum>
    lateinit var oAdaptadorNOTA: AdaptadorNOTA
    lateinit var oObjNOTA: ObjListaNOTum

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_notas)

        buscarNota()
    }

    public fun buscarNota(){
        oLista = ArrayList<ObjListaNOTum>()
        val oiNota: iNota
        oiNota= RestNota().getNOTA()!!.create(iNota::class.java)
        val call: Call<NOTARESPONSE> = oiNota.getLista( parseInt(idusuariovar),0, 0, 0, 0, 0, 0, 0, 0, "", 0)
        call.enqueue(object : Callback<NOTARESPONSE?> {
            override fun onResponse(
                call: Call<NOTARESPONSE?>,
                response: retrofit2.Response<NOTARESPONSE?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oLista = response.body()!!.objListaNOTA
                    MostrarListado()
                }catch (e:java.lang.Exception){
                    Log.d("AppWs", e.toString())
                }
            }

            override fun onFailure(call: Call<NOTARESPONSE?>, t: Throwable) {
                Log.d("ERROR", t.toString())
            }
        })
    }

    fun MostrarListado(){
        oAdaptadorNOTA = AdaptadorNOTA(oLista){
        }
        recyclerviewNotas.setAdapter(oAdaptadorNOTA)
        val ll= LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        recyclerviewNotas.setLayoutManager(ll)
        recyclerviewNotas.setHasFixedSize(true)
        recyclerviewNotas.setAdapter(oAdaptadorNOTA)
    }

}