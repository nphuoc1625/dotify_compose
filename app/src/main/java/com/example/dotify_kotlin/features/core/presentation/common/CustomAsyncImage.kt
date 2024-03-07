
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.SubcomposeAsyncImage

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    model: Any?,
    contentDescription : String?
){


    SubcomposeAsyncImage(
        modifier = modifier,
        model = model,
        loading = {
            Box(
                Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {
                CircularProgressIndicator()
            }
        },
        error = {
            Box(
                Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null,
                    modifier = modifier
                )
            }
        },
        contentDescription = contentDescription,
    )

}