package com.example.canopomersergioproyecto1.modelo

import com.example.canopomersergioproyecto1.R

data class Patinete(
    override val tieneGps: Boolean = false,
    override val imagenResId: Int = R.drawable.scooter_electrico,
    override val stringResId: Int = R.string.scooter_electrico
) : Vehiculo

