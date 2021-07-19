package edu.neo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import edu.neo.impl.User

class MainActivity : AppCompatActivity() {

    lateinit var user: TextInputEditText
    lateinit var pass: TextInputEditText
    lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ponemos en contexto los mensajes y lo disponiblizamos autoamgicametne
        Firebase.messaging.isAutoInitEnabled = true

        user = findViewById(R.id.user)
        pass = findViewById(R.id.password)
        login = findViewById(R.id.login)

        var u: User = User()

        login.setOnClickListener{
            if(u.validateUser(user.text.toString(),pass.text.toString())){
                Toast.makeText(this,"login correct",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,UserActivity::class.java))
            }else{
                Toast.makeText(this,"login fail!",Toast.LENGTH_LONG).show()

            }
        }

    }
}