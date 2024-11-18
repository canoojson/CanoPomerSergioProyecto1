package com.example.canopomersergioproyecto1.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.modelo.AppUIState
import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Turismo

@Composable
fun ResumenPedido(appUIState: AppUIState, onAceptarPulsado: () -> Unit, modifier: Modifier = Modifier){

    val pedido = appUIState.pedido

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(stringResource(R.string.resumen_del_pedido),
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp,
                bottom = 30.dp))
        Text(stringResource(R.string.vehiculo) + ": " + stringResource(pedido!!.vehiculo!!.stringResId),
            fontSize = 20.sp)
        if(pedido!!.vehiculo?.stringResId== R.string.coche_de_turismo){
            Text(
                stringResource(R.string.combustible)+ ": " + (pedido.vehiculo as Turismo).combustible,
                fontSize = 20.sp)
        }else if(pedido!!.vehiculo?.stringResId== R.string.moto){
            Text(
                stringResource(R.string.cilindrada) + ": " + (pedido.vehiculo as Moto).cilindrada,
                fontSize = 20.sp)
        }
        Text("GPS: " + if(pedido!!.Gps) "Sí" else "No",
            fontSize = 20.sp)
        Text(stringResource(R.string.dias_de_alquiler) + pedido.tiempoAlquiler,
            fontSize = 20.sp)
        Text(stringResource(R.string.precio_total) + ": " + pedido.precio +"€",
            fontSize = 20.sp)
        Row(modifier = Modifier.padding(top = 20.dp)){
            //Manda a la actividad FormularioPago
            Button(onClick = {onAceptarPulsado()},
                modifier = Modifier) {
                Text(text = stringResource(R.string.pagar),
                    fontSize = 20.sp)
            }
            //Manda a la pantalla de RealizarPedido
            /*Button(onClick = {},
                modifier = Modifier.padding(start = 20.dp)) {
                Text(text = stringResource(R.string.cancelar),
                    fontSize = 20.sp)
            }*/
        }

    }
}