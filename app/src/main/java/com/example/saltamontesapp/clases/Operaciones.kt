package com.example.saltamontesapp.clases

import java.io.Serializable

class Operaciones : Serializable {
    var estudiantesList = arrayListOf<Estudiantes>()

    fun registrarEstudiante(estudiante: Estudiantes){
        estudiantesList.add(estudiante)
    }

    fun calcularPromedio(est: Estudiantes): Double {
        var promedio:Double = (est.nota1 + est.nota2+ est.nota3+est.nota4+est.nota5)/5
        return promedio
    }

    fun imprimirEstudiantes(){
        for(est in estudiantesList) {
            println(est)
        }
    }}