package edu.neo.api.implementation

import edu.neo.api.ApiRickMorty
import edu.neo.model.Personaje
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRickMortyImp {

    private  fun getRetrofit() : Retrofit{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/")
            .build()
    }

    fun getPersonajeById(id: Int): Call<Personaje>{


        return getRetrofit().create(ApiRickMorty::class.java).getPersonaje(id)
    }
}