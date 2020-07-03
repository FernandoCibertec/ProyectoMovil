package com.example.proyectomovil.rest

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

}