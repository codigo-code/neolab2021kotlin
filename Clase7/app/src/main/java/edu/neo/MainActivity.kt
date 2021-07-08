package edu.neo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import edu.neo.api.implementation.ApiRickMortyImp
import edu.neo.model.Personaje
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var nombre: TextView
    lateinit var id: EditText
    lateinit var especie: TextView
    lateinit var foto: ImageView
    lateinit var buscar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.p_nombre)
        id = findViewById(R.id.p_id)
        especie = findViewById(R.id.p_especie)
        foto = findViewById(R.id.p_imagen)
        buscar = findViewById(R.id.p_buscar)

        val api: ApiRickMortyImp = ApiRickMortyImp()


        buscar.setOnClickListener(
            View.OnClickListener {
                api.getPersonajeById(id.text.toString().toInt())
                    .enqueue(object : Callback<Personaje> {
                        override fun onFailure(call: Call<Personaje>, t: Throwable) {
                            Toast.makeText(
                                it.context,
                                "Error al invocar el api",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        override fun onResponse(
                            call: Call<Personaje>,
                            response: Response<Personaje>
                        ) {
                            // cuando funciona correctamente el api !!!!

                            if (response.body() != null) {
                                val data = response.body()

                                nombre.setText(data?.name)
                                especie.setText(data?.species)
                                Glide
                                    .with(it.context)
                                    .load(data?.image)
                                    .centerCrop()
                                    .into(foto);

                            }
                        }

                    })
            }
        )


    }
}