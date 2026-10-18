package com.example.laboratoriout5_laruta_hacia_la_montaa_del_destino

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratoriout5_laruta_hacia_la_montaa_del_destino.MainActivity.Companion.EXTRA_NOMBRE
import com.example.laboratoriout5_laruta_hacia_la_montaa_del_destino.MainActivity.Companion.EXTRA_PELIGRO

/**
 * Pantalla de detalle para visualizar la información de la etapa inspeccionada.
 * Recupera los datos pasados como Extras en el Intent explícito.
 */
class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val tvTituloDetalle = findViewById<TextView>(R.id.tvTituloDetalle)
        val tvPeligroDetalle = findViewById<TextView>(R.id.tvPeligroDetalle)

        // Rescate de extras mediante el objeto intent y asignación a sus TextView correspondientes
        tvTituloDetalle.text = intent.getStringExtra(EXTRA_NOMBRE)
        tvPeligroDetalle.text = intent.getStringExtra(EXTRA_PELIGRO)
    }
}
