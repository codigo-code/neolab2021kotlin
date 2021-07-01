package edu.neo.model

import java.io.Serializable

data class Persona(var id: Int=0,val nombre: String, val apellido:String, val fechaNacimiento:String, val mail:String, val sexo:String, val fuma : Boolean, val trabajo:String) : Serializable