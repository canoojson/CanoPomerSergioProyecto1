package com.example.canopomersergioproyecto1.modelo

import com.example.canopomersergioproyecto1.R

data class Turismo(
    val combustible: String,
    override val tieneGps: Boolean = false,
    override val imagenResId: Int = R.drawable.coche_de_turismo,
    override val stringResId: Int = R.string.coche_de_turismo
): Vehiculo
