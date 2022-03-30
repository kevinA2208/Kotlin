package com.example.saltamontesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ayuda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        var buttonSalir:Button = findViewById(R.id.buttonSalir)

        buttonSalir.setOnClickListener({salir()})
    }

    fun salir(){
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}