package com.example.canopomersergioproyecto1.datos

import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Patinete
import com.example.canopomersergioproyecto1.modelo.Pedido
import com.example.canopomersergioproyecto1.modelo.Turismo
import com.example.canopomersergioproyecto1.modelo.Usuario

class Datos {
    val usuario = Usuario("Sergio", "Cano","Pomer", "loremipsum@lorem.com", "+34 000111222")
    val moto = Moto(250, true)
    val turismo = Turismo("Gasolina", true)
    val patinete = Patinete(true)
    fun cargarpedidos(): List<Pedido> = listOf(
        Pedido(moto, usuario, 2),
        Pedido(turismo, usuario, 1),
        Pedido(patinete, usuario, 3)
    )
    fun obtenerUsuario(): Usuario = usuario
}