package com.example.saltamontesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.saltamontesapp.clases.Estudiantes
import com.example.saltamontesapp.clases.Operaciones
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciar()
    }

    fun iniciar() {
        var botonRegistrar: Button = findViewById(R.id.buttonVentRegistrar)
        botonRegistrar.setOnClickListener{registrarEstudiantes()}

        var botonEstadisticas:Button = findViewById(R.id.buttonEstadisticas)
        botonEstadisticas.setOnClickListener{mostrarEstadisticas()}

        var botonAyuda:Button = findViewById(R.id.buttonAyuda)
        botonAyuda.setOnClickListener{mostrarAyuda()}
    }

    fun registrarEstudiantes(){
        val intent = Intent(this, RegistrarEstudiantes::class.java)
        startActivity(intent)
    }

    fun mostrarEstadisticas(){
        val intent = Intent(this, Estadisticas::class.java)
        startActivity(intent)
    }

    fun mostrarAyuda(){
        val intent = Intent(this, Ayuda::class.java)
        startActivity(intent)
    }
}

