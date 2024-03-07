package com.example.dotify_kotlin.features.core.presentation.pre_loading

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.dotify_kotlin.routes.Routes
import com.example.dotify_kotlin.features.auth.presentation.AuthViewModel
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import org.koin.compose.rememberKoinInject

@Composable
fun PreLoadingScreen(navController: NavController){
    val authViewModel = rememberKoinInject<AuthViewModel>()
    val context =   LocalContext.current as Activity

    LaunchedEffect(authViewModel) {
        authViewModel.checkCurrentUser(
            context,
        )
        authViewModel.setOnAuthCompleteListener {
            if (authViewModel.currentToken.value != null) {
                navController.navigate(Routes.MainScreen.name)
            } else {
                navController.navigate(Routes.LoginScreen.name)
            }
        }
    }

    Box (
        Modifier
            .background(Color.Black)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            color = Color.Green
        )
    }
}