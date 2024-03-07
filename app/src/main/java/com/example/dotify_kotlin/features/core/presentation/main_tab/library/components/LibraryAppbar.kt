package com.example.dotify_kotlin.features.core.presentation.main_tab.library.components

import CustomAsyncImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotify_kotlin.R
import com.example.dotify_kotlin.features.core.presentation.common.DefaultPreview

@Composable
fun LibraryAppbar(
    imageUrl:String,
    onSearchTap : () -> Unit,
    onAddTap :()-> Unit,
) {
    Surface(
        Modifier
            .fillMaxWidth()
            .shadow(4.dp),
        color = darkColorScheme().surface,
    ) {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 28.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomAsyncImage(
                    Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    model ="",
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.library),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = darkColorScheme().onSurface)
                IconButton(
                    onClick = onSearchTap) {
                    Icon(imageVector = Icons.Outlined.Search, contentDescription = "search")
                }
                IconButton(onClick = onAddTap) {
                    Icon(imageVector = Icons.Outlined.Add, contentDescription = "add")
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewUI(){
    DefaultPreview{
        LibraryAppbar(imageUrl = "",
            onSearchTap = { /*TODO*/ },
            onAddTap = {})
    }
}