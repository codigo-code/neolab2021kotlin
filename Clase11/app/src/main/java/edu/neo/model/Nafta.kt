package edu.neo.model

import android.util.Log

class Nafta(override val potencia: Int) : IMotor {
    override fun combustion() {
        Log.i("nafta", "SHELL ")
    }
}