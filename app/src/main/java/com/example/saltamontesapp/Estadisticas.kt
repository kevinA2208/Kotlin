package com.example.saltamontesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.saltamontesapp.clases.Operaciones

class Estadisticas : AppCompatActivity() {
    var miOperacion : Operaciones = Globals.miOperacion

    var lista = miOperacion.estudiantesList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        var textEstudProc:TextView = findViewById(R.id.textEstudProcesados)
        var textEstudAprob:TextView = findViewById(R.id.textEstudAprobados)
        var textEstudRepro:TextView = findViewById(R.id.textEstudReprobados)
        var textEstudRecup:TextView = findViewById(R.id.textEstudRecuperar)
        var buttonSalir:Button = findViewById(R.id.buttonSalir)

        buttonSalir.setOnClickListener({salir()})

        var estudTotales = lista.size
        var estudAprobados = estudiantesAprobados()
        var estudReprobados = estudiantesReprobados()
        var estudRecuperar = estudiantesRecuperar()

        textEstudProc.text = "$estudTotales"
        textEstudAprob.text = "$estudAprobados"
        textEstudRepro.text = "$estudReprobados"
        textEstudRecup.text = "$estudRecuperar"


    }

    private fun estudiantesAprobados(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.estado.equals("aprobado")){
                cantidad = cantidad + 1
            }
        }
        return cantidad
    }

    private fun estudiantesReprobados(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.estado.equals("reprobado")){
                cantidad = cantidad + 1
            }
        }
        return cantidad
    }

    private fun estudiantesRecuperar(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.estado.equals("recuperar")){
                cantidad = cantidad + 1
            }
        }
        return cantidad
    }

    private fun salir(){
        startActivity(Intent(this, MainActivity::class.java))
    }


}