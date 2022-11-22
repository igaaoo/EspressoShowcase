package com.example.espressoshowcase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Numero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numero)

        var numero = findViewById<TextView>(R.id.numero)

        numero.text = intent.getStringExtra("numero")
    }
}