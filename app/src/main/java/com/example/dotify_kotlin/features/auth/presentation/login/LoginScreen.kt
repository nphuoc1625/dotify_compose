import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dotify_kotlin.routes.Routes
import com.example.dotify_kotlin.theme.Dotify_kotlinTheme
import com.example.dotify_kotlin.features.auth.presentation.AuthViewModel
import kotlinx.coroutines.launch

import org.koin.compose.koinInject

@Composable
fun LoginScreen(
    navController: NavController
) {
    val authViewModel: AuthViewModel = koinInject<AuthViewModel>()
    val context : Activity =  LocalContext.current as Activity

    val snackBarHostState = remember {SnackbarHostState()}
    val coroutineScope = rememberCoroutineScope()

    authViewModel.setOnAuthCompleteListener {
        when (it){
            it ->{
                navController.navigate(Routes.MainScreen.name)
            }
           else -> coroutineScope.launch {
                snackBarHostState.showSnackbar(
                    "Login Failed",
                    duration = SnackbarDuration.Short
                )
            }
        }
    }

    Build(
        snackBarHostState= snackBarHostState ,
        onLogin = {
            authViewModel.loginFromWeb(context)
        }
    )

}

@Composable
private fun Build(
    snackBarHostState: SnackbarHostState,
    onLogin: () ->  Unit
){
    Scaffold(
        containerColor = darkColorScheme().surface,
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        }
    ) {
        Box (
            Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center,
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box (
                    Modifier.weight(1f)
                     ,
                    contentAlignment = Alignment.Center,
                ){
                    Text(text = "Login"
                    , style = TextStyle(
                        fontSize = 28.sp
                    )
                    )
                }
                Box(
                    Modifier.weight(1f),
                ) {
                    Button(
                        border = BorderStroke(1.dp,color= Color.LightGray),
                        onClick = onLogin) {
                        Text(text = "Login With Spotify")
                    }
                }
//                Button(onClick = {
//                    authViewModel.loginFromActivity(context)
//                }) {
//                    Text(text = "Login With Spotify from Activity")
//                }
            }
        }

    }
}
@Composable
@Preview
fun LoginScreenPreview(){
    Dotify_kotlinTheme (darkTheme = true, dynamicColor = false){
        Build(
            snackBarHostState = SnackbarHostState(),
            onLogin = {}
        )
    }
}
