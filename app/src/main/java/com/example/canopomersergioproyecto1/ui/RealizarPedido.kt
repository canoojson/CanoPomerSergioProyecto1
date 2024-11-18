package com.example.canopomersergioproyecto1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.modelo.AppUIState
import com.example.canopomersergioproyecto1.modelo.Moto
import com.example.canopomersergioproyecto1.modelo.Patinete
import com.example.canopomersergioproyecto1.modelo.Pedido
import com.example.canopomersergioproyecto1.modelo.Turismo
import com.example.canopomersergioproyecto1.modelo.Usuario
import com.example.canopomersergioproyecto1.modelo.Vehiculo


@Composable
fun RealizarPedido(onAceptarPulsado: (Pedido) -> Unit, modifier: Modifier = Modifier){

    val radioOptions = listOf(R.string.coche_de_turismo, R.string.moto, R.string.scooter_electrico)

    val (selectedOption, onOptionSelected) = remember { mutableIntStateOf(radioOptions[0]) }

    var diasAlquiler by  remember { mutableStateOf("") }

    val usuario : Usuario = Datos().obtenerUsuario()

    var precio = 0

    var GPS : Boolean

    var combustible : Int

    var cilindrada : Int

    var vehiculo : Vehiculo

    var pedido : Pedido


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Text(
            stringResource(R.string.realizar_pedido),
            fontSize = 30.sp,
            modifier = modifier.padding(top = 30.dp))

        Text(stringResource(R.string.vehiculo),
            fontSize = 20.sp,
            modifier = modifier.padding(top = 20.dp))
        Row(modifier = modifier) {
            radioOptions.forEach { text ->
                Row(modifier = modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {onOptionSelected(text)}
                    )
                    if (text == R.string.coche_de_turismo){
                        Image(
                            painter = painterResource(R.drawable.coche_de_turismo),
                            contentDescription = stringResource(R.string.imagen_del_vehiculo),
                            modifier = modifier
                                .size(30.dp))
                    }
                    if (text == R.string.moto){
                        Image(
                            painter = painterResource(R.drawable.moto),
                            contentDescription = stringResource(R.string.moto),
                            modifier = modifier
                                .size(30.dp))
                    }
                    if (text == R.string.scooter_electrico){
                        Image(
                            painter = painterResource(R.drawable.scooter_electrico),
                            contentDescription = stringResource(R.string.scooter_electrico),
                            modifier = modifier
                                .size(30.dp))
                    }
                    Text(
                        text = stringResource(text)
                    )
                }
            }
        }
        if(selectedOption == R.string.coche_de_turismo){
            Text(stringResource(R.string.combustible),
                fontSize = 20.sp,
                modifier = modifier.padding(top = 20.dp))
            combustible = pintarCombustible()
            if (combustible == R.string.di_sel){
                precio += 25
            }else if (combustible == R.string.gasolina){
                precio += 20
            }else{
                precio += 15
            }
            vehiculo = Turismo(stringResource(combustible), R.drawable.coche_de_turismo, R.string.coche_de_turismo)
        }else if(selectedOption == R.string.moto){

            Text(stringResource(R.string.cilindrada),
                fontSize = 20.sp,
                modifier = modifier.padding(top = 20.dp)
            )
            cilindrada = pintarCilindrada()

            if (cilindrada == R.string._250cc){
                precio += 25
            }else if (cilindrada == R.string._125cc){
                precio += 20
            }else{
                precio += 15
            }
            vehiculo = Moto(cilindrada, R.drawable.moto, R.string.moto)
        }else{
            precio += 5
            vehiculo = Patinete(R.drawable.scooter_electrico, R.string.scooter_electrico)
        }
        Text(stringResource(R.string.gps),
            fontSize = 20.sp,
            modifier = modifier.padding(top = 20.dp))
        GPS = pintarGPS()
        if (GPS){
            precio += 5
        }
        Text(
            stringResource(R.string.dias_de_alquiler),
            fontSize = 20.sp,
            modifier = modifier.padding(top = 20.dp))
        TextField(
            value = diasAlquiler,
            onValueChange = {input ->
                val digits = input.filter { it.isDigit() }
                diasAlquiler = digits
            },
            label = { Text(text = stringResource(R.string.dias_de_alquiler))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        if (diasAlquiler.isNotEmpty()){
            precio *= diasAlquiler.toInt()
        }
        Row(modifier = modifier.padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                stringResource(R.string.precio_total),
                fontSize = 20.sp,
                modifier = modifier)
            Text(text = precio.toString() + " €",
                fontSize = 20.sp)
        }

        Row(modifier = Modifier.padding(top = 20.dp)) {
            //Manda a la actividad ResumenPedido
            Button(onClick = {
                if(diasAlquiler.isNotEmpty()){
                    pedido = Pedido(vehiculo, usuario, null, GPS, diasAlquiler.toInt(), precio)
                    onAceptarPulsado(pedido)
                } },
                modifier = modifier) {
                Text(stringResource(R.string.aceptar),
                    fontSize = 20.sp)
            }
            //Manda a la pantalla de inicio de la aplicacion
            /*Button(onClick = {},
                modifier = Modifier.padding(start = 20.dp)) {
                Text(stringResource(R.string.cancelar),
                    fontSize = 20.sp)
            }*/
        }
    }
}

@Composable
fun pintarCombustible(modifier: Modifier = Modifier): Int{
    val radioOptions = listOf(R.string.di_sel, R.string.gasolina, R.string.el_ctrico)

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    Row(modifier = modifier) {
        radioOptions.forEach { text ->
            Row(modifier = modifier
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    role = Role.RadioButton
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = {onOptionSelected(text)}

                )
                Text(
                    text = stringResource(text)
                )
            }
        }
    }
    return selectedOption
}
@Composable
fun pintarCilindrada(modifier: Modifier = Modifier): Int{
    val radioOptions = listOf(R.string._50cc, R.string._125cc, R.string._250cc)

    val (selectedOption, onOptionSelected) = remember { mutableIntStateOf(radioOptions[0]) }
    Row(modifier = modifier) {
        radioOptions.forEach { text ->
            Row(modifier = modifier
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    role = Role.RadioButton
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = {onOptionSelected(text)}

                )
                Text(
                    text = stringResource(text)
                )
            }
        }
    }
    return selectedOption
}

@Composable
fun pintarGPS(): Boolean{

    var cheched by remember { mutableStateOf(false)}

    Row(modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically) {
        Text(stringResource(R.string.gps))
        Checkbox(
            checked = cheched,
            onCheckedChange = {cheched = it}
        )
    }
    if (cheched){
        return true
    }else{
        return false
    }
}