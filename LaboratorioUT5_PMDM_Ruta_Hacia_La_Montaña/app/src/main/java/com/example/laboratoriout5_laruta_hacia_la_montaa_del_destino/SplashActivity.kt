package com.example.laboratoriout5_laruta_hacia_la_montaa_del_destino

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

/**
 * Pantalla de bienvenida con temporizador de 3 segundos (3000 ms).
 * Salta automáticamente a MainActivity y se destruye con finish().
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Temporizador de 3s en el Looper principal
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Imprescindible: saca SplashActivity de la pila de actividades
        }, 3000)
    }
}
