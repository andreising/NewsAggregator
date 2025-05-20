package com.example.newsaggregator.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.newsaggregator.data.rss.api.RssFeedApi
import com.example.newsaggregator.presentation.navigation.AppNavigation
import com.example.newsaggregator.presentation.navigation.Screen
import com.example.newsaggregator.presentation.ui.screens.MainScreen
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import retrofit2.Retrofit

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.theguardian.com")
    .addConverterFactory(
        XML.asConverterFactory(
            MediaType.get("application/xml; charset=UTF8")
        )
    ).build()

private val guardian = retrofit.create(RssFeedApi::class.java)


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            AppNavigation(
                navHostController = navHostController,
                startDestination = Screen.MainScreen.route,
                mainScreen = { MainScreen() }
            )
        }
    }
}