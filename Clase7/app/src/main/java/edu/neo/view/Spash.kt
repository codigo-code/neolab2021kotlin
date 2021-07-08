package edu.neo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import edu.neo.R


class Spash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)

        val foto: ImageView = findViewById(R.id.imageView)
        foto.setImageResource(R.mipmap.extragordo)


        Handler().postDelayed({
        // este codigo que vemos aca....
            val intent = Intent(this, MainActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP

            startActivity(intent)
            this.finish()

        },3000) // 3 segundos
    }




}