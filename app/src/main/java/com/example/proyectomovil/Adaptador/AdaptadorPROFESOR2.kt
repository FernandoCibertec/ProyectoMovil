package com.example.proyectomovil.Adaptador
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.R
import com.example.proyectomovil.pojo.ObjListaPROFESOR
import kotlinx.android.synthetic.main.profesor.view.*

public class AdaptadorPROFESOR2(val ListaInterna:List<ObjListaPROFESOR>, val clickListener: (ObjListaPROFESOR) -> Unit):RecyclerView.Adapter<AdaptadorPROFESOR2.AdaptadorPROFESOR2ViewHolder>() {
    var onItemClick: ((ObjListaPROFESOR) -> Unit)? = null
    public class AdaptadorPROFESOR2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oObjListaPROFESOR: ObjListaPROFESOR)
        {
            val tvTextoSuperior = itemView.findViewById(R.id.ProfesorUsuario) as TextView
            val tvTextoDescripcion = itemView.findViewById(R.id.ProfesorNombre) as TextView
            val tvTextoInferior = itemView.findViewById(R.id.ProfesorID) as TextView
            tvTextoSuperior.text = oObjListaPROFESOR.usuario.toString()
            tvTextoDescripcion.text =  oObjListaPROFESOR.nombre.toString()
            tvTextoInferior.text = oObjListaPROFESOR.idDocente.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorPROFESOR2ViewHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.profesor,parent,false)
        return AdaptadorPROFESOR2.AdaptadorPROFESOR2ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return ListaInterna.size
    }
    override fun onBindViewHolder(holder: AdaptadorPROFESOR2ViewHolder, position: Int) {
        holder?.itemView.ProfesorUsuario?.text  = ListaInterna.get(position).usuario.toString()
        holder?.itemView.ProfesorNombre?.text =  ListaInterna.get(position).nombre.toString()
        holder?.itemView.ProfesorID?.text = ListaInterna.get(position).idDocente.toString()
        holder?.itemView?.setOnClickListener { clickListener(ListaInterna.get(position)) }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var tvTitle: TextView = itemView.findViewById(R.id.ProfesorUsuario)
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