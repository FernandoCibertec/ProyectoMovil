package com.example.proyectomovil.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.ObjListaNOTum
import kotlinx.android.synthetic.main.notasview.view.*

class AdaptadorNOTA (val ListaInterna:List<ObjListaNOTum>, val clickListener: (ObjListaNOTum) -> Unit):
    RecyclerView.Adapter<AdaptadorNOTA.AdaptadorNOTAViewHolder>() {
    var onItemClick: ((ObjListaNOTum) -> Unit)? = null
    public class AdaptadorNOTAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oObjListaNOTum: ObjListaNOTum)
        {
            val tvTextoIdCurso = itemView.findViewById(R.id.rvNidCurso) as TextView
            val tvTextoNomCurso = itemView.findViewById(R.id.rvNNomCurso) as TextView
            val tvTextoIdNota = itemView.findViewById(R.id.rvNidNota) as TextView
            val tvTextoNota1 = itemView.findViewById(R.id.rvNnota1) as TextView
            val tvTextoNota2 = itemView.findViewById(R.id.rvNnota2) as TextView
            val tvTextoNota3 = itemView.findViewById(R.id.rvNnota3) as TextView
            val tvTextoNota4 = itemView.findViewById(R.id.rvNnota4) as TextView
            val tvTextoNota5 = itemView.findViewById(R.id.rvNnota5) as TextView
            val tvPromedio = itemView.findViewById(R.id.rvNPromedio) as TextView

            tvTextoIdCurso.text = oObjListaNOTum.idCurso.toString()
            tvTextoNomCurso.text = oObjListaNOTum.curso.toString()
            tvTextoIdNota.text = oObjListaNOTum.idCurso.toString()
            tvTextoNota1.text = "Nota 1: "+oObjListaNOTum.nota1.toString()
            tvTextoNota2.text = "Nota 2: "+oObjListaNOTum.nota2.toString()
            tvTextoNota3.text = "Nota 3: "+oObjListaNOTum.nota3.toString()
            tvTextoNota4.text = "Nota 4: "+oObjListaNOTum.nota4.toString()
            tvTextoNota5.text = "Nota 5: "+oObjListaNOTum.nota5.toString()
            tvPromedio.text = "Promedio: "+oObjListaNOTum.promedio.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorNOTAViewHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.notasview,parent,false)
        return AdaptadorNOTA.AdaptadorNOTAViewHolder(v)
    }
    override fun getItemCount(): Int {
        return ListaInterna.size
    }
    override fun onBindViewHolder(holder: AdaptadorNOTAViewHolder, position: Int) {
        holder?.itemView.rvNidCurso?.text  = ListaInterna.get(position).idCurso.toString()
        holder?.itemView.rvNNomCurso?.text =  ListaInterna.get(position).curso.toString()
        holder?.itemView.rvNidNota?.text = ListaInterna.get(position).idNota.toString()
        holder?.itemView.rvNnota1?.text = "Nota 1: "+ListaInterna.get(position).nota1.toString()
        holder?.itemView.rvNnota2?.text = "Nota 2: "+ListaInterna.get(position).nota2.toString()
        holder?.itemView.rvNnota3?.text = "Nota 3: "+ListaInterna.get(position).nota3.toString()
        holder?.itemView.rvNnota4?.text = "Nota 4: "+ListaInterna.get(position).nota4.toString()
        holder?.itemView.rvNnota5?.text = "Nota 5: "+ListaInterna.get(position).nota5.toString()
        holder?.itemView.rvNPromedio?.text = "Promedio: "+ListaInterna.get(position).promedio.toString()
        holder?.itemView?.setOnClickListener { clickListener(ListaInterna.get(position)) }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var tvTitle: TextView = itemView.findViewById(R.id.rvNidNota)
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