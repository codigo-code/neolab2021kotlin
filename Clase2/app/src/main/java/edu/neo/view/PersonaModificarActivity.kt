package edu.neo.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import edu.neo.R
import edu.neo.viewmodel.PersonaModificarViewModel

class PersonaModificarActivity : AppCompatActivity() {

    lateinit var id: TextView
    lateinit var nombre: EditText
    lateinit var mail: EditText
    lateinit var guardar: Button
    lateinit var clear: Button
    lateinit var personaModificarVM: PersonaModificarViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona_modificar)

        personaModificarVM = ViewModelProvider(this).get(PersonaModificarViewModel::class.java)

        // TODO: recibir el objeto a modificar
        initialization()
        clearButtons()

        mapperElements()

        savePersonaModifcada()
    }


    private fun mapperElements(){
        nombre.setText(intent.getStringExtra("nombre"))
        mail.setText(intent.getStringExtra("mail"))
        id.setText(intent.getStringExtra("id"))
    }
    private fun initialization() {
        nombre = findViewById(R.id.p_m_nombre)
        mail = findViewById(R.id.p_m_mail)
        guardar = findViewById(R.id.p_m_guardar)
        clear = findViewById(R.id.p_m_clear)
        id = findViewById(R.id.p_m_id)
    }


    private fun clearButtons() {
        clear.setOnClickListener(

            View.OnClickListener {
                nombre.setText("")
                mail.setText("")

            }
        )
    }


    private fun savePersonaModifcada() {
        guardar.setOnClickListener(
            View.OnClickListener {
                personaModificarVM.modificoPersona(
                    nombre.text.toString(),
                    mail.text.toString(),
                    id.text.toString().toInt(),
                    this
                )
            }
        )
    }
}