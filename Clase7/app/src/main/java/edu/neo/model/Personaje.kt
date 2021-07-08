package edu.neo.model

import java.io.Serializable

data class Personaje(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
):Serializable