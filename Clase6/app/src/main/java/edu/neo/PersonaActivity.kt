package edu.neo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import edu.neo.viewmodel.PersonaViewModel

class PersonaActivity : AppCompatActivity() {


    lateinit var peso:EditText
    lateinit var altura:EditText
    lateinit var calcular:Button
    lateinit var foto:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona)

        peso= findViewById(R.id.p_peso)
        altura=findViewById(R.id.p_altura)
        calcular=findViewById(R.id.p_calcular)
        foto=findViewById(R.id.p_imagen)


        val pvm : PersonaViewModel = ViewModelProvider(this).get(PersonaViewModel::class.java)


        // mostrar en el ImageView el resultado

        calcular.setOnClickListener(){
            foto.setImageResource(pvm.calcularIMC(peso,altura))

        }

        // donde metemos la logica del calculo magico este?
        // aca?


        //o0ooooo? en otro lado?

    }




    // inflamos el vista del menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // swtich ( condicion ) case '': break; default:

        return when(item.itemId){
            R.id.menu_configuration -> {
                Toast.makeText(this,"menu de configuracion", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_status ->{
                Toast.makeText(this,"menu de status", Toast.LENGTH_SHORT).show()

                true
            }
            else ->{
                Toast.makeText(this,"menu NO MAPEADO!", Toast.LENGTH_SHORT).show()

                true
            }
        }
    }



}