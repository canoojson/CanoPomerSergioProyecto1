package com.example.canopomersergioproyecto1.modelo


data class Pedido(
    var vehiculo : Vehiculo,
    val usuario : Usuario,
    val Gps : Boolean,
    val tiempoAlquiler: Int,
    val precio : Int
    )


