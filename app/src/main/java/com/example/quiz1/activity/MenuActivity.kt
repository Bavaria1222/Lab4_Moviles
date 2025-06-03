package com.example.quiz1.activity

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz1.R
import com.example.quiz1.fragment.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Recuperar usuario logueado
        val prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE)
        val usuario = prefs.getString("usuario", "Usuario")

        // Mostrar saludo
        findViewById<TextView>(R.id.tvBienvenida).text = "Bienvenido, $usuario"

        // ------------------------------
        // 1) Estudiantes
        findViewById<TextView>(R.id.btnEstudiantes).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, AlumnosFragment())
                .addToBackStack(null)
                .commit()
        }

        // 2) Profesores
        findViewById<TextView>(R.id.btnProfesores).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, ProfesoresFragment())
                .addToBackStack(null)
                .commit()
        }

        // 3) Usuarios
        findViewById<TextView>(R.id.btnUsuarios).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, UsuariosFragment())
                .addToBackStack(null)
                .commit()
        }

        // 4) Carreras
        findViewById<TextView>(R.id.btnCarreras).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, CarrerasFragment())
                .addToBackStack(null)
                .commit()
        }

        // 5) Cursos
        findViewById<TextView>(R.id.btnCursos).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, CursosFragment())
                .addToBackStack(null)
                .commit()
        }

        // 6) Ciclos
        findViewById<TextView>(R.id.btnCiclos).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, CiclosFragment())
                .addToBackStack(null)
                .commit()
        }

        // 7) Grupos
        findViewById<TextView>(R.id.btnGrupos).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, GruposFragment())
                .addToBackStack(null)
                .commit()
        }

        // 8) Matrículas
        findViewById<TextView>(R.id.btnMatriculas).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, MatriculaFragment())
                .addToBackStack(null)
                .commit()
        }

        // 9) Plan de Estudio
        findViewById<TextView>(R.id.btnPlanEstudio).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, PlanEstudioFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
