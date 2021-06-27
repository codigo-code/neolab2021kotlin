package edu.neo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.neo.R
import edu.neo.model.User

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var user: User =  intent.getSerializableExtra("usuario") as User

        Toast.makeText(this,"Hola " + user.username, Toast.LENGTH_LONG).show()
    }
}