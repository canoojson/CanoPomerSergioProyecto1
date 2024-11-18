package com.example.canopomersergioproyecto1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.modelo.AppUIState

@Composable
fun PantallaInicio(onRealizarPedidoPulsado: () -> Unit, onListarPedidosPulsado: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        var appUIState = AppUIState()
        Image(
            painter = painterResource(id= Datos().obtenerUsuario().fotoPerfil),
            contentDescription = stringResource(R.string.foto_de_perfil),
            modifier = Modifier.size(100.dp),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = Datos().obtenerUsuario().nombre
                    + " " + Datos().obtenerUsuario().apellido1
                    + " " + Datos().obtenerUsuario().apellido2
                    + " \n" + Datos().obtenerUsuario().email
                    + " \n" + Datos().obtenerUsuario().telefono
        )
        Spacer(modifier = Modifier.height(200.dp))
        Row {
            //Manda a la actividad RealizarPedido
            Button(onClick = {onRealizarPedidoPulsado()},
                modifier = Modifier.padding(end = 32.dp)) {
                Text(
                    stringResource(R.string.realizar_pedido),
                    fontSize = 20.sp)
            }
            //Manda a la actividad ListarPedidos
            Button(onClick = {onListarPedidosPulsado()}) {
                Text(
                    stringResource(R.string.listar_pedidos),
                    fontSize = 20.sp)
            }
        }
    }
}