package com.example.dotify_kotlin

import LoginScreen
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dotify_kotlin.features.auth.presentation.AuthViewModel
import com.example.dotify_kotlin.features.core.presentation.MainScreen
import com.example.dotify_kotlin.features.core.presentation.pre_loading.PreLoadingScreen
import com.example.dotify_kotlin.routes.Routes
import com.example.dotify_kotlin.theme.Dotify_kotlinTheme
import org.koin.android.ext.android.inject
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    private val authViewModel = inject<AuthViewModel>().value

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = intent?.data;
        if (uri != null) {
            print("custom $uri")
            authViewModel.handleResultFromWeb(uri)
        }
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        authViewModel.handleResultFromActivity(resultCode,data)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }



}

@Composable
fun MyApp()  {
    KoinContext {
        Dotify_kotlinTheme(darkTheme = true,dynamicColor = false) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.PreLoadingScreen.name) {
                composable(Routes.PreLoadingScreen.name) { PreLoadingScreen(navController) }
                composable(Routes.LoginScreen.name) { LoginScreen(navController) }
                composable(Routes.MainScreen.name) { MainScreen( navController) }
                // Add more destinations similarly.
            }
        }
    }

}






