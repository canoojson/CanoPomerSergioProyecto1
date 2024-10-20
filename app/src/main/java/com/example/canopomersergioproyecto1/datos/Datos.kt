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
    val moto = Moto(250)
    val turismo = Turismo("Gasolina")
    val patinete = Patinete()
    val listaPedidos : MutableList<Pedido> = mutableListOf(
        Pedido(moto, usuario,true, 2,50),
        Pedido(turismo, usuario,false, 1,20),
        Pedido(patinete, usuario,false,3,15)
    )
    fun cargarpedidos(): List<Pedido> = listaPedidos

    fun obtenerUsuario(): Usuario = usuario

}