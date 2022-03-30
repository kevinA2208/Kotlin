package com.example.saltamontesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.saltamontesapp.clases.Estudiantes
import com.example.saltamontesapp.clases.Operaciones

class MostrarResultados : AppCompatActivity() {
    var miEstudiante: Estudiantes? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_resultados)
        iniciar()
    }

    private fun iniciar(){
        var miBundle: Bundle? = this.intent.extras
        var nombre = miBundle?.getString("nombre")
        var materia1 = miBundle?.getString("materia1")
        var nota1 = miBundle?.getString("nota1")
        var materia2 = miBundle?.getString("materia2")
        var nota2 = miBundle?.getString("nota2")
        var materia3 = miBundle?.getString("materia3")
        var nota3 = miBundle?.getString("nota3")
        var materia4 = miBundle?.getString("materia4")
        var nota4 = miBundle?.getString("nota4")
        var materia5 = miBundle?.getString("materia5")
        var nota5 = miBundle?.getString("nota5")
        var promedio = miBundle?.getString("promedio")
        var estado = miBundle?.getString("estado")

        val botonSalir: Button = findViewById(R.id.buttonSalir2)
        botonSalir.setOnClickListener{salir()}

        val textNombre:TextView = findViewById(R.id.textNombre)
        val textMateria1:TextView = findViewById(R.id.textMateria1)
        val textNota1:TextView = findViewById(R.id.textNota1)
        val textMateria2:TextView = findViewById(R.id.textMateria2)
        val textNota2:TextView = findViewById(R.id.textNota2)
        val textMateria3:TextView = findViewById(R.id.textMateria3)
        val textNota3:TextView = findViewById(R.id.textNota3)
        val textMateria4:TextView = findViewById(R.id.textMateria4)
        val textNota4:TextView = findViewById(R.id.textNota4)
        val textMateria5:TextView = findViewById(R.id.textMateria5)
        val textNota5:TextView = findViewById(R.id.textNota5)
        val textPromedio:TextView = findViewById(R.id.textPromedio)
        val textMensajeFinal:TextView = findViewById(R.id.textMensajeFinal)

        textNombre.text = nombre
        textMateria1.text = materia1
        textNota1.text = nota1
        textMateria2.text = materia2
        textNota2.text = nota2
        textMateria3.text = materia3
        textNota3.text = nota3
        textMateria4.text = materia4
        textNota4.text = nota4
        textMateria5.text = materia5
        textNota5.text = nota5
        textPromedio.text = promedio
        textMensajeFinal.text = "Su estado es: $estado"
    }
    fun salir(){
        startActivity(Intent(this, MainActivity::class.java))
    }


}