package com.example.canopomersergioproyecto1.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.canopomersergioproyecto1.R

enum class Pantallas(@StringRes val titulo: Int){
    PantallaInicio(titulo = R.string.inicio),
    ListarPedidos(titulo = R.string.listar_pedidos),
    RealizarPedido(titulo = R.string.realizar_pedido),
    ResumenPedido(titulo = R.string.resumen_del_pedido),
    FormularioPago(titulo = R.string.formulario_de_pago),
    ResumenPago(titulo = R.string.resumen_de_pago),
}

@Composable
fun AlquilerVehiculosApp(
    viewModel: AppViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.PantallaInicio.name
    )

    Scaffold(
        topBar = {
            AppTopBar(
                pantallaActual = pantallaActual,
                puedeNavegarAtras = navController.previousBackStackEntry != null,
                onNavegarAtras = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        val uiState by viewModel.appUIState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Pantallas.PantallaInicio.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Pantallas.PantallaInicio.name){
                PantallaInicio(
                    onRealizarPedidoPulsado = {
                        navController.navigate(Pantallas.RealizarPedido.name)
                    },
                    onListarPedidosPulsado = {
                        navController.navigate(Pantallas.ListarPedidos.name)
                    }
                )
            }
            composable(route= Pantallas.ListarPedidos.name){
                ListarPedidos(appUIState = uiState)
            }
            composable(route = Pantallas.RealizarPedido.name){
                RealizarPedido(
                    onAceptarPulsado = {
                        viewModel.actualizarPedido(it)
                        navController.navigate(Pantallas.ResumenPedido.name)
                    }
                )
            }
            composable(route = Pantallas.ResumenPedido.name){
                ResumenPedido(
                    appUIState = uiState,
                    onAceptarPulsado = {
                        navController.navigate(Pantallas.FormularioPago.name)
                    }
                )
            }
            composable(route = Pantallas.FormularioPago.name){
                FormularioPago(
                    appUIState = uiState,
                    onAceptarPulsado = {
                        viewModel.actualizarPedido(it)
                        navController.navigate(Pantallas.ResumenPago.name)
                    }
                )
            }
            composable(route = Pantallas.ResumenPago.name) {
                ResumenPago(
                    appUIState = uiState,
                    onAceptarPulsado = {
                        viewModel.agregarPedido(it)
                        navController.popBackStack(Pantallas.PantallaInicio.name, inclusive = false)
                    },
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    pantallaActual: Pantallas,
    puedeNavegarAtras: Boolean,
    onNavegarAtras: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(pantallaActual.titulo)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (puedeNavegarAtras) {
                IconButton(onClick = onNavegarAtras) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.atras)
                    )
                }
            }
        },
        modifier = modifier
    )
}

