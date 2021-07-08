package edu.neo.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import edu.neo.dao.DbHelper
import edu.neo.model.Persona


class PersonaViewModel : ViewModel() {


    fun savePersona(
        nombre: String,
        apellido: String,
        fechaNacimiento: String,
        mail: String,
        sexo: String,
        fuma: Boolean,
        trabajo: String,
        context: Context
    ): Boolean {

        val db: DbHelper = DbHelper(context, null)

        return db.savePerson(Persona(0,nombre, apellido, fechaNacimiento, mail, sexo, fuma, trabajo))
    }



    fun getAllPersonas(context: Context):ArrayList<Persona>{
        val db: DbHelper = DbHelper(context, null)

        return db.getAllPersonas()
    }
}