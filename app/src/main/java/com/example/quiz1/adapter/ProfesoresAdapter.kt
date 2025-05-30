package com.example.quiz1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz1.R
import com.example.quiz1.model.Profesor

class ProfesoresAdapter(
    private val profesores: MutableList<Profesor>
) : RecyclerView.Adapter<ProfesoresAdapter.ProfesorViewHolder>() {

    inner class ProfesorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreProfesor)
        val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefonoProfesor)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmailProfesor)
        val tvEspecialidad: TextView = itemView.findViewById(R.id.tvEspecialidadProfesor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfesorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profesor_item, parent, false)
        return ProfesorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfesorViewHolder, position: Int) {
        val profesor = profesores[position]
        holder.tvNombre.text = "Nombre: ${profesor.nombre}"
        holder.tvTelefono.text = "Teléfono: ${profesor.telefono}"
        holder.tvEmail.text = "Email: ${profesor.email}"
        holder.tvEspecialidad.text = "Especialidad: ${profesor.especialidad}"
    }

    override fun getItemCount(): Int = profesores.size

    fun agregarItem(profesor: Profesor) {
        profesores.add(profesor)
        notifyItemInserted(profesores.size - 1)
    }

    fun eliminarItem(pos: Int) {
        profesores.removeAt(pos)
        notifyItemRemoved(pos)
    }
}
