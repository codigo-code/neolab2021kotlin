package edu.neo.model

import android.util.Log

class Persona : Mamifero() {
    override fun caminar() {

        Log.i("caminar", "la persona camina")
    }
}