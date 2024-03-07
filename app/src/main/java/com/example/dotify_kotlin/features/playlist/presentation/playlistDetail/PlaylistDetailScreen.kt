package com.example.dotify_kotlin.features.playlist.presentation.playlistDetail
import CustomAsyncImage
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotify_kotlin.R
import com.example.dotify_kotlin.features.core.presentation.common.DefaultPreview

data class PlaylistDetailScreenArg(
    val playlistId :String,
)

@Composable
fun PlaylistDetailScreen(
    args : PlaylistDetailScreenArg
){

    BuildUI()
}

@Composable
private fun BuildUI(){
    val scrollState = rememberScrollState()
    Scaffold(
        content = {
            Box {
                Box(
                    Modifier
                        .padding(it)
                        .verticalScroll(scrollState)
                ) {

                    Column(
                        Modifier
                            .background(
                                Brush.verticalGradient(
                                    0f to darkColorScheme().secondaryContainer,
                                    0.2f to darkColorScheme().surface,
                                )
                            )
                            .padding(top = 60.dp)
                            .fillMaxSize(),
                    ) {


                        SearchBox(
                            onTap = {},
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Box(
                            Modifier
                                .padding(vertical = 16.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            CustomAsyncImage(
                                modifier = Modifier.size(250.dp),
                                model = "https://i.scdn.co/image/ab67616d00001e024a5c0d176134cb5ab9db4924",
                                contentDescription = ""
                            )
                        }
                        Text(
                            text = "Qua Khung Cửa Sổ",
                            Modifier
                                .padding(start = 16.dp),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            Modifier.padding(start = 16.dp, top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            CustomAsyncImage(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .size(16.dp),
                                model = "https://i.scdn.co/image/ab67616d00001e024a5c0d176134cb5ab9db4924",
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "Chillies", style = MaterialTheme.typography.labelSmall)
                        }
                        Row(
                            Modifier.padding(start = 16.dp, top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            CompositionLocalProvider(
                                LocalContentColor provides Color.Gray,
                                ) {
                                Text(text = "Album", style = MaterialTheme.typography.labelSmall)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = "·")
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = "2021", style = MaterialTheme.typography.labelSmall)
                            }

                        }
                        Row(
                            Modifier.padding(start= 16.dp, top = 8.dp)
                            , verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                Modifier
                                    .size(26.dp, 36.dp)
                                    .border(2.dp, Color.Gray, RoundedCornerShape(CornerSize(8.dp)))
                                    .padding(4.dp)
                            ) {
                                CustomAsyncImage(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .fillMaxSize(),
                                    model = "https://i.scdn.co/image/ab67616d00001e024a5c0d176134cb5ab9db4924",
                                    contentDescription = ""
                                )
                            }
                            Spacer(Modifier.width(18.dp))
                            CircleBorderedIcon(
                                onTap = {}
                                ,Icons.Outlined.Add
                            )
                            Spacer(Modifier.width(18.dp))
                            CircleBorderedIcon(
                                onTap = {}
                                ,Icons.Outlined.ArrowForward,
                                rotate = 90f
                            )
                            Spacer(Modifier.width(18.dp))
                            Box(
                                Modifier
                                    .size(18.dp)
                            ){
                                Icon(
                                    Icons.Outlined.MoreVert,"",
                                )
                            }

                            Spacer(modifier = Modifier.weight(1f))
                            Icon(Icons.Outlined.Add,"")
                            Icon(Icons.Outlined.Add,"")
                        }
                        Box(
                            Modifier.size(100.dp, 2000.dp)
                        ) {

                        }
                    }
                }
                Header(scrollState = scrollState,
                    "Qua khung cửa sổ")
            }
        }
    )
}
@Composable
private fun CircleBorderedIcon(
    onTap: () -> Unit,
    imageVector: ImageVector,
    rotate: Float = 0f

){
    Box(
        Modifier
            .size(18.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(CornerSize(9.dp)))
            .clickable {onTap()}
    ){
        Icon(
            imageVector,"",
            tint = Color.Gray,
                    modifier =   Modifier.rotate(rotate),

        )
    }
}
@Composable
fun calculateAlpha(
    offset: Dp = 0.dp,
     range: Dp,
    currentIndex: Int = 0
): Float{
    val alphaOffset = with(LocalDensity.current) { offset.toPx() }
    val changeRange =  with(LocalDensity.current) { range.toPx() }
    val alpha = (currentIndex - alphaOffset) / changeRange
return alpha.coerceIn(0f, 1f)
}

@Composable
private fun Header(
    scrollState: ScrollState,
    title: String
){
    val alpha =calculateAlpha(
        offset =  282.dp,
        range = 100.dp,
        currentIndex = scrollState.value)
    Box(
        Modifier
            .height(60.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {

        Box(
            Modifier
                .fillMaxSize()
                .alpha(alpha)
                .background(
                    brush = Brush.verticalGradient(
                        0f to darkColorScheme().onSecondary,
                        0.5f to darkColorScheme().onSecondary,
                    ),
                )
                .padding(start = (24 + 40).dp),
            contentAlignment = Alignment.CenterStart,
        ) {
            Text(
                text = title,
                color = darkColorScheme().onSecondaryContainer
            )
        }
        IconButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                Icons.Outlined.ArrowBack,
                tint = darkColorScheme().onSecondaryContainer,
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview
private fun PreviewUi(){
   DefaultPreview {
       BuildUI()
   }
}

@Composable
private fun  SearchBox(
    modifier: Modifier,
    onTap : () -> Unit,
){

    Box(
        modifier
            .height(40.dp)
            .background(darkColorScheme().secondaryContainer, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onTap)
            .padding(8.dp)
            ,
        contentAlignment = Alignment.CenterStart) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Outlined.Search, null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.find_in_album),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = darkColorScheme().onSecondaryContainer
            )
        }
    }
}
