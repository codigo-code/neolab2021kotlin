package edu.neo.view

import android.annotation.SuppressLint
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.LinearLayout.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.neo.R
import edu.neo.viewmodel.PersonaViewModel
import edu.neo.viewmodel.recycleview.PersonaAdapter

class InicioActivity : AppCompatActivity() {

    lateinit var nombre: EditText
    lateinit var apellido: EditText
    lateinit var email: EditText
    lateinit var fechaNacimiento: EditText
    lateinit var rgSexo: RadioGroup
    lateinit var fuma: Switch
    lateinit var sp_trabajo: Spinner
    lateinit var guardar: Button
    lateinit var verPersonas:Button
    lateinit var rv_personas:RecyclerView
    val trabajos =arrayOf("estudiante", "docente", "programad@r", "comerciante", "aspirante a neoris")

    lateinit var inicioVM: PersonaViewModel

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


         inicioVM = ViewModelProvider(this).get(PersonaViewModel::class.java)


        inicilizar()

        inicializoSpinner()

        var trabajoSeleccionado:String =""
        sp_trabajo.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(p0: AdapterView<*>?) {
             // TODO: cargar la lista
                Toast.makeText(applicationContext,"no hay items seleccionados", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                trabajoSeleccionado= trabajos[position]
            }

        }




        // enlazar el radio button para obtener su valor

        guardar.setOnClickListener(

            View.OnClickListener {

                // obtenemos la posicion del radioButton por medio del RadioGroup
                val selected: Int = rgSexo!!.checkedRadioButtonId

                // generar una nueva variable de tipo RB, y hacemos el find, con el obj seleccionado del RG
                val rb_selected: RadioButton = findViewById(selected)

                val sexo:String = rb_selected!!.text.toString()


                if(inicioVM.savePersona(nombre.text.toString(), apellido.text.toString(),fechaNacimiento.text.toString(),email.text.toString(),sexo,fuma.isChecked,trabajoSeleccionado,it.context))
                    Toast.makeText(it.context, "Persona Guardada!", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(it.context,"Error al guardar la persona, vea el log!", Toast.LENGTH_SHORT).show()
            }

        )


        verPersonas.setOnClickListener(
            View.OnClickListener {

<<<<<<< HEAD
                rv_personas.layoutManager =LinearLayoutManager(this, VERTICAL,false)
=======
                rv_personas.layoutManager =LinearLayoutManager(this,LinearLayout.VERTICAL,false)
>>>>>>> 1f9fc57011e5d05711fa7a93f0072e3576440beb



                rv_personas.adapter = PersonaAdapter(inicioVM.getAllPersonas(this))

            }

        )

    }

    private fun inicilizar() {
        nombre = findViewById(R.id.i_name)
        apellido = findViewById(R.id.i_lastname)
        email = findViewById(R.id.i_mail)
        fechaNacimiento = findViewById(R.id.i_bdate)
        rgSexo = findViewById(R.id.i_rgsex)
        fuma = findViewById(R.id.i_smoke)
        sp_trabajo = findViewById(R.id.i_job)
        guardar = findViewById(R.id.i_save)
        verPersonas= findViewById(R.id.i_mostrarPersonas)
        rv_personas= findViewById(R.id.i_rv_personas)
    }

    private fun inicializoSpinner() {
        sp_trabajo.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, trabajos)


    }


}