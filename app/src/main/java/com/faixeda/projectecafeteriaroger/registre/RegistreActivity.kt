package com.faixeda.projectecafeteriaroger.registre

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
import com.faixeda.projectecafeteriaroger.Login.MainActivity
import com.faixeda.projectecafeteriaroger.R
import com.faixeda.projectecafeteriaroger.databinding.ActivityRegistreBinding

class RegistreActivity : AppCompatActivity() {
    private val viewModel: RegistreViewModel by viewModels()
    val keyNom = "nom_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityRegistreBinding = DataBindingUtil.setContentView(this, R.layout.activity_registre)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSeguent.setOnClickListener{
            viewModel.afegirusuari(binding.editTextNom.text.toString(), binding.editTextContrasenya.text.toString())
            if (viewModel.usuariAfegit){
                val intent = Intent(applicationContext, HomeActivity::class.java)
                val usuari = viewModel.usuariActual

                val nomUsuari = usuari?.nom

                intent.putExtra(keyNom, nomUsuari)

                startActivity(intent)
            } else {
                Toast.makeText(this, "No s'ha pogut afegir l'usuari", Toast.LENGTH_SHORT).show()

            }
        }

        binding.textViewLogin.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}