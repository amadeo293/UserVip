package com.example.uservip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnContinue: Button
    private lateinit var etName: EditText
    private lateinit var cbVip: CheckBox

    private lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = Prefs(this)

        initUI()

        checkUserValues()
    }

    private fun initUI() {
        btnContinue = findViewById(R.id.btnContinue)
        etName = findViewById(R.id.etName)
        cbVip = findViewById(R.id.cbVip)

        btnContinue.setOnClickListener {
            accessToDetail()
        }
    }

    private fun checkUserValues() {
        if (prefs.getName().isNotEmpty()) {
            goToDetail()
        }
    }

    private fun accessToDetail() {
        val name = etName.text.toString().trim()

        if (name.isNotEmpty()) {
            prefs.saveName(name)
            prefs.saveVIP(cbVip.isChecked)
            goToDetail()
        } else {
            etName.error = "Por favor ingresa tu nombre"
        }
    }

    private fun goToDetail() {
        val intent = Intent(this, ResultActivity2::class.java)
        startActivity(intent)
        finish() // Finaliza esta actividad para evitar que el usuario vuelva atrás
    }
}