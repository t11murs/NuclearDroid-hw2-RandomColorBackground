package com.example.nucleardroid_hw2_randomcolorbackground.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun ColorScreen() {
    var bg by remember { mutableStateOf(Color.White) }
    val hex = remember(bg) { bg.toHex() }
    val content = if (bg.isDark()) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = hex,
            onValueChange = {},
            readOnly = true,
            label = { Text("HEX", color = content) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(color = content)
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { bg = randomColor() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Случайный цвет")
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { bg = Color.White },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сброс цвета")
        }
    }
}

private fun randomColor(random: Random = Random.Default): Color {
    val r = random.nextInt(256)
    val g = random.nextInt(256)
    val b = random.nextInt(256)
    return Color(r / 255f, g / 255f, b / 255f)
}

private fun Color.toHex(): String {
    fun ch(c: Float): String =
        ((c * 255).roundToInt())
            .coerceIn(0, 255)
            .toString(16)
            .uppercase()
            .padStart(2, '0')
    return ("#${ch(this.red)}${ch(this.green)}${ch(this.blue)}")
}

private fun Color.isDark(): Boolean = this.luminance() < 0.5f