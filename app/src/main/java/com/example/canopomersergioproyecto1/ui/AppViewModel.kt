package com.example.canopomersergioproyecto1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.canopomersergioproyecto1.modelo.AppUIState
import com.example.canopomersergioproyecto1.modelo.Pedido
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {
    private val _appUIState = MutableStateFlow(AppUIState())
    val appUIState: StateFlow<AppUIState> = _appUIState.asStateFlow()

    var pedido by mutableStateOf(Pedido(vehiculo = null, usuario = null, datosPago = null, Gps = false, tiempoAlquiler = 0, precio = 0))
        private set



    fun actualizarPedido(p: Pedido) {
        pedido = p
        _appUIState.update { estadoActual ->
            estadoActual.copy(pedido = pedido)
        }
    }
    fun agregarPedido(pedido: Pedido){
        _appUIState.update { estadoActual ->
            estadoActual.copy(pedidos = estadoActual.pedidos.plus(pedido))
        }
    }
}