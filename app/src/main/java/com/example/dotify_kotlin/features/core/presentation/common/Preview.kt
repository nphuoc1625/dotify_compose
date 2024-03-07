package com.example.dotify_kotlin.features.core.presentation.common

import androidx.compose.runtime.Composable
import com.example.dotify_kotlin.theme.Dotify_kotlinTheme

@Composable
fun DefaultPreview(
    content: @Composable () -> Unit
){
    Dotify_kotlinTheme(
        darkTheme = true, dynamicColor = false
    ) {
        content()
    }
}