package com.example.canopomersergioproyecto1.datos

import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Patinete
import com.example.canopomersergioproyecto1.modelo.Turismo
import com.example.canopomersergioproyecto1.modelo.Usuario

class Datos {
    val moto = Moto(250)
    val turismo = Turismo("Gasolina")
    val patinete = Patinete()
    val usuario = Usuario("Sergio", "Cano","Pomer",
        "loremipsum@lorem.com", "+34 000111222", R.drawable.fotoperfil)
    fun obtenerUsuario(): Usuario = Datos().usuario
}