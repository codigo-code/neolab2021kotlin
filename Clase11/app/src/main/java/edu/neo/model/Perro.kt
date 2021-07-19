package edu.neo.model

import android.util.Log

class Perro:Mamifero() {
    override fun caminar() {
        Log.i("caminar", "caminar en 4 patas" )
    }
}