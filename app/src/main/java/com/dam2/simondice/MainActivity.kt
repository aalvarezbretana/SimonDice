package com.dam2.simondice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    var random:Int = (0..3).random()
    val fourColors:Array<String> = arrayOf("Green", "Yellow", "Blue", "Red")
    val allColors:ArrayList<String> = arrayListOf(fourColors[random])
    val start:Button = findViewById<Button>(R.id.startButton)
    val activitiesArray:Array<Class<Verde>> = arrayOf(Verde::class.java)

    for(i:Int in 0..3){
        random = (0..3).random()
        allColors.add(fourColors[random])
    }

    start.setOnClickListener {
        val intent = Intent(this@MainActivity, Verde::class.java)
        intent.putStringArrayListExtra("colors",allColors)
    }


    }
}