package edu.neo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import edu.neo.impl.User

class MainActivity : AppCompatActivity() {

    lateinit var user: TextInputEditText
    lateinit var pass: TextInputEditText
    lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        user = findViewById(R.id.user)
        pass = findViewById(R.id.password)
        login = findViewById(R.id.login)

        var u: User = User()

        login.setOnClickListener{
            if(u.validateUser(user.text.toString(),pass.text.toString())){
                Toast.makeText(this,"login correct",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"login fail!",Toast.LENGTH_LONG).show()

            }
        }

    }
}