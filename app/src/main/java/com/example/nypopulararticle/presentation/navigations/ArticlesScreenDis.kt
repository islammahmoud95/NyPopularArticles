package com.example.nypopulararticle.presentation.navigations

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nypopulararticle.presentation.features.articales.ArticlesViewModel
import com.example.nypopulararticle.presentation.features.articales.ArticlesScreen
import com.example.nypopulararticle.utils.ARTICLE_DETAILS_OBJECT
import com.example.nypopulararticle.utils.ARTICLE_DETAILS_SCREEN_DIS
import com.google.gson.Gson

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/

@Composable
fun ArticlesScreenDis(navController: NavController) {
    val viewModel = hiltViewModel<ArticlesViewModel>()
    ArticlesScreen(viewModel) {
        val articleDetails = Uri.encode(Gson().toJson(it))
        navController.navigate(
            ARTICLE_DETAILS_SCREEN_DIS.plus("?$ARTICLE_DETAILS_OBJECT=${articleDetails}"))
    }
}