// src/main/java/com/example/quiz1/adapter/CursosAdapter.kt
package com.example.quiz1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz1.R
import com.example.quiz1.model.Curso

class CursosAdapter(private val items: List<Curso>) :
    RecyclerView.Adapter<CursosAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvNombre: TextView = v.findViewById(R.id.tvCursoNombre)
        val tvCodigo: TextView = v.findViewById(R.id.tvCursoCodigo)
        val tvCreditos: TextView = v.findViewById(R.id.tvCursoCreditos)
        val tvHorario: TextView = v.findViewById(R.id.tvCursoHorario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.curso_item, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val c = items[position]
        holder.tvNombre.text = "Curso: ${c.nombre}"
        holder.tvCodigo.text = "Código: ${c.codigo}"
        holder.tvCreditos.text = "Créditos: ${c.creditos}"
        holder.tvHorario.text = "Horario: ${c.horario}"
    }
}
