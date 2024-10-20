package com.example.canopomersergioproyecto1.modelo

import com.example.canopomersergioproyecto1.R

data class Turismo(
    var combustible: String,
    override val imagenResId: Int = R.drawable.coche_de_turismo,
    override val stringResId: Int = R.string.coche_de_turismo
): Vehiculo
