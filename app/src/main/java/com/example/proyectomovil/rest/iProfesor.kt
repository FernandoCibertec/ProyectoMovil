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
                (@Query(value = "IdDocente") pIdDocente:Int,
                 @Query(value = "Nombre") pNombre:String,
                 @Query(value = "Apellido") pApellido:String,
                 @Query(value = "Usuario") pUsuario:String,
                 @Query(value = "Clave") pClave:String,
                 @Query(value = "IdCurso") pIdCurso:String,
                 @Query(value = "IdUsuario") pIdUsuario:String
    ): Call<PROFESORRESPONSE>

    @GET(Constantes.GETLISTARKEY_PROFESOR)
    @Headers( "Content-Type: application/json")
    fun getListarKey(
        @Query(value = "dni") dni:Int,
        @Query(value = "Nombre") pNombre:String,
        @Query(value = "Apellido") pApellido:String,
        @Query(value = "Usuario") pUsuario:String,
        @Query(value = "Clave") pClave:String,
        @Query(value = "IdCurso") pIdCurso:String,
        @Query(value = "IdUsuario") pIdUsuario:String
    ): Call<PROFESORRESPONSE>

    @GET(Constantes.GETRegistraModifica_PROFESOR)
    @Headers( "Content-Type: application/json")
    fun getRegistraModifica(
                @Query(value = "IdDocente") pIdDocente:Int,
                @Query(value = "Nombre") pNombre:String,
                @Query(value = "Apellido") pApellido:String,
                @Query(value = "Usuario") pUsuario:String,
                @Query(value = "Clave") pClave:String,
                @Query(value = "IdCurso") pIdCurso:String,
                @Query(value = "IdUsuario") pIdUsuario:String,
                @Query(value = "pTipoTransaccion") pTipoTransaccion:String
    ): Call<ObjPROFESOR>

    /*http://localhost:50856/Profesor/RegistraModifica?IdDocente=0&Nombre=nin&Apellido=hsj&Usuario=sj&Clave=dk&IdCurso=1&IdUsuario=1&pTipoTransaccion=N*/

    @GET(Constantes.GETElimina_PROFESOR)
    @Headers( "Content-Type: application/json")
    fun getElimina(
        @Query(value = "IdDocente") IdDocente:Int
    ): Call<ObjPROFESOR>


}