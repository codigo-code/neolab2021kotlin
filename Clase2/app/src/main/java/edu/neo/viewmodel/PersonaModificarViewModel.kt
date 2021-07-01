package edu.neo.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import edu.neo.dao.DbHelper

class PersonaModificarViewModel : ViewModel(){


    // llamamos a nuestro helper


    fun modificoPersona( nombre:String, mail:String, id:Int, context:Context ){

        val db: DbHelper = DbHelper(context,null)

        db.modificarPersona(nombre, mail, id)
    }
}