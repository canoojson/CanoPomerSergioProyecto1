package com.example.canopomersergioproyecto1.modelo


data class Pedido(
    val vehiculo : Vehiculo,
    val usuario : Usuario,
    val Gps : Boolean,
    val tiempoAlquiler: Int
    )


