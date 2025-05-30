package com.example.quiz1.model

import java.io.Serializable

data class Curso(
    val id: Int,
    val nombre: String,
    val codigo: String,
    val creditos: Int,
    val horario: String
): Serializable
