package com.example.uservip

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ResultActivity2 : AppCompatActivity() {

    private lateinit var btnBack: Button
    private lateinit var tvName: TextView
    private lateinit var container: View
    private lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        prefs = Prefs(this)
        initUI()
    }

    private fun initUI() {
        // Inicialización de vistas
        btnBack = findViewById(R.id.btnBack)
        tvName = findViewById(R.id.tvName)
        container = findViewById(R.id.container)

        btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }

        val userName = prefs.getName()
        tvName.text = "Bienvenido Ingeniero $userName"

        if (prefs.getVIP()) {
            setVIPColorBackground()
        }
    }

    private fun setVIPColorBackground() {
        container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_yellow))
    }
}






