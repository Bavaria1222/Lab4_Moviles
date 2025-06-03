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

        // Estudiantes
        findViewById<TextView>(R.id.btnEstudiantes).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, AlumnosFragment())
                .addToBackStack(null)
                .commit()
        }

        // Profesores
        findViewById<TextView>(R.id.btnProfesores).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, ProfesoresFragment())
                .addToBackStack(null)
                .commit()
        }

        // Carreras
        findViewById<TextView>(R.id.btnCarreras).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, CarrerasFragment())
                .addToBackStack(null)
                .commit()
        }
        //Cursos
        findViewById<TextView>(R.id.btnCursos).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, CursosFragment())
                .addToBackStack(null)
                .commit()
        }


        // Ciclos
        findViewById<TextView>(R.id.btnCiclos).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, CiclosFragment())
                .addToBackStack(null)
                .commit()
        }

        // Grupos
        findViewById<TextView>(R.id.btnGrupos).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, GruposFragment())
                .addToBackStack(null)
                .commit()
        }

        // Matrículas
        findViewById<TextView>(R.id.btnMatriculas).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, MatriculaFragment())
                .addToBackStack(null)
                .commit()
        }

        //Plan Estudio
        findViewById<TextView>(R.id.btnPlanEstudio).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, PlanEstudioFragment())
                .addToBackStack(null)
                .commit()
        }


        findViewById<TextView>(R.id.btnProfesores).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, ProfesoresFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}
