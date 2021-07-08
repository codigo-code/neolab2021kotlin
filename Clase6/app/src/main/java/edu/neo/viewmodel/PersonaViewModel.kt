package edu.neo.viewmodel

import android.widget.EditText
import androidx.lifecycle.ViewModel
import edu.neo.R

class PersonaViewModel: ViewModel() {


    fun calcularIMC(peso:EditText, altura:EditText ): Int{
        val p= peso.text.toString().toDouble()
        val a = altura.text.toString().toDouble()

        // profesores que se estan x jubilar y odian la vida!
        val res = (p / (a*a))


        if(res <= 18){
            // delgadez
            return R.mipmap.flaco
        }else if(res >18 && res <= 24.9){
            // peso normal
            return R.mipmap.normal
        }else{
            // sobre-peso
            return R.mipmap.gordo
        }

    }
}