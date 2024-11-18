package com.example.canopomersergioproyecto1.modelo

import com.example.canopomersergioproyecto1.datos.Datos

data class AppUIState(
    val pedido: Pedido? = null,
    val pedidos: List<Pedido> = mutableListOf(
        Pedido(Datos().moto, Datos().usuario,null,true, 2,50),
        Pedido(Datos().turismo, Datos().usuario,null,false, 1,20),
        Pedido(Datos().patinete, Datos().usuario,null,false,3,15))
)
