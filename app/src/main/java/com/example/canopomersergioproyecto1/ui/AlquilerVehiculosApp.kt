package com.example.canopomersergioproyecto1.ui

import androidx.annotation.StringRes
import com.example.canopomersergioproyecto1.R

enum class Pantallas(@StringRes val titulo: Int){
    Inicio(titulo = R.string.inicio),
    ListarPedidos(titulo = R.string.listado_de_pedidos),
    RealizarPedido(titulo = R.string.realizar_pedido),
    ResumenPago(titulo = R.string.resumen_de_pago),



}