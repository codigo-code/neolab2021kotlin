package edu.neo.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import edu.neo.model.IMotor
import edu.neo.model.Mamifero
import edu.neo.model.Perro
import edu.neo.model.Persona

class ActivityVM(): ViewModel() {


    fun mamifero(mamifero: Mamifero){
        mamifero.caminar() // Persona()
    }


    fun vehiculo(motor :IMotor){
        Log.i("ActivityVM", "Potencia:  " + motor.potencia)
        motor.combustion()
    }
}