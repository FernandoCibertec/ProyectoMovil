package com.example.proyectomovil.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.ObjListaESTUDIANTE
import kotlinx.android.synthetic.main.estudiante.view.*

class AdaptadorESTUDIANTE (val ListaInterna:List<ObjListaESTUDIANTE>, val clickListener: (ObjListaESTUDIANTE) -> Unit):RecyclerView.Adapter<AdaptadorESTUDIANTE.AdaptadorESTUDIANTEViewHolder>() {
    var onItemClick: ((ObjListaESTUDIANTE) -> Unit)? = null
    public class AdaptadorESTUDIANTEViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oObjListaESTUDIANTE: ObjListaESTUDIANTE)
        {
            val tvTextoSuperior = itemView.findViewById(R.id.EstudianteDni) as TextView
            val tvTextoDescripcion = itemView.findViewById(R.id.EstudianteNombre) as TextView
            val tvTextoInferior = itemView.findViewById(R.id.IDEstudiante) as TextView
            tvTextoSuperior.text = oObjListaESTUDIANTE.dni.toString()
            tvTextoDescripcion.text =  oObjListaESTUDIANTE.nombre.toString()
            tvTextoInferior.text = oObjListaESTUDIANTE.idEstudiante.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorESTUDIANTEViewHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.estudiante,parent,false)
        return AdaptadorESTUDIANTE.AdaptadorESTUDIANTEViewHolder(v)
    }
    override fun getItemCount(): Int {
        return ListaInterna.size
    }
    override fun onBindViewHolder(holder: AdaptadorESTUDIANTEViewHolder, position: Int) {
        holder?.itemView.EstudianteDni?.text  = ListaInterna.get(position).dni.toString()
        holder?.itemView.EstudianteNombre?.text =  ListaInterna.get(position).nombre.toString()
        holder?.itemView.IDEstudiante?.text = ListaInterna.get(position).idEstudiante.toString()
        holder?.itemView?.setOnClickListener { clickListener(ListaInterna.get(position)) }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var tvTitle: TextView = itemView.findViewById(R.id.EstudianteDni)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(ListaInterna[adapterPosition])
            }
        }
        override fun onClick(v: View) {
            onItemClick?.invoke(ListaInterna[adapterPosition])
        }
    }
}