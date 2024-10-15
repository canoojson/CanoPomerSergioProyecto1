package com.example.canopomersergioproyecto1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.modelo.Pedido

@Composable
fun TarjetaPedido(pedido: Pedido, modifier: Modifier = Modifier){
    Card(modifier = Modifier.padding(bottom = 20.dp, start = 20.dp, end = 20.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(pedido.vehiculo.imagenResId),
                contentDescription = stringResource(R.string.imagen_del_vehiculo),
                modifier = Modifier.size(66.dp).padding(start = 20.dp)
            )
            Text(
                text = stringResource(pedido.vehiculo.stringResId),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ItemPedido(pedido: Pedido, onItemClick: (Pedido) -> Unit){
    TarjetaPedido(
        pedido = pedido,
        modifier = Modifier
            .clickable { onItemClick(pedido) }
            .padding(8.dp),
    )
}

@Composable
fun ListaPedidos(lista: List<Pedido>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(lista) { pedido ->
            ItemPedido(
                pedido = pedido,
                onItemClick = { pedidoElegido ->
                    /*TODO*/
                }
            )
        }
    }
}
@Composable
fun ListarPedidos(modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Text("Pedidos",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 10.dp))
        ListaPedidos(
            lista = Datos().cargarpedidos(),
            modifier = modifier
        )
    }

}