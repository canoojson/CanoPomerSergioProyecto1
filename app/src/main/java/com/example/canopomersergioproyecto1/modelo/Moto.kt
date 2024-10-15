package com.example.canopomersergioproyecto1.modelo

import com.example.canopomersergioproyecto1.R

data class Moto(
    val cilindrada: Int,
    override val tieneGps: Boolean = false,
    override val imagenResId: Int = R.drawable.moto,
    override val stringResId: Int = R.string.moto
) : Vehiculo

