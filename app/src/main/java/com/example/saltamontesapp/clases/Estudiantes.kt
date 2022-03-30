package com.example.saltamontesapp.clases

import java.io.Serializable

class Estudiantes : Serializable {
    var documento:String = ""
    var nombre:String = ""
    var edad:String = ""
    var telefono:String = ""
    var direccion:String = ""
    var estado:String = ""

    var materia1: String=""
    var materia2: String=""
    var materia3: String=""
    var materia4: String=""
    var materia5: String=""

    var nota1: Double=0.0
    var nota2: Double=0.0
    var nota3: Double=0.0
    var nota4: Double=0.0
    var nota5: Double=0.0

    var promedio:Double=0.0

    override fun toString(): String {
        return "Estudiante(documento='$documento', nombre='$nombre'," +
                " edad=$edad, telefono='$telefono', direccion='$direccion'," +
                " materia1='$materia1', materia2='$materia2', " +
                "materia3='$materia3', materia4='$materia4', materia5='$materia5'," +
                " nota1=$nota1, nota2=$nota2, nota3=$nota3, nota4=$nota4, " +
                "nota5=$nota5, promedio=$promedio, estado=$estado)"

    }
}