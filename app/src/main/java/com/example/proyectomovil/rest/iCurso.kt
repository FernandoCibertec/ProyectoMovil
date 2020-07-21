package com.example.proyectomovil.rest

import com.example.proyectomovil.pojo.CURSORESPONSE
import com.example.proyectomovil.pojo.ObjCURSO
import com.example.proyectomovil.tools.Constantes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface iCurso {
    @GET(Constantes.GETLISTA_CURSO)
    @Headers( "Content-Type: application/json")
    fun getLista
                (@Query(value = "Idcurso") Idcurso:Int,
                 @Query(value = "Nomcurso") pNomcurso:String
    ): Call<CURSORESPONSE>


    @GET(Constantes.GETLISTARKEY_CURSO)
    @Headers( "Content-Type: application/json")
    fun getListarKey(
        @Query(value = "pIdcurso") pIdcurso:Int
    ): Call<CURSORESPONSE>

    @GET(Constantes.GETRegistraModifica_CURSO)
    @Headers( "Content-Type: application/json")
    fun getRegistraModifica(
        @Query(value = "pTipoTransaccion") pTipoTransaccion:String,
        @Query(value = "Idcurso") Idcurso:Int,
        @Query(value = "Nomcurso") Nomcurso:String
    ): Call<ObjCURSO>

    @GET(Constantes.GETElimina_CURSO)
    @Headers( "Content-Type: application/json")
    fun getElimina(
        @Query(value = "Idcurso") Idcurso:Int
    ): Call<ObjCURSO>
}