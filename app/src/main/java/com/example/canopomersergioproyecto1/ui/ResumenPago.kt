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
import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Turismo

@Composable
fun ResumenPago(navController: NavController, modifier: Modifier = Modifier){

    val pedido = Datos().listaPedidos[1]

    val vehiculo = pedido.vehiculo

    val GPS = pedido.Gps

    val tiempoAlquiler = pedido.tiempoAlquiler


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = stringResource(R.string.resumen_de_pago),
                modifier = Modifier.padding(16.dp),
                fontSize = 30.sp)
            Text(stringResource(R.string.vehiculo) + ": " + stringResource(pedido.vehiculo.stringResId),
                fontSize = 20.sp)
            //Uso espacios ya que el \t no me funciona o no se aplicarlo bien
            if(pedido.vehiculo.stringResId== R.string.coche_de_turismo){
                Text("Combustible: " + (vehiculo as Turismo).combustible + "                 " +
                    if ((vehiculo as Turismo).combustible == stringResource(R.string.el_ctrico)) { "15€/" + stringResource(
                        R.string.dia
                    )}
                    else if((vehiculo as Turismo).combustible == stringResource(R.string.gasolina)) {"20€/" + stringResource(
                        R.string.dia
                    )}
                    else {"25€/" + stringResource(R.string.dia)},
                    fontSize = 20.sp)
            }else if(pedido.vehiculo.stringResId== R.string.moto){
                Text("Cilindrada: " + (pedido.vehiculo as Moto).cilindrada + "                 " +
                        if ((vehiculo as Moto).cilindrada == 50) { "10€/" + stringResource(R.string.dia)}
                        else if((vehiculo as Moto).cilindrada == 125) {"15€/" + stringResource(R.string.dia)}
                        else {"20€/" + stringResource(R.string.dia)},
                    fontSize = 20.sp)
            }
            Text("GPS: " + if(pedido.Gps) "Sí" + "                               "
                    + "5€/" + stringResource(R.string.dia) else "No",
                fontSize = 20.sp)
            Text(
                stringResource(R.string.dias_de_alquiler) + pedido.tiempoAlquiler,
                fontSize = 20.sp)
            Text(
                stringResource(R.string.precio_total)+ "                                    " + (pedido.precio) + "€",
                fontSize = 20.sp)
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)){
            Button(onClick = {navController.navigate("pantallaInicio")},
                modifier = Modifier.padding(end = 20.dp)) {
                Text(stringResource(R.string.aceptar),
                    fontSize = 20.sp)
            }
            Button(onClick = {/*TODO*/}) {
                Text(stringResource(R.string.enviar),
                    fontSize = 20.sp)
            }
        }
    }
}