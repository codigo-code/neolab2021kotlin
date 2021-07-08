package edu.neo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.neo.R
import edu.neo.model.Personaje

class PersonajeAdapter(private val listaPerosnajes: ArrayList<Personaje>): RecyclerView.Adapter<PersonajeAdapter.ViewHolder>() {




    // nos creamos una inner class del viewholder

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val id:TextView
        val nombre:TextView
        val foto:ImageView
        val vistaCochina:View

        init {
            id=view.findViewById(R.id.per_id)
            nombre=view.findViewById(R.id.per_name)
            foto=view.findViewById(R.id.per_foto)
            vistaCochina=view
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.personaje_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return listaPerosnajes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.id.setText(listaPerosnajes[position].id.toString())
        holder.nombre.setText(listaPerosnajes[position].name)
        Glide
            .with(holder.vistaCochina.context)
            .load(listaPerosnajes[position].image)
            .centerCrop()
            .into(holder.foto);

    }


}