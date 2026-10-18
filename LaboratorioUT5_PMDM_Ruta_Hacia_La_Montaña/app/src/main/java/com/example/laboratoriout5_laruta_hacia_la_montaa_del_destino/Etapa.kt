package com.example.laboratoriout5_laruta_hacia_la_montaa_del_destino

/**
 * Entidad inmutable que modela cada territorio de la ruta.
 * @param nombre Nombre de la región o parada de la expedición.
 * @param peligro Nivel de amenaza (Nula, Baja, Media, Extrema, Crítica).
 * @param imagenResId Identificador numérico del recurso gráfico (R.drawable.*).
 */
data class Etapa(
    val nombre: String,
    val peligro: String,
    val imagenResId: Int
)
