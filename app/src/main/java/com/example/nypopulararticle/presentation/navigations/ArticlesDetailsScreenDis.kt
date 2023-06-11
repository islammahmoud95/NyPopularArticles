package com.example.nypopulararticle.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nypopulararticle.presentation.features.articledetails.ArticlesDetailsScreen
import com.example.nypopulararticle.presentation.features.articledetails.ArticlesDetailsViewModel

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/

@Composable
fun ArticlesDetailsScreenDis(
    navController: NavController,
) {
    val viewModel = hiltViewModel<ArticlesDetailsViewModel>()
    ArticlesDetailsScreen(viewModel){
        navController.popBackStack()
    }
}