package com.example.canopomersergioproyecto1.modelo


data class Pedido(
    var vehiculo: Vehiculo?,
    var usuario: Usuario?,
    var datosPago: DatosPago?,
    val Gps: Boolean,
    val tiempoAlquiler: Int,
    val precio: Int

    )


