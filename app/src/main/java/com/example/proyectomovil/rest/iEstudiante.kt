package com.example.proyectomovil.rest

import com.example.proyectomovil.pojo.ESTUDIANTERESPONSE
import com.example.proyectomovil.pojo.ObjESTUDIANTE
import com.example.proyectomovil.tools.Constantes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface iEstudiante {
    @GET(Constantes.GETLISTA_ESTUDIANTE)
    @Headers( "Content-Type: application/json")
    fun getLista
                (@Query(value = "IdEstudiante") IdEstudiante:Int,
                 @Query(value = "Nombre") pNombre:String,
                 @Query(value = "Apellido") pApellido:String,
                 @Query(value = "Dni") pDni:String,
                 @Query(value = "IdGrado") pIdGrado:String,
                 @Query(value = "CodEstado") pCodEstado:String,
                 @Query(value = "IdUsuario") pIdUsuario:String
    ): Call<ESTUDIANTERESPONSE>

    @GET(Constantes.GETLISTARKEY_ESTUDIANTE)
    @Headers( "Content-Type: application/json")
    fun getListarKey(
        @Query(value = "pIdEstudiante") pIdEstudiante:Int
    ): Call<ESTUDIANTERESPONSE>

    @GET(Constantes.GETRegistraModifica_ESTUDIANTE)
    @Headers( "Content-Type: application/json")
    fun getRegistraModifica(
        @Query(value = "IdEstudiante") IdEstudiante:Int,
        @Query(value = "Nombre") pNombre:String,
        @Query(value = "Apellido") pApellido:String,
        @Query(value = "Dni") pDni:String,
        @Query(value = "IdGrado") pIdGrado:String,
        @Query(value = "CodEstado") pCodEstado:String,
        @Query(value = "IdUsuario") pIdUsuario:String,
        @Query(value = "pTipoTransaccion") pTipoTransaccion:String
    ): Call<ObjESTUDIANTE>

    /*http://localhost:50856/Profesor/RegistraModifica?IdDocente=0&Nombre=nin&Apellido=hsj&Usuario=sj&Clave=dk&IdCurso=1&IdUsuario=1&pTipoTransaccion=N*/

    @GET(Constantes.GETElimina_ESTUDIANTE)
    @Headers( "Content-Type: application/json")
    fun getElimina(
        @Query(value = "pIdEstudiante") pIdEstudiante:Int
    ): Call<ObjESTUDIANTE>
}