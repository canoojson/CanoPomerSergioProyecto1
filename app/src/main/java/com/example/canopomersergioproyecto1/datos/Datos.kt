package com.example.canopomersergioproyecto1.datos

import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.modelo.Pedido

class Datos {
    fun cargarpedidos(): List<Pedido> = listOf(
        Pedido(R.string.moto,R.drawable.moto),
        Pedido(R.string.coche_de_turismo,R.drawable.coche_de_turismo),
        Pedido(R.string.scooter_electrico,R.drawable.scooter_electrico)
    )
}