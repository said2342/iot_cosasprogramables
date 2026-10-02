package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imgorko = findViewById<ImageView>(R.id.orko_id)
        val txtDescripcion = findViewById<TextView>(R.id.txt_id)
        val botonrandom = findViewById<Button>(R.id.boton_id)
        val spin = findViewById<Spinner>(R.id.spin_id)
        var aleatorio = 0


        val nombres = listOf(
            "waaagh", "wiii"
        )
        val descripciones = listOf(
            "orko empresaurio", "tenemos al sufre en silencio y al subre exprexivo"
        )
        val imagenes = listOf(
            R.drawable.waaagh, R.drawable.wiii
        )

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, nombres
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spin.adapter = adapter

        spin.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    imgorko.setImageResource(imagenes[position])
                    txtDescripcion.text = descripciones[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        botonrandom.setOnClickListener(
            aleatorio = Random.nexInt(1,3)
        )


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart() llamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause() llamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop() llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume() llamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy() llamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart() llamado")
    }
}