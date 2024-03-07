package com.example.dotify_kotlin.features.core.presentation.main_tab.library.components

import CustomAsyncImage
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlaylistItem(
    onItemClick : () ->Unit,
    imageUrl:String?  = "",
    name:String? = "",
    createdBy:String? ="",
){
    Row(
        Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable{
                onItemClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomAsyncImage (Modifier.size(62.dp), model = imageUrl, contentDescription = name)

        Column(
            Modifier.padding(start = 8.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = name ?: "",
                color = Color.White
            )
            Text(
                text = createdBy ?:"",
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 12.sp
                ),

                )
        }
    }
}