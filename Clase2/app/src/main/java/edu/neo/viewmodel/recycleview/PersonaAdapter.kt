package edu.neo.viewmodel.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import edu.neo.R
import edu.neo.model.Persona

class PersonaAdapter(val lista: ArrayList<Persona>) :
    RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    // metodos que se implementan del RecycleVIew Adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.persona_layout, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // nos evitamos hacer el for , while, foreach de la lista, se lo
        // delegamos al recycleView
        holder.nombre.text =lista[position].nombre
        holder.apellido.text = lista[position].apellido
        holder.trabajo.text = lista[position].trabajo
        holder.fechaNacimiento.text = lista[position].fechaNacimiento
        holder.email.text = lista[position].mail
        holder.fuma.text = lista[position].fuma.toString()
        holder.sexo.text = lista[position].sexo

    }


    // MAPEO DE ELEMENTOS CONTRA EL LAYOUT PERSONA
    // generamos una inner class ( clase hija ) que implementa ViewHolder
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // es el mapping de nuestro layout persona_layout

        var nombre: TextView
        var apellido: TextView
        var email: TextView
        var fechaNacimiento: TextView
        var sexo: TextView
        var fuma: TextView
        var trabajo: TextView


        init {
            nombre = view.findViewById(R.id.p_nombre)
            apellido = view.findViewById(R.id.p_apellido)
            email = view.findViewById(R.id.p_mail)
            fechaNacimiento = view.findViewById(R.id.p_fecha_nac)
            sexo = view.findViewById(R.id.p_sexo)
            fuma = view.findViewById(R.id.p_fuma)
            trabajo = view.findViewById(R.id.p_trabajo)
        }
    }


}

