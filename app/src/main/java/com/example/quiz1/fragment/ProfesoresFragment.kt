package com.example.quiz1.fragment

import android.icu.lang.UCharacter.IndicPositionalCategory.RIGHT
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.example.quiz1.R
import com.example.quiz1.adapter.ProfesoresAdapter
import com.example.quiz1.model.Profesor
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfesoresFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var adapter: ProfesoresAdapter
    private lateinit var fab: FloatingActionButton

    private val listaProfesores = mutableListOf(
        Profesor(1, "Carlos Ramírez", "8888-1111", "carlos@mail.com", "Matemáticas"),
        Profesor(2, "Laura Gómez", "8999-2222", "laura@mail.com", "Programación")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profesores, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewProfesores)
        searchView = view.findViewById(R.id.searchViewProfesores)
        fab = view.findViewById(R.id.fabProfesores)

        adapter = ProfesoresAdapter(listaProfesores)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false
            override fun onQueryTextChange(newText: String?): Boolean {
                // No se implementa filtro aún
                return false
            }
        })

        val swipeHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or RIGHT) {
            override fun onMove(rv: RecyclerView, vh: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = false
            override fun onSwiped(vh: RecyclerView.ViewHolder, dir: Int) {
                val pos = vh.adapterPosition
                val profesor = listaProfesores[pos]
                if (dir == ItemTouchHelper.LEFT) {
                    adapter.eliminarItem(pos)
                    Toast.makeText(requireContext(), "Eliminado: ${profesor.nombre}", Toast.LENGTH_SHORT).show()
                } else {
                    adapter.notifyItemChanged(pos)
                    Toast.makeText(requireContext(), "Editar: ${profesor.nombre}", Toast.LENGTH_SHORT).show()
                }
            }
        })
        swipeHelper.attachToRecyclerView(recyclerView)

        fab.setOnClickListener {
            val nuevoId = (listaProfesores.maxOfOrNull { it.id } ?: 0) + 1
            val nuevoProfesor = Profesor(nuevoId, "Profesor $nuevoId", "8888-0000", "nuevo@mail.com", "General")
            adapter.agregarItem(nuevoProfesor)
            Toast.makeText(requireContext(), "Profesor agregado", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
