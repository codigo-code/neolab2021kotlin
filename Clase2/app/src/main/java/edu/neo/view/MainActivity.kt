package edu.neo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import edu.neo.R
import edu.neo.model.User
import edu.neo.viewmodel.UserViewModel
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var registrar: Button
    lateinit var login: Button
    lateinit var olvido: Button
    lateinit var frameReistrar: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeElements()

        // estariamos incialziando el objeto
        // Class.forName(Usuario.class) ---> Usuario::class.java
        val userVM = ViewModelProvider(this).get(UserViewModel::class.java)


        // a nivel de codigo llamamos al envento onClick
        login.setOnClickListener(
            View.OnClickListener {
                var u: User? = User(user.text.toString(), pass.text.toString())
                u = u?.let { it1 -> userVM.vilidateUser(it1) }

                if (u != null) {
                    // sabemos que de q tenemos el objeto disponibel
                    // aqui queremos llamar a una nueva activdad
                    /*
                        para llamar a una nueva actividad se invoca mediante un Intent
                        intent(this,InicioActivity::class.java)
                     */

                    val intent: Intent = Intent(this, InicioActivity::class.java)
                    // le tengo que pasar el objeto usuario
                    // k,v
                    intent.putExtra("usuario", u)

                    // debo inicializar el elemento
                    startActivity(intent)

                } else
                    Toast.makeText(this, "usuario invalido", Toast.LENGTH_LONG).show()
            }
        )

        registrar.setOnClickListener(
            View.OnClickListener {
                val viewRegistrar: View =
                    LayoutInflater.from(this).inflate(R.layout.register_layout, null, false)

                var userR: EditText = viewRegistrar.findViewById(R.id.r_user)
                var passR: EditText = viewRegistrar.findViewById(R.id.r_pass)
                var saveR: Button = viewRegistrar.findViewById(R.id.r_save)

                saveR.setOnClickListener(
                    View.OnClickListener {
                        userVM.saveUser(userR.text.toString(), passR.text.toString())
                        Toast.makeText(
                            viewRegistrar.context,
                            "usuario guardado correctamente",
                            Toast.LENGTH_LONG
                        ).show()
                        frameReistrar.removeAllViews()
                    }
                )
                frameReistrar.addView(viewRegistrar)
            }
        )


    }

    private fun initializeElements() {

        user = findViewById(R.id.e_user)
        pass = findViewById(R.id.e_pass)
        registrar = findViewById(R.id.b_register)
        login = findViewById(R.id.b_login)
        olvido = findViewById(R.id.b_restore)
        frameReistrar = findViewById(R.id.f_registrar)
    }

}