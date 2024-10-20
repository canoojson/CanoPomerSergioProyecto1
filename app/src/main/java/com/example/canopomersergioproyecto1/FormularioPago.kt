package com.example.canopomersergioproyecto1

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.canopomersergioproyecto1.mascara.CreditCardVisualTransformation
import com.example.canopomersergioproyecto1.mascara.ExpiryDateVisualTransformation

@Composable
fun FormularioPago(navController: NavController, modifier: Modifier = Modifier){

    val radioOptions = listOf("VISA", "MASTERCARD", "EURO6000")

    var numeroTarjeta by remember { mutableStateOf("") }

    var fechaCaducidad by remember { mutableStateOf("") }

    var cvc by remember { mutableStateOf("") }

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(R.string.formulario_de_pago),
            modifier = Modifier.padding(16.dp),
            fontSize = 30.sp)
        Image(painter = painterResource(id=R.drawable.metodosdepago),
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
                numeroTarjeta = digits
            },
            label = { Text(text = stringResource(R.string.numero_de_tarjeta))},
            placeholder = { Text(text = "1234 5678 9012 3456")},
            visualTransformation = CreditCardVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = fechaCaducidad,
                onValueChange = { input ->
                    // Filtrar solo los dígitos y limitar a 4 caracteres
                    val digits = input.filter { it.isDigit() }.take(4)

                    // Validar que el mes esté en el rango 01-12
                    if (digits.length <= 2) {
                        fechaCaducidad = digits // Permitir hasta 2 dígitos
                    } else if (digits.length == 3) {
                        // Permitir escribir 3 dígitos, pero no se actualiza hasta que haya 4 dígitos
                        fechaCaducidad = digits
                    } else {
                        val month = digits.substring(0, 2).toIntOrNull()
                        if (month != null && month in 1..12) {
                            fechaCaducidad = digits // Actualizar solo si el mes es válido
                        }
                    }
                },
                label = { Text(text = stringResource(R.string.fecha_de_caducidad))},
                placeholder = { Text(text = "MM/AA")},
                visualTransformation = ExpiryDateVisualTransformation(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.padding(20.dp)
            )
            OutlinedTextField(
                value = cvc,
                onValueChange = { input ->
                    val digits = input.filter { it.isDigit() }.take(3)
                    cvc = digits
                },
                label = { Text(text = "CVC")},
                placeholder = { Text(text = "123")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Row(modifier = Modifier.padding( bottom = 20.dp),
            verticalAlignment = Alignment.Bottom) {
            Button(onClick = {navController.navigate("resumenPago")},
                modifier = Modifier.padding(end = 32.dp)) {
                Text(stringResource(R.string.aceptar),
                    fontSize = 20.sp)
            }
            Button(onClick = {navController.navigate("pantallaInicio")}) {
                Text(stringResource(R.string.cancelar),
                    fontSize = 20.sp)
            }
        }
    }
}