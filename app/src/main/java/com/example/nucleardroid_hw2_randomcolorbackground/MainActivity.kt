package com.example.nucleardroid_hw2_randomcolorbackground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.nucleardroid_hw2_randomcolorbackground.ui.screens.ColorScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme{ColorScreen()} }
    }
}

