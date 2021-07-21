package edu.neo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import edu.neo.R

class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_home, container, false)

    val b:Button = root.findViewById(R.id.b_buttonMagico)


    b.setOnClickListener{
      val mansaje:String = "soy una persona magica ";




      val bundle = bundleOf("persona" to mansaje )
      findNavController().navigate(R.id.action_nav_home_to_nav_persona_magica,bundle)
    }
    val textView: TextView = root.findViewById(R.id.text_home)
    homeViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}



/*



val wallet =
    LobbyFragmentDirections.actionLobbyFragmentToViewFragment(
        editTextWallet.text.toString(),
        currentHashRate,
        unpaidBalance,
        onlineWorkers,
        totalPaid,
        averageHashrate,
        profitPerDay
    )
findNavController().navigate(wallet)



 */