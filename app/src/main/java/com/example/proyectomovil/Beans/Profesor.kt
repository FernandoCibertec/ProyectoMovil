package com.example.proyectomovil.Beans

class Profesor {
    var iddocente:Int = 0
    var nombre:String = ""
    var apellidos:String = ""
    var usuario:String = ""
    var clave:String = ""
    var idcurso:String = ""

    public constructor(piddocente: Int, pnombre: String, papellidos: String, pusuario:String, pclave:String, pidcurso:String){

        this.iddocente = piddocente
        this.nombre = pnombre
        this.apellidos = papellidos
        this.usuario = pusuario
        this.clave = pclave
        this.idcurso = pidcurso
    }
    public constructor(){
        this.Limpieza()
    }
    fun Limpieza(){
        this.iddocente = 0
        this.nombre = ""
        this.apellidos = ""
        this.usuario = ""
        this.clave = ""
        this.idcurso = ""
    }
}