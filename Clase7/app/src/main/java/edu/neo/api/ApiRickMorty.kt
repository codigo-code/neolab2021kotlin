package edu.neo.api

import edu.neo.model.Personaje
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRickMorty {

    @GET("api/character/{id}")
    fun getPersonaje(@Path("id") id:Int): Call<Personaje>
}