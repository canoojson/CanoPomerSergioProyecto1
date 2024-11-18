package com.example.canopomersergioproyecto1.modelo

data class DatosPago(
    val metodoPago: String,
    val numeroTarjeta: String,
    val fechaCaducidad: String,
    val cvc: String
)
