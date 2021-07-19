package edu.neo.model

import android.util.Log
import javax.security.auth.login.LoginException

abstract class Mamifero {


    var nombre: String = ""
    var edad: Int = 1

    abstract fun caminar()

    fun descansar() {
        Log.e("denscanso", "estoy descansando")
    }
}