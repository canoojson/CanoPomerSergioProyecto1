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
private val PurplePrimary = Color(0xFF6200EE)        // Color principal (morado)
private val WhiteText = Color(0xFFFFFFFF)            // Texto blanco
private val ErrorRed = Color(0xFFB00020)             // Rojo para errores
private val BackgroundBlack = Color(0xFF000000)      // Fondo negro

// Esquema de colores para el tema oscuro
private val DarkColorScheme = darkColorScheme(
    primary = PurplePrimary,            // Color principal (botones, títulos)
    onPrimary = WhiteText,              // Texto sobre el color principal
    background = BackgroundBlack,       // Fondo de la aplicación
    surface = BackgroundBlack,          // Superficie de componentes
    onBackground = WhiteText,           // Texto sobre el fondo
    onSurface = WhiteText,              // Texto sobre superficies
    error = ErrorRed,                   // Color para errores
    onError = WhiteText                 // Texto sobre errores
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