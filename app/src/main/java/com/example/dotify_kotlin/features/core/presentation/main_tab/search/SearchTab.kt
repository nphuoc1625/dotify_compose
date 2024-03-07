package com.example.dotify_kotlin.features.core.presentation.main_tab.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchTab(){
    Box(
        Modifier.background(Color.White).fillMaxSize(),
        contentAlignment = Alignment.Center, ) {
        Text(text = "SearchTab")
    }
}

@Composable
@Preview
fun SearchTabPreview(){
    SearchTab()
}