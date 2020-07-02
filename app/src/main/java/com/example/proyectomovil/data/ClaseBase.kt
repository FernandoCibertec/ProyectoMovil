package com.example.proyectomovil.data

import android.database.sqlite.SQLiteDatabase

open class ClaseBase {
    public fun CadenaConexion():String{
        return "/data/data/com.example.proyectomovil.data/colegio.db"
    }

    public fun CrearBaseDatos() {
        var odb: SQLiteDatabase = SQLiteDatabase.openDatabase(
            CadenaConexion(),
            null, SQLiteDatabase.CREATE_IF_NECESSARY)

        odb.execSQL("CREATE TABLE IF NOT EXISTS PROFESOR(" +
                "iddocente int primary key, nombre varchar(45), apellidos varchar(55)," +
                "usuario varchar(10), clave varchar(8), idcurso int)")
        odb.execSQL("insert into PROFESOR values (1, Juan, Chalco, prfJC, 12345, 12)")

    }
}