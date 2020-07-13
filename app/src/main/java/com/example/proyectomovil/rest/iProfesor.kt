package com.example.proyectomovil.rest

import com.example.proyectomovil.pojo.ObjPROFESOR
import com.example.proyectomovil.pojo.PROFESORRESPONSE
import com.example.proyectomovil.tools.Constantes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface iProfesor {

    @GET(Constantes.GETLISTA_PROFESOR)
    @Headers( "Content-Type: application/json")
    fun getLista
                (@Query(value = "iddocente") piddocente:Int,
                 @Query(value = "nombre") pnombre:String,
                 @Query(value = "apellidos") papellidos:String,
                 @Query(value = "usuario") pusuario:String,
                 @Query(value = "clave") pclave:String,
                 @Query(value = "idcurso") pidcurso:String
    ): Call<PROFESORRESPONSE>

    @GET(Constantes.GETLISTARKEY_PROFESOR)
    @Headers( "Content-Type: application/json")
    fun getListarKey(
        @Query(value = "piddocente") piddocente:Int
    ): Call<PROFESORRESPONSE>

    @GET(Constantes.GETRegistraModifica_PROFESOR)
    @Headers( "Content-Type: application/json")
    fun getRegistraModifica(
                @Query(value = "pTipoTransaccion") pTipoTransaccion:String ,
                @Query(value = "iddocente") piddocente:Int,
                @Query(value = "nombre") pnombre:String,
                @Query(value = "apellidos") papellidos:String,
                @Query(value = "usuario") pusuario:String,
                @Query(value = "clave") pclave:String,
                @Query(value = "idcurso") pidcurso:String
    ): Call<PROFESORRESPONSE>

    @GET(Constantes.GETElimina_PROFESOR)
    @Headers( "Content-Type: application/json")
    fun getElimina(
        @Query(value = "iddocente") piddocente:Int
    ): Call<ObjPROFESOR>


}