package com.example.espressoshowcase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var telefone = findViewById<EditText>(R.id.telefone)
        var concordo = findViewById<CheckBox>(R.id.concordo)
        var enviar = findViewById<Button>(R.id.enviar)

        var avisoTele = findViewById<TextView>(R.id.avisoTele)

        enviar.setOnClickListener {
            val telefoneTxt = telefone.text.toString()

            if(telefoneTxt.isEmpty() || telefoneTxt.lowercase().contains("[a-z]".toRegex())){
                avisoTele.visibility = View.VISIBLE
                if(concordo.isChecked == false)
                {
                    Toast.makeText(applicationContext, getString(R.string.toast), Toast.LENGTH_SHORT).show()
                }
            } else if (concordo.isChecked == false){
                avisoTele.visibility = View.INVISIBLE
                Toast.makeText(applicationContext, getString(R.string.toast), Toast.LENGTH_SHORT).show()
            }else {
                avisoTele.visibility = View.INVISIBLE


                val intent = Intent(this, Numero::class.java).apply{
                    putExtra("numero", telefoneTxt )
                }

                startActivity(intent)
            }

        }
    }
}