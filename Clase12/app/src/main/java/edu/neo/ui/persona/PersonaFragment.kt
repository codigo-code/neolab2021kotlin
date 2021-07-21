package edu.neo.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.neo.R

class PersonaFragment : Fragment() {

  private lateinit var personaViewModel: PersonaViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    personaViewModel =
            ViewModelProvider(this).get(PersonaViewModel::class.java)
    val root = inflater.inflate(R.layout.persona_gallery, container, false)
    val textView: TextView = root.findViewById(R.id.text_gallery)

    textView.text = arguments?.getString("persona")


    return root
  }


}