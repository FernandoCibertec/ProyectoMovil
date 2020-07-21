package com.example.proyectomovil.tools

class Constantes {
    companion object
    {
        const val ENDPOINT = "http://www.proyectomovil.somee.com/"
        const val GETLISTA_PROFESOR = "Profesor/Listar"
        const val GETLISTARKEY_PROFESOR = "PROFESOR/ListarXDni"
        const val GETRegistraModifica_PROFESOR = "Profesor/RegistraModifica"
        const val GETElimina_PROFESOR = "Profesor/Elimina"

        const val GETLISTA_ESTUDIANTE = "Estudiante/Listar"
        const val GETLISTARKEY_ESTUDIANTE = "Estudiante/ListarKey"
        const val GETRegistraModifica_ESTUDIANTE = "Estudiante/RegistraModifica"
        const val GETElimina_ESTUDIANTE = "Estudiante/Elimina"

        const val GETLISTA_CURSO = "Curso/Listar"
        const val GETLISTARKEY_CURSO = "Curso/ListarKey"
        const val GETRegistraModifica_CURSO = "Curso/RegistraModifica"
        const val GETElimina_CURSO = "Curso/Elimina"

        const val GETLISTA_NOTA = "Notas/ListarNotasxEstudiante"

        val Validar_Login:String = "Usuario/ValidarUsuario"

    }
}