package com.example.nypopulararticle.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nypopulararticle.utils.*

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = ARTICLE_SCREEN_DIS
    ) {
        composable(
            route = ARTICLE_SCREEN_DIS
        ) {
            ArticlesScreenDis(navController = navController)
        }
        composable(
            route = ARTICLE_DETAILS_SCREEN_DIS.plus("?$ARTICLE_DETAILS_OBJECT={${ARTICLE_DETAILS_OBJECT}}")
        ,arguments = listOf(navArgument(name = ARTICLE_DETAILS_OBJECT) {
                type = NavType.StringType
            })) {
            ArticlesDetailsScreenDis(
                navController = navController)
        }
    }
}