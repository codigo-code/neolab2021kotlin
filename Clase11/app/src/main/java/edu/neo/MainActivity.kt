package edu.neo

import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import edu.neo.model.Electrico
import edu.neo.model.IMotor
import edu.neo.model.Perro
import edu.neo.model.Persona
import edu.neo.viewmodel.ActivityVM

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // conectarnos con la base datos

        val avm = ViewModelProvider(this).get(ActivityVM::class.java)



        avm.vehiculo(object : IMotor {
            override val potencia: Int
                get() = 40

            override fun combustion() {
                Log.i("Clase anonima", "combustion: MAGICA")
            }

        })




        val m1:IMotor = Electrico(30)

        avm.vehiculo(m1)


        avm.mamifero(Persona())   // new Persona()
        avm.mamifero(Perro())     // new Perro()

    }
}




/**
       S.O.L.I.D

    Single Responsability
    Open Close
    Liskov Principle
    Segregaci
       on de interfaces
    Inyeccion de Dependencias


 **/