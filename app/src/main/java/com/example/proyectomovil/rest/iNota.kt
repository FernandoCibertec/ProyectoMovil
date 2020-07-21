package com.example.proyectomovil.rest

import com.example.proyectomovil.pojo.CURSORESPONSE
import com.example.proyectomovil.pojo.NOTARESPONSE
import com.example.proyectomovil.tools.Constantes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface iNota {

    @GET(Constantes.GETLISTA_NOTA)
    @Headers( "Content-Type: application/json")
    fun getLista
                (@Query(value = "IdUsuario") IdUsuario:Int,
                 @Query(value = "IdNota") IdNota:Int,
                 @Query(value = "Nota1") pNota1:Int,
                 @Query(value = "Nota2") pNota2:Int,
                 @Query(value = "Nota3") pNota3:Int,
                 @Query(value = "Nota4") pNota4:Int,
                 @Query(value = "Nota5") pNota5:Int,
                 @Query(value = "Promedio") pPromedio:Int,
                 @Query(value = "IdEstudiante") pIdEstudiante:Int,
                 @Query(value = "Curso") pCurso:String,
                 @Query(value = "IdCurso") pIdCurso:Int
    ): Call<NOTARESPONSE>
}