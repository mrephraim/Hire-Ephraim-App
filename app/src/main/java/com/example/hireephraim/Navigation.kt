package com.example.hireephraim

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object MainActivityNavigation {
    const val frontPage = "front"
    const val homePage = "home_page"
}

object CalculatorNavigation{
    const val Home = "calculator_home"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainActivityNavigation.frontPage){
        composable(route = MainActivityNavigation.frontPage){
            Front(navController = navController)
        }
        composable(route = MainActivityNavigation.homePage){
            Home(navController = navController)
        }
        composable(route = CalculatorNavigation.Home){
            CalculatorMain()
        }
    }
}

@Composable
fun CalculatorNavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = CalculatorNavigation.Home){
        composable(route = CalculatorNavigation.Home){
            CalculatorMain()
        }
    }
}