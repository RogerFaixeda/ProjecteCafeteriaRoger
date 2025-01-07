package com.faixeda.projectecafeteriaroger.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.faixeda.projectecafeteriaroger.Home.HomeActivity
import com.faixeda.projectecafeteriaroger.R
import com.faixeda.projectecafeteriaroger.databinding.ActivityMainBinding
import com.faixeda.projectecafeteriaroger.registre.RegistreActivity

class MainActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    val keyNom = "nom_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)//Aixo es pq es vegi el splash screen, ja se que no s'ha de fer pero sino no es veu
        setTheme(R.style.Theme_ProjecteCafeteriaRoger)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.buttonSeguent.setOnClickListener{
            viewModel.setUsuari(binding.editTextNom.text.toString(), binding.editTextContrasenya.text.toString())
            viewModel.comprovarUsuari()
            if (viewModel.usuariComprovat) {

                val intent = Intent(applicationContext, HomeActivity::class.java)
                val usuari = viewModel.usuariActual

                val nomUsuari = usuari?.nom

                intent.putExtra(keyNom, nomUsuari)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuari o contrassenya incorrectes.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.textViewRegistre.setOnClickListener{
            val intent = Intent(applicationContext, RegistreActivity::class.java)
            startActivity(intent)
        }
    }
}