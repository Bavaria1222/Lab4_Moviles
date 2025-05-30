package com.example.quiz1.activity

import android.content.Intent
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz1.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegistro = findViewById<TextView>(R.id.tvRegistro)

        val prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val correo = etCorreo.text.toString()
            val clave = etContrasena.text.toString()

            val correoGuardado = prefs.getString("usuario", "")
            val claveGuardada = prefs.getString("clave", "")
            val estaLogueado = prefs.getBoolean("logueado", false)

            if (correo == correoGuardado && clave == claveGuardada) {
                prefs.edit().putBoolean("logueado", true).apply()
                startActivity(Intent(this, MenuActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegistro.setOnClickListener {
            startActivity(Intent(this, InscriptionActivity::class.java))
        }
    }
}
