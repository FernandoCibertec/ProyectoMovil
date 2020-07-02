package com.example.proyectomovil.data

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.proyectomovil.Beans.Profesor

class ProfesorDAO:ClaseBase() {

    init{
        super.CrearBaseDatos()
    }

    public fun RegistrarProfesor(pProf: Profesor, pAccion:String){
        var odb:SQLiteDatabase = SQLiteDatabase.openDatabase(this.CadenaConexion(),
            null, SQLiteDatabase.CREATE_IF_NECESSARY)
        var pContenido:ContentValues= ContentValues()

        pContenido.put("iddocente", pProf.iddocente)
        pContenido.put("nombre", pProf.nombre)
        pContenido.put("apellidos", pProf.apellidos)
        pContenido.put("usuario", pProf.usuario)
        pContenido.put("clave", pProf.clave)
        pContenido.put("idcurso", pProf.idcurso)
        if(pAccion=="N") {
            var oresult = odb.insert("PROFESOR", null, pContenido).toInt()
            if (oresult == -1) {

            }
        }
        /*else if(pAccion=="N") {
            var oresult = odb.update("PROFESOR", null, ).toInt()
            if (oresult == -1) {

            }
        }*/
    }
    public fun Login(user:String, pas:String):Boolean{
        var odb:SQLiteDatabase = SQLiteDatabase.openDatabase(this.CadenaConexion(),
        null, SQLiteDatabase.CREATE_IF_NECESSARY)
        val query = "select * from PROFESOR where usuario = $user and clave = $pas"
        val cursor = odb.rawQuery(query, null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
}