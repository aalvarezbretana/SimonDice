package com.dam2.simondice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var random: Int = (0..3).random()
        val fourColors: Array<String> = arrayOf("Green", "Yellow", "Blue", "Red")
        val allColors: ArrayList<String> = arrayListOf(fourColors[random])
        val start: Button = findViewById<Button>(R.id.startButton)
        val activitiesArray: Array<Class<out AppCompatActivity>> = arrayOf(Verde::class.java, Amarillo::class.java, Azul::class.java, Rojo::class.java)

        for (i: Int in 0..3) {
            random = (0..3).random()
            allColors.add(fourColors[random])
        }

        start.setOnClickListener {
            val intent = Intent(this@MainActivity, activitiesArray[random])
            intent.putStringArrayListExtra("colors", allColors)
            intent.putExtra("count", 0)
            intent.putExtra("score", 0)
            startActivity(intent)
        }
    }
}