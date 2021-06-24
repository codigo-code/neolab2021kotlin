package edu.neo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // defino una variable con el atributo lateinit --> se ejecuta despues de que se
    // crea la vista
    // var es una variable que acepta modificaciones ( mutable )
    lateinit var saludo: TextView
    var cont: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saludo = findViewById(R.id.t_saludo)

    }

    /*
        Kotlin cuando se define una variable a diferencia de otros lenguajes
        se escribe de la siguiente manera

        var = variables + nombre : type

        var nombre:String
        var edad: Int
        var altura:Double

        var ---> vamos a tener variables mutables


        si quisieramos tener variables INMUTABLES
        val obj: Clase = Clase(valor1,valor2,valorN)

        obj = obj2 ---> error!!

        // java
        String nombre ="dante"

        // Kotlin
        val nombre:String = "dante"

     */


    /*
        // java
        PROCEDIMIENTO!
        public void saludo(View view){

        }

        FUNCION!
        public String saludo(){
        return "hola dante";
        }


        // KOTLIN
        PROCEDIMIENTO
        fun saludo(view: View){

        }

        FUNCION
        fun saludo(nombre:String,edad:Int): String{
         return nombre + edad.toString();
        }



     */

    // nos creamos una funcion para atacharla al evento onClick de nuestro layout MainActivity
    // argumentnoss en una funcion --->
    fun saludar(view: View) {
        // ejecutamos la tostada, donde toma el contexto de la app actual, y muestra un mensaje
        // con show lo visualiza
        saludo.text = "Hola Dante, Bienvenido al Lab 202"+cont + "!"
        Toast.makeText(this, "Hola NeoLab", Toast.LENGTH_LONG).show()
        cont++
    }
}