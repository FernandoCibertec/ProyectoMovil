package com.example.proyectomovil.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.ObjListaCURSO
import kotlinx.android.synthetic.main.curso.view.*

class AdaptadorCURSO (val ListaInterna:List<ObjListaCURSO>, val clickListener: (ObjListaCURSO) -> Unit):
    RecyclerView.Adapter<AdaptadorCURSO.AdaptadorCURSOViewHolder>() {
    var onItemClick: ((ObjListaCURSO) -> Unit)? = null
    public class AdaptadorCURSOViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oObjListaCURSO: ObjListaCURSO)
        {
            val tvTextoSuperior = itemView.findViewById(R.id.IdCurso) as TextView
            val tvTextoDescripcion = itemView.findViewById(R.id.NombreCurso) as TextView
            tvTextoSuperior.text = oObjListaCURSO.idcurso.toString()
            tvTextoDescripcion.text =  oObjListaCURSO.nomcurso.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCURSOViewHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.curso,parent,false)
        return AdaptadorCURSO.AdaptadorCURSOViewHolder(v)
    }
    override fun getItemCount(): Int {
        return ListaInterna.size
    }
    override fun onBindViewHolder(holder: AdaptadorCURSOViewHolder, position: Int) {
        holder?.itemView.IdCurso?.text  = ListaInterna.get(position).idcurso.toString()
        holder?.itemView.NombreCurso?.text =  ListaInterna.get(position).nomcurso.toString()
        holder?.itemView?.setOnClickListener { clickListener(ListaInterna.get(position)) }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var tvTitle: TextView = itemView.findViewById(R.id.IdCurso)
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