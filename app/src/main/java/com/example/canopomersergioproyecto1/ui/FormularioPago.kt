package com.example.canopomersergioproyecto1.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canopomersergioproyecto1.R
import com.example.canopomersergioproyecto1.mascara.CreditCardVisualTransformation
import com.example.canopomersergioproyecto1.mascara.ExpiryDateVisualTransformation
import com.example.canopomersergioproyecto1.modelo.AppUIState
import com.example.canopomersergioproyecto1.modelo.DatosPago
import com.example.canopomersergioproyecto1.modelo.Pedido

@Composable
fun FormularioPago(appUIState: AppUIState, onAceptarPulsado: (Pedido) -> Unit, modifier: Modifier = Modifier){

    var datosPago : DatosPago

    var errorfecha by remember { mutableStateOf(false) }

    var errorCVC by remember { mutableStateOf(false) }

    var errorNumTarjeta by remember { mutableStateOf(false) }

    val contexto = LocalContext.current

    val pedido : Pedido? = appUIState.pedido

    val radioOptions = listOf("VISA", "MASTERCARD", "EURO6000")

    var numeroTarjeta by remember { mutableStateOf("") }

    var fechaCaducidad by remember { mutableStateOf("") }

    var cvc by remember { mutableStateOf("") }

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(R.string.formulario_de_pago),
            modifier = Modifier.padding(16.dp),
            fontSize = 30.sp)
        Image(painter = painterResource(id= R.drawable.metodosdepago),
            contentDescription = stringResource(R.string.metodos_de_pago)
        )
        Row {
            radioOptions.forEach { text ->
                Row(modifier = Modifier.selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    role = Role.RadioButton
                ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {onOptionSelected(text)}
                    )
                    Text(
                        text = text
                    )

                }
            }
        }
        Text("Numero de tarjeta",
            modifier = Modifier.padding(16.dp),
            fontSize = 25.sp)
        OutlinedTextField(
            value = numeroTarjeta,
            onValueChange = {input ->
                val digits = input.filter { it.isDigit() }.take(16)
                if (digits.length == 16) {
                    errorNumTarjeta = false
                }else{
                    errorNumTarjeta = true
                }
                numeroTarjeta = digits
            },
            label = { Text(text = stringResource(R.string.numero_de_tarjeta))},
            placeholder = { Text(text = "1234 5678 9012 3456")},
            visualTransformation = CreditCardVisualTransformation(),
            singleLine = true,
            isError = errorNumTarjeta,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = fechaCaducidad,
                onValueChange = { input ->
                    // Filtrar solo los dígitos y limitar a 4 caracteres
                    val digits = input.filter { it.isDigit() }.take(4)

                    if (digits.length <= 2) {
                        // Mientras se escribe el mes (primeros 2 dígitos)
                        val mes = digits.toIntOrNull()
                        if (mes != null && mes in 1..12) {
                            errorfecha = false
                        } else {
                            errorfecha = true
                        }
                        fechaCaducidad = digits
                    } else {
                        // Cuando ya se tienen al menos 4 dígitos (MMYY)
                        val mes = digits.substring(0, 2).toIntOrNull()
                        val anio = digits.substring(2).toIntOrNull()

                        if (mes != null && anio != null && mes in 1..12) {
                            errorfecha = false
                        } else {
                            errorfecha = true
                        }
                        fechaCaducidad = digits
                    }
                },
                label = { Text(text = stringResource(R.string.fecha_de_caducidad)) },
                placeholder = { Text(text = "MM/AA") },
                visualTransformation = ExpiryDateVisualTransformation(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = errorfecha,
                modifier = Modifier.padding(20.dp)
            )
            OutlinedTextField(
                value = cvc,
                onValueChange = { input ->
                    val digits = input.filter { it.isDigit() }.take(3)
                    if (digits.length == 3) {
                        errorCVC = false
                    } else {
                        errorCVC = true
                    }
                    cvc = digits
                },
                label = { Text(text = "CVC")},
                placeholder = { Text(text = "123")},
                singleLine = true,
                isError = errorCVC,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            datosPago = DatosPago(selectedOption,numeroTarjeta, fechaCaducidad, cvc)
            pedido?.datosPago = datosPago
        }

        Row(modifier = Modifier.padding( bottom = 20.dp),
            verticalAlignment = Alignment.Bottom) {

            Button(onClick =
            {
                if (!errorfecha && !errorCVC && !errorNumTarjeta && numeroTarjeta!="" && fechaCaducidad!="" && cvc!="" && numeroTarjeta.length==16 && fechaCaducidad.length==4 && cvc.length==3){
                    onAceptarPulsado(pedido!!)
                }else{
                    Toast.makeText(contexto, "Datos incorrectos o no introducidos ", Toast.LENGTH_SHORT).show()
                    if(numeroTarjeta!=""){
                        errorNumTarjeta=true
                    }
                    if(fechaCaducidad!=""){
                        errorfecha=true
                    }
                    if(cvc!=""){
                        errorCVC=true
                    }
                }
            },
                modifier = Modifier.padding(end = 32.dp)) {
                Text(stringResource(R.string.aceptar),
                    fontSize = 20.sp)
            }
            /*Button(onClick = {}) {
                Text(stringResource(R.string.cancelar),
                    fontSize = 20.sp)
            }*/
        }
    }
}