package edu.neo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var p: Persona

    lateinit var wifiSwitch: Switch
    lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val b: FloatingActionButton = findViewById(R.id.ma_button)



        b.setOnClickListener(
            View.OnClickListener {
                startActivity(Intent(this, PersonaActivity::class.java))
            }

        )

        wifiSwitch = findViewById(R.id.wifiSwitch)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                wifiManager.isWifiEnabled = true
                wifiSwitch.text = "WiFi is ON"
            } else {
                wifiManager.isWifiEnabled = false
                wifiSwitch.text = "WiFi is OFF"
            }
        }


    }


    // inflamos el vista del menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // swtich ( condicion ) case '': break; default:

        return when (item.itemId) {
            R.id.menu_configuration -> {
                Toast.makeText(this, "menu de configuracion", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_status -> {
                Toast.makeText(this, "menu de status", Toast.LENGTH_SHORT).show()

                true
            }
            else -> {
                Toast.makeText(this, "menu NO MAPEADO!", Toast.LENGTH_SHORT).show()

                true
            }
        }
    }


    override fun onStart() {
        super.onStart()

        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }


    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }


    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.getIntExtra(
                WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN
            )) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    wifiSwitch.isChecked = true
                    wifiSwitch.text = "WiFi is ON"
                    Toast.makeText(this@MainActivity, "Wifi is On", Toast.LENGTH_SHORT).show()
                }
                WifiManager.WIFI_STATE_DISABLED -> {

                    val builder = AlertDialog.Builder(context)

                    builder.setTitle("Cuidado Esta apango el wifi!")
                    builder.setMessage("Warning va a perder los datos del progreso!!!!")
                    builder.setIcon(android.R.drawable.ic_dialog_alert)

                    builder.setPositiveButton("Esta seguro que quiere apagar el wifi?") { dialogInterface, i ->

                            wifiSwitch.isChecked = false
                            wifiSwitch.text = "WiFi is OFF"
                            Toast.makeText(this@MainActivity, "Wifi is Off", Toast.LENGTH_SHORT)
                                .show()

                    }

                    builder.setNegativeButton("Genial siga jugando") { dialogInterface, i ->

                           // TODO: por medio del wifimanager seguir conectado al wifi para jugar
                            Toast.makeText(this@MainActivity, "Continua Jugando", Toast.LENGTH_SHORT).show()


                    }

                    // pongo el builder en contexto
                    var alerta:AlertDialog = builder.create()
                    alerta.setCancelable(false)
                    alerta.show()
                }
            }
        }

    }

}