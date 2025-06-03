package com.example.quiz1.activity

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz1.R
import com.example.quiz1.adapter.MenuAdapter
import com.example.quiz1.fragment.*

class MenuActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private val items = mutableListOf<Pair<String, androidx.fragment.app.Fragment>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        drawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.drawer_open,
            R.string.drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE)
        val cedula = prefs.getString("cedula", "")
        val rol = prefs.getString("rol", "")
        findViewById<TextView>(R.id.tvBienvenida).text = "Bienvenido, $cedula"

        items.addAll(obtenerItemsPorRol(rol))

        val recyclerView = findViewById<RecyclerView>(R.id.menuRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MenuAdapter(items.map { it.first }) { pos ->
            mostrarFragment(items[pos].second)
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        if (items.isNotEmpty()) {
            mostrarFragment(items[0].second)
        }
    }

    private fun mostrarFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorFragmento, fragment)
            .commit()
    }

    private fun obtenerItemsPorRol(rol: String?): List<Pair<String, androidx.fragment.app.Fragment>> {
        return when (rol) {
            "Administrador" -> listOf(
                "Alumnos" to AlumnosFragment(),
                "Profesores" to ProfesoresFragment(),
                "Usuarios" to UsuariosFragment(),
                "Carreras" to CarrerasFragment(),
                "Cursos" to CursosFragment(),
                "Ciclos" to CiclosFragment(),
                "Grupos" to GruposFragment(),
                "Matrículas" to MatriculaFragment(),
                "Plan de Estudio" to PlanEstudioFragment()
            )
            "Matriculador" -> listOf("Matrículas" to MatriculaFragment())
            "Profesor" -> emptyList()
            "Alumno" -> emptyList()
            else -> emptyList()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }
}
