package com.example.canopomersergioproyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.ui.theme.CanoPomerSergioProyecto1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanoPomerSergioProyecto1Theme {
                Scaffold(/*
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = Color.DarkGray,
                                titleContentColor = Color.White
                            ),
                            title = {
                                Text("")
                            },
                            actions = {
                                IconButton(onClick = {/*TODO*/}) {
                                    Text("Lorem Ipsum")
                                    Icon(
                                        imageVector = R.drawable.fotoperfil

                                    )
                                }
                            }
                            
                        )
                    }*/
                ) { innerPadding ->
                    RealizarPedido(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaInicio(modifier: Modifier = Modifier) {
Column(modifier = Modifier
    .fillMaxSize()
    .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id=Datos().obtenerUsuario().fotoPerfil),
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
    //Manda a la actividad RealizarPedido
        Button(onClick = {/*TODO*/}) {
            Text(stringResource(R.string.realizar_pedido))
        }
    //Manda a la actividad ListarPedidos
        Button(onClick = {/*TODO*/}) {
            Text(stringResource(R.string.listar_pedidos))
        }
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CanoPomerSergioProyecto1Theme {
        RealizarPedido()
    }
}