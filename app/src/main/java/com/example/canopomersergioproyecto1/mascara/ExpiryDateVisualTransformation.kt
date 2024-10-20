package com.example.canopomersergioproyecto1.mascara

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.OffsetMapping

class ExpiryDateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        // Crear el texto formateado
        val input = text.text.replace(Regex("[^\\d]"), "")
        val formatted = buildString {
            for (i in input.indices) {
                if (i == 2) append('/') // Añadir la barra después de dos dígitos
                append(input[i])
            }
        }

        // Crear el OffsetMapping para ajustar la posición del cursor
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                // Mover el cursor después de la barra
                return if (offset > 2) offset + 1 else offset
            }

            override fun transformedToOriginal(offset: Int): Int {
                // Ajustar la posición del cursor antes de la barra
                return if (offset > 2) offset - 1 else offset
            }
        }

        // Retornar el texto transformado
        return TransformedText(AnnotatedString(formatted), offsetMapping)
    }
}