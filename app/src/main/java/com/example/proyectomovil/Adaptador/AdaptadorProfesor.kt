package com.example.proyectomovil.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.Beans.Profesor
import com.example.proyectomovil.R
import kotlinx.android.synthetic.main.profesor.view.*

class AdaptadorProfesor (var lista:List<Profesor>, con: Context):
    RecyclerView.Adapter<AdaptadorProfesor.ProfesorHolder>(){
    public class ProfesorHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun binditems(oProfesor:Profesor){
            val oidprofesor:TextView = itemView.findViewById(R.id.ProfesorID) as TextView
            val onombre:TextView = itemView.findViewById(R.id.ProfesorNombre) as TextView
            val ousuario:TextView = itemView.findViewById(R.id.ProfesorUsuario) as TextView

            var idprofesor = oidprofesor.text.toString()
            var intid = idprofesor.toInt()
            intid = oProfesor.iddocente
            onombre.text = oProfesor.nombre
            ousuario.text = oProfesor.usuario
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfesorHolder {
        val v:View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.profesor, parent, false)
        return AdaptadorProfesor.ProfesorHolder(v)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ProfesorHolder, position: Int) {
        holder?.itemView.ProfesorID?.text = lista.get(position).iddocente.toString()
        holder?.itemView.ProfesorNombre?.text = lista.get(position).nombre
        holder?.itemView.ProfesorUsuario.text = lista.get(position).usuario
    }
}