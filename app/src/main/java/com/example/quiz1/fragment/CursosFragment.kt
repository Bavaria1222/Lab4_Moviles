// src/main/java/com/example/quiz1/fragment/CursosFragment.kt
package com.example.quiz1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz1.R
import com.example.quiz1.adapter.CursosAdapter
import com.example.quiz1.api.ApiClient
import com.example.quiz1.api.CursoApi
import com.example.quiz1.model.Curso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CursosFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: CursosAdapter
    private val listaCursos = mutableListOf<Curso>()
    private val api = ApiClient.retrofit.create(CursoApi::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_cursos, container, false)

        recycler = view.findViewById(R.id.recyclerCursos)
        adapter = CursosAdapter(listaCursos)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        cargarCursosDesdeApi()

        return view
    }

    private fun cargarCursosDesdeApi() {
        api.listar().enqueue(object : Callback<List<Curso>> {
            override fun onResponse(call: Call<List<Curso>>, response: Response<List<Curso>>) {
                if (response.isSuccessful) {
                    listaCursos.clear()
                    listaCursos.addAll(response.body() ?: emptyList())
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(requireContext(), "Error al cargar cursos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Curso>>, t: Throwable) {
                Toast.makeText(requireContext(), "Fallo: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
