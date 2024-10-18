package com.example.canopomersergioproyecto1.datos

import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Patinete
import com.example.canopomersergioproyecto1.modelo.Pedido
import com.example.canopomersergioproyecto1.modelo.Turismo
import com.example.canopomersergioproyecto1.modelo.Usuario

class Datos {
    val usuario = Usuario("Sergio", "Cano","Pomer",
        "loremipsum@lorem.com", "+34 000111222", R.drawable.fotoperfil)
    val moto = Moto(250, true)
    val turismo = Turismo("Gasolina", true)
    val patinete = Patinete(true)
    val listaPedidos : MutableList<Pedido> = mutableListOf(
        Pedido(moto, usuario,true, 2),
        Pedido(turismo, usuario,false, 1),
        Pedido(patinete, usuario,false,3)
    )
    fun cargarpedidos(): List<Pedido> = listaPedidos

    fun obtenerUsuario(): Usuario = usuario

}