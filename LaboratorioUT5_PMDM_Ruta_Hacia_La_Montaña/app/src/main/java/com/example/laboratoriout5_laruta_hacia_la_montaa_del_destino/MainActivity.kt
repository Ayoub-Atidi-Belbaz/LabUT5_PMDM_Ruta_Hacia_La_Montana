package com.example.laboratoriout5_laruta_hacia_la_montaa_del_destino

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOMBRE = "EXTRA_NOMBRE"
        const val EXTRA_PELIGRO = "EXTRA_PELIGRO"
    }

    private lateinit var listaEtapas: List<Etapa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Configuramos la Toolbar como soporte de ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val lvEtapas = findViewById<ListView>(R.id.lvEtapas)

        // Cargamos etapas referenciando directamente los recursos estáticos
        listaEtapas = listOf(
            Etapa("La Comarca", "Nula", R.drawable.la_comarca),
            Etapa("Rivendell", "Baja", R.drawable.rivendell),
            Etapa("Minas de Moria", "Extrema", R.drawable.moria),
            Etapa("Lothlórien", "Baja", R.drawable.lothlorien),
            Etapa("Mordor", "Crítica", R.drawable.mordor)
        )

        // Vinculamos el adaptador personalizado
        val adapter = EtapaAdapter(this, listaEtapas)
        lvEtapas.adapter = adapter

        // Registramos obligatoriamente el ListView para soporte de menús contextuales
        registerForContextMenu(lvEtapas)
    }

    // ---  Barra de herramientas ---
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.opc_abandonar -> {
                finish() // Cierre controlado de la aplicación
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // --- Menu contextual flotante ---
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual_etapa, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // Rescatamos AdapterContextMenuInfo para conocer la posición exacta del elemento pulsado
        val info = item.menuInfo as? AdapterView.AdapterContextMenuInfo
            ?: return super.onContextItemSelected(item)

        val etapaSeleccionada = listaEtapas[info.position]

        return when (item.itemId) {
            R.id.ctx_inspeccionar -> {
                // Navegamos mediante Intent Explícito inyectando únicamente el nombre y nivel de peligro
                val intent = Intent(this, DetalleActivity::class.java).apply {
                    putExtra(EXTRA_NOMBRE, etapaSeleccionada.nombre)
                    putExtra(EXTRA_PELIGRO, etapaSeleccionada.peligro)
                }
                startActivity(intent)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
