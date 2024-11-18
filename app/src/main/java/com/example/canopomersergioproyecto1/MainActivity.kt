package com.example.canopomersergioproyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.canopomersergioproyecto1.datos.Datos
import com.example.canopomersergioproyecto1.ui.AlquilerVehiculosApp
import com.example.canopomersergioproyecto1.ui.FormularioPago
import com.example.canopomersergioproyecto1.ui.ListarPedidos
import com.example.canopomersergioproyecto1.ui.RealizarPedido
import com.example.canopomersergioproyecto1.ui.ResumenPago
import com.example.canopomersergioproyecto1.ui.ResumenPedido
import com.example.canopomersergioproyecto1.ui.theme.CanoPomerSergioProyecto1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanoPomerSergioProyecto1Theme {
                    AlquilerVehiculosApp()
                }
            }
        }
    }

