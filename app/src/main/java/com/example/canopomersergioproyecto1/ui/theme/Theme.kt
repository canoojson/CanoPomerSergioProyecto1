package com.example.canopomersergioproyecto1.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Definición de colores personalizados
private val DarkBackground = Color(0xFF000000) // Fondo negro
private val WhiteText = Color(0xFFFFFFFF)      // Texto blanco
private val SoftRed = Color(0xFFD32F2F)        // Botones rojos no muy fuertes
private val ButtonText = Color(0xFFFFFFFF)    // Texto de botón blanco

// Esquema de colores para el tema oscuro
private val DarkColorScheme = darkColorScheme(
    primary = SoftRed,            // Color principal (botones)
    onPrimary = ButtonText,       // Texto sobre el color principal
    background = DarkBackground,  // Fondo de la aplicación
    surface = DarkBackground,     // Superficie de componentes
    onBackground = WhiteText,     // Texto sobre el fondo
    onSurface = WhiteText         // Texto sobre superficies
)

// Tipografía personalizada
private val CustomTypography = Typography(
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = WhiteText
    ),
    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = WhiteText
    )
)

// Formas personalizadas (opcional)
private val CustomShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp)
)

// Función de tema personalizado
@Composable
fun CanoPomerSergioProyecto1Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = CustomTypography,
        shapes = CustomShapes,
        content = content
    )
}