package com.example.saltamontesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.saltamontesapp.clases.Estudiantes
import com.example.saltamontesapp.clases.Operaciones
import org.w3c.dom.Text
import java.io.Serializable

class RegistrarEstudiantes : AppCompatActivity() {
    var miOperacion:Operaciones? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_estudiantes)
        iniciar()
    }

    private fun iniciar(){


        miOperacion = Globals.miOperacion

        val botonSalir: Button = findViewById(R.id.buttonSalir)
        botonSalir.setOnClickListener{salir()}

        val botonRegistrar: Button = findViewById(R.id.buttonRegistrar)
        botonRegistrar.setOnClickListener{registrarEstudiante()}
    }

    fun salir(){
        val intent=Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun registrarEstudiante(){
        val textMateria1:EditText = findViewById(R.id.editTextMateria1)
        val textMateria2:EditText = findViewById(R.id.editTextMateria2)
        val textMateria3:EditText = findViewById(R.id.editTextMateria3)
        val textMateria4:EditText = findViewById(R.id.editTextMateria4)
        val textMateria5:EditText = findViewById(R.id.editTextMateria5)

        var nomMateria1:String = textMateria1.text.toString()
        var nomMateria2:String = textMateria2.text.toString()
        var nomMateria3:String = textMateria3.text.toString()
        var nomMateria4:String = textMateria4.text.toString()
        var nomMateria5:String = textMateria5.text.toString()

        val textNota1:EditText = findViewById(R.id.editTextNota1)
        val textNota2:EditText = findViewById(R.id.editTextNota2)
        val textNota3:EditText = findViewById(R.id.editTextNota3)
        val textNota4:EditText = findViewById(R.id.editTextNota4)
        val textNota5:EditText = findViewById(R.id.editTextNota5)

        var nota1String:String = textNota1.text.toString()
        var nota2String:String = textNota2.text.toString()
        var nota3String:String = textNota3.text.toString()
        var nota4String:String = textNota4.text.toString()
        var nota5String:String = textNota5.text.toString()


        var nota1:Double = nota1String.toDouble()
        var nota2:Double = nota2String.toDouble()
        var nota3:Double = nota3String.toDouble()
        var nota4:Double = nota4String.toDouble()
        var nota5:Double = nota5String.toDouble()

        var miEstudiante: Estudiantes = Estudiantes()

        val textNombre:EditText = findViewById(R.id.editTextNombre)
        val textDocumento:EditText = findViewById(R.id.editTextDocumento)
        val textTelefono:EditText = findViewById(R.id.editTextTelefono)
        val textDireccion:EditText = findViewById(R.id.editTextDireccion)
        val textEdad:EditText = findViewById(R.id.editTextEdad)

        var nombre:String = textNombre.text.toString()
        var documento:String = textDocumento.text.toString()
        var telefono:String = textTelefono.text.toString()
        var direccion:String = textDireccion.text.toString()
        var edad:String = textEdad.text.toString()



        var textMensaje:TextView = findViewById(R.id.textViewMensaje)
        if(documento.isNullOrBlank() || nombre.isNullOrBlank() || telefono.isNullOrBlank()
            || direccion.isNullOrBlank() || edad.isNullOrBlank() || nomMateria1.isNullOrBlank() || nomMateria2.isNullOrBlank() || nomMateria3.isNullOrBlank() || nomMateria4.isNullOrBlank() || nomMateria5.isNullOrBlank()){
            textMensaje.text = "Rellene los campos porfavor"
        }else if(nota1 > 5 || nota1 < 0 || nota2 > 5 || nota2 < 0 || nota3 > 5 || nota3 < 0 || nota4 > 5 || nota4 < 0 || nota5 > 5 || nota5 < 0){
            textMensaje.text = "Ingrese notas entre 0 y 5"
        }else{
            miEstudiante.documento = documento
            miEstudiante.nombre = nombre
            miEstudiante.telefono = telefono
            miEstudiante.direccion = direccion
            miEstudiante.edad = edad

            miEstudiante.nota1 = nota1.toDouble()
            miEstudiante.nota2 = nota2.toDouble()
            miEstudiante.nota3 = nota3.toDouble()
            miEstudiante.nota4 = nota4.toDouble()
            miEstudiante.nota5 = nota5.toDouble()

            miEstudiante.materia1 = nomMateria1
            miEstudiante.materia2 = nomMateria2
            miEstudiante.materia3 = nomMateria3
            miEstudiante.materia4 = nomMateria4
            miEstudiante.materia5 = nomMateria5

            var promEstudiante:Double = miOperacion!!.calcularPromedio(miEstudiante).toDouble()
            promEstudiante = Math.round(promEstudiante * 10.0) / 10.0

            var mensaje ="Nombre: $nombre"

            if(promEstudiante >= 3.5){
                miEstudiante.estado="aprobado"
                miEstudiante.promedio =promEstudiante
                miOperacion!!.registrarEstudiante(miEstudiante)
                miOperacion!!.imprimirEstudiantes()

                var miBundle: Bundle? = Bundle()
                miBundle = Bundle()
                miBundle.putString("nombre", miEstudiante?.nombre)
                miBundle.putString("materia1", miEstudiante?.materia1)
                miBundle.putString("materia2", miEstudiante?.materia2)
                miBundle.putString("materia3", miEstudiante?.materia3)
                miBundle.putString("materia4", miEstudiante?.materia4)
                miBundle.putString("materia5", miEstudiante?.materia5)
                miBundle.putString("nota1", miEstudiante?.nota1.toString())
                miBundle.putString("nota2", miEstudiante?.nota2.toString())
                miBundle.putString("nota3", miEstudiante?.nota3.toString())
                miBundle.putString("nota4", miEstudiante?.nota4.toString())
                miBundle.putString("nota5", miEstudiante?.nota5.toString())
                miBundle.putString("promedio", miEstudiante?.promedio.toString())
                miBundle.putString("estado", miEstudiante?.estado)
                val intent = Intent(this, MostrarResultados::class.java)
                intent.putExtras(miBundle!!)
                startActivity(intent)
            }else if(promEstudiante > 2.5 && promEstudiante < 3.5){
                miEstudiante.estado="recuperar"
                miEstudiante.promedio =promEstudiante
                miOperacion!!.registrarEstudiante(miEstudiante)
                miOperacion!!.imprimirEstudiantes()

                var miBundle: Bundle? = Bundle()
                miBundle = Bundle()
                miBundle.putString("nombre", miEstudiante?.nombre)
                miBundle.putString("materia1", miEstudiante?.materia1)
                miBundle.putString("materia2", miEstudiante?.materia2)
                miBundle.putString("materia3", miEstudiante?.materia3)
                miBundle.putString("materia4", miEstudiante?.materia4)
                miBundle.putString("materia5", miEstudiante?.materia5)
                miBundle.putString("nota1", miEstudiante?.nota1.toString())
                miBundle.putString("nota2", miEstudiante?.nota2.toString())
                miBundle.putString("nota3", miEstudiante?.nota3.toString())
                miBundle.putString("nota4", miEstudiante?.nota4.toString())
                miBundle.putString("nota5", miEstudiante?.nota5.toString())
                miBundle.putString("promedio", miEstudiante?.promedio.toString())
                miBundle.putString("estado", miEstudiante?.estado)
                val intent = Intent(this, MostrarResultados::class.java)
                intent.putExtras(miBundle!!)
                startActivity(intent)
            }else if(promEstudiante < 2.5){
                miEstudiante.estado="reprobado"
                miEstudiante.promedio =promEstudiante
                miOperacion!!.registrarEstudiante(miEstudiante)
                miOperacion!!.imprimirEstudiantes()

                var miBundle: Bundle? = Bundle()
                miBundle = Bundle()
                miBundle.putString("nombre", miEstudiante?.nombre)
                miBundle.putString("materia1", miEstudiante?.materia1)
                miBundle.putString("materia2", miEstudiante?.materia2)
                miBundle.putString("materia3", miEstudiante?.materia3)
                miBundle.putString("materia4", miEstudiante?.materia4)
                miBundle.putString("materia5", miEstudiante?.materia5)
                miBundle.putString("nota1", miEstudiante?.nota1.toString())
                miBundle.putString("nota2", miEstudiante?.nota2.toString())
                miBundle.putString("nota3", miEstudiante?.nota3.toString())
                miBundle.putString("nota4", miEstudiante?.nota4.toString())
                miBundle.putString("nota5", miEstudiante?.nota5.toString())
                miBundle.putString("promedio", miEstudiante?.promedio.toString())
                miBundle.putString("estado", miEstudiante?.estado)

                val intent = Intent(this, MostrarResultados::class.java)
                intent.putExtras(miBundle!!)
                startActivity(intent)
            }


        }
    }
}