package com.example.canopomersergioproyecto1

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Turismo

@Preview(showBackground = true)
@Composable
fun ResumenPedido(modifier: Modifier = Modifier){

    val pedido = Datos().listaPedidos.get(2)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(stringResource(R.string.resumen_del_pedido),
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp,
                bottom = 30.dp))
        Text(stringResource(R.string.vehiculo) + ": " + stringResource(pedido.vehiculo.stringResId),
            fontSize = 20.sp)
        if(pedido.vehiculo.stringResId==R.string.coche_de_turismo){
            Text("Combustible: " + (pedido.vehiculo as Turismo).combustible,
                fontSize = 20.sp)
        }else if(pedido.vehiculo.stringResId==R.string.moto){
            Text("Cilindrada: " + (pedido.vehiculo as Moto).cilindrada,
                fontSize = 20.sp)
        }
        Text("GPS: " + if(pedido.Gps) "Sí" else "No",
            fontSize = 20.sp)
        Text("Dias de alquiler: " + pedido.tiempoAlquiler,
            fontSize = 20.sp)
        Row(modifier = Modifier.padding(top = 20.dp)){
            //Manda a la actividad FormularioPago
            Button(onClick = {/*TODO*/},
                modifier = Modifier) {
                Text(text = "Pagar")
            }
            //Manda a la pantalla de RealizarPedido
            Button(onClick = {/*TODO*/},
                modifier = Modifier.padding(start = 20.dp)) {
                Text(text = "Cancelar")
            }
        }

    }
}