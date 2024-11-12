package com.example.canopomersergioproyecto1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Pedido
import com.example.canopomersergioproyecto1.modelo.Turismo
import com.example.canopomersergioproyecto1.modelo.Vehiculo

@Composable
fun TarjetaPedido(pedido: Pedido, modifier: Modifier = Modifier){

    var abierto by remember { mutableStateOf(false) }

    Card(modifier = Modifier.padding(bottom = 20.dp, start = 20.dp, end = 20.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(pedido.vehiculo.imagenResId),
                contentDescription = stringResource(R.string.imagen_del_vehiculo),
                modifier = Modifier
                    .size(66.dp)
                    .padding(start = 20.dp)
            )
            Text(
                text = stringResource(pedido.vehiculo.stringResId),
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            TarjetaBoton(
                abierto = abierto,
                onClick = { abierto = !abierto}
            )
        }
        if (abierto) {
            InformacionPedido(
                pedido.vehiculo,pedido.tiempoAlquiler,pedido.precio,pedido.Gps,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
            )
        }
    }
}

@Composable
private fun TarjetaBoton(
    abierto: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (abierto) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = if (abierto) stringResource(R.string.abrir) else stringResource(R.string.cerrar)
        )
    }

}

@Composable
fun ListaPedidos(lista: List<Pedido>, modifier: Modifier = Modifier){

    LazyColumn(modifier = modifier) {
        //Mandara a una pantalla en la que se mostraran los detalles del pedido
        items(lista) { pedido ->
            TarjetaPedido(
                pedido = pedido,
                modifier = Modifier
            )
        }

    }
}
@Composable
fun ListarPedidos(navController: NavController, modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Text(
            stringResource(R.string.pedidos),
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 10.dp,
                top = 15.dp))
        ListaPedidos(
            lista = Datos().cargarpedidos(),
            modifier = modifier
        )
        Button(onClick = {navController.navigate("pantallaInicio")}) {
            Text(stringResource(R.string.volver),
                fontSize = 20.sp)
        }
    }
}

@Composable
fun InformacionPedido(
    vehiculo: Vehiculo,
    diasAlquiler: Int,
    precio: Int,
    Gps :Boolean,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Text(stringResource(R.string.vehiculo) + ": " + stringResource(vehiculo.stringResId),
            fontSize = 20.sp)
        if(vehiculo.stringResId== R.string.coche_de_turismo){
            Text(
                stringResource(R.string.combustible)+ ": " + (vehiculo as Turismo).combustible,
                fontSize = 20.sp)
        }else if(vehiculo.stringResId== R.string.moto){
            Text(
                stringResource(R.string.cilindrada) + ": " + (vehiculo as Moto).cilindrada,
                fontSize = 20.sp)
        }
        Text("GPS: " + if(Gps) "Sí" else "No",
            fontSize = 20.sp)
        Text(stringResource(R.string.dias_de_alquiler) + diasAlquiler,
            fontSize = 20.sp)
    }

}