package com.example.laboratoriout5_laruta_hacia_la_montaa_del_destino

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Adaptador personalizado para renderizar la lista de etapas del viaje.
 * Implementa el patrón de reciclaje de vistas mediante el parámetro convertView.
 */
class EtapaAdapter(
    private val context: Context,
    private val listaEtapas: List<Etapa>
) : BaseAdapter() {

    override fun getCount(): Int = listaEtapas.size

    override fun getItem(position: Int): Any = listaEtapas[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Reutilizamos la vista existente o inflar una nueva si es nula
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_etapa, parent, false)

        // Obtenemos los datos de la posición actual
        val etapa = listaEtapas[position]

        // Vinculamos los componentes gráficos de la fila
        val ivMiniatura = view.findViewById<ImageView>(R.id.ivMiniatura)
        val tvNombre = view.findViewById<TextView>(R.id.tvNombreEtapa)
        val tvPeligro = view.findViewById<TextView>(R.id.tvPeligroEtapa)

        // Asignamos los valores del modelo
        tvNombre.text = etapa.nombre
        tvPeligro.text = "Amenaza: ${etapa.peligro}"
        ivMiniatura.setImageResource(etapa.imagenResId)

        return view
    }
}
