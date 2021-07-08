package edu.neo.viewmodel

import android.app.Person
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import edu.neo.api.implementation.ApiRickMortyImp
import edu.neo.model.Personaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonajeViewmodel : ViewModel() {


    private val listaPersonajes: ArrayList<Personaje> = ArrayList<Personaje>()

    fun getPersonajeById(id: Int): Call<Personaje> {
        val api: ApiRickMortyImp = ApiRickMortyImp()

        return api.getPersonajeById(id)

    }


    fun savePersonaje(personaje: Personaje) {
        listaPersonajes.add(personaje)
    }

    fun getAllPersonajes(): ArrayList<Personaje> = listaPersonajes

    fun getPersonajeByIdLista(id: Int): Personaje {
        if (listaPersonajes.size > 0)
            return listaPersonajes.get(id - 1)
        else
            return Personaje(1, "dummy", "dummy", "dummy", "dummy", "dummy")

    }
}