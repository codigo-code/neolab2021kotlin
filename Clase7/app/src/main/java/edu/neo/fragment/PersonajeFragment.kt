package edu.neo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import edu.neo.R

class PersonajeFragment  : Fragment(){

    //creamos el fragmento con el metodo onCreateView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.personaje_fragment,container,false)




        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombre:TextView= view.findViewById(R.id.pf_nombre)
        val foto:ImageView = view.findViewById(R.id.pf_imagen)


        // tiene que recibir los datos ( de algun lado )

        val args = arguments


        nombre.setText(args?.getString("name"))

        Glide
            .with(view.context)
            .load(args?.getString("image"))
            .centerCrop()
            .into(foto);
    }
}