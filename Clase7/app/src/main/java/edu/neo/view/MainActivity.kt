package edu.neo.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.neo.R
import edu.neo.adapter.PersonajeAdapter
import edu.neo.fragment.PersonajeFragment
import edu.neo.model.Personaje
import edu.neo.viewmodel.PersonajeViewmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var nombre: TextView
    lateinit var id: EditText
    lateinit var especie: TextView
    lateinit var foto: ImageView
    lateinit var buscar: Button
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.p_nombre)
        id = findViewById(R.id.p_id)
        especie = findViewById(R.id.p_especie)
        foto = findViewById(R.id.p_imagen)
        buscar = findViewById(R.id.p_buscar)

        val rvPer:RecyclerView=findViewById(R.id.personaje_rv)
        val pvm: PersonajeViewmodel = ViewModelProvider(this).get(PersonajeViewmodel::class.java)
        val personajeFrg:PersonajeFragment = PersonajeFragment()

        // habilitar para que acepte fragmentos
        val manager = supportFragmentManager


        buscar.setOnClickListener(
            View.OnClickListener {
                pvm.getPersonajeById(id.text.toString().toInt())
                    .enqueue(object : Callback<Personaje> {
                        override fun onFailure(call: Call<Personaje>, t: Throwable) {
                            Log.e("Error-Invoke-API", t.message.toString())
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

                                pvm.savePersonaje(Personaje(data?.id.toString().toInt(),
                                data?.name.toString(),data?.status.toString(),
                                    data?.species.toString(),data?.gender.toString(),data?.image.toString()
                                    )
                                )

                                // ya tenemos cargada l alista llamos al adapter
                                rvPer.layoutManager = LinearLayoutManager(it.context,LinearLayout.VERTICAL,false)
                                rvPer.adapter=PersonajeAdapter(pvm.getAllPersonajes())


                                // creamos un fragmento dentro de nuestra actividad
                                val transaction = manager.beginTransaction()

                                val args = Bundle() // genera un lazo ( MAPA ( K V ) y se lo pasa al fragmento que lo invoca
                                // recupero el personaje de la lista por el id

                                val objPersonaje: Personaje = pvm.getPersonajeByIdLista(id.text.toString().toInt())

                                args.putString("name",objPersonaje.name)
                                args.putString("image",objPersonaje.image)
                                personajeFrg.arguments=args
                                // TODO: Resolver el lunes ....
                                transaction.replace(R.id.frame_replace_personaje,personajeFrg)
                                transaction.commit()

                            }
                        }

                    }) // fin del enqueue





            }




        )


    }
}