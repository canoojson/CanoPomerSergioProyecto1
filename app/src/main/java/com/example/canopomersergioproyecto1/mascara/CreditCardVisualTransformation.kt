package com.example.canopomersergioproyecto1.mascara

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        // Separamos el texto en bloques de 4 caracteres
        val trimmed = text.text.take(16)
        val formatted = buildString {
            for (i in trimmed.indices) {
                append(trimmed[i])
                if ((i + 1) % 4 == 0 && i != trimmed.lastIndex) {
                    append(" ")
                }
            }
        }

        val offsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return if (offset <= 4) offset
                else if (offset <= 8) offset + 1
                else if (offset <= 12) offset + 2
                else offset + 3
            }

            override fun transformedToOriginal(offset: Int): Int {
                return if (offset <= 4) offset
                else if (offset <= 9) offset - 1
                else if (offset <= 14) offset - 2
                else offset - 3
            }
        }

        return TransformedText(AnnotatedString(formatted), offsetTranslator)
    }

}