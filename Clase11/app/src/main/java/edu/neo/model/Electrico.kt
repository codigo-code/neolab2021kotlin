package edu.neo.model

import android.util.Log

class Electrico(override val potencia: Int) : IMotor {
    override fun combustion() {
        Log.i("electrico", "TESLA")
    }
}