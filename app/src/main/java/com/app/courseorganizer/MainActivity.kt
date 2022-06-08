package com.app.courseorganizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.courseorganizer.presentation.course_summary.AllCoursesScreen
import com.app.courseorganizer.presentation.util.Screens
import com.app.courseorganizer.ui.theme.CourseOrganizerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseOrganizerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screens.ALL_COURSES){

                        composable(route = Screens.ALL_COURSES){
                            AllCoursesScreen()
                        }

                        composable(route = Screens.ALL_USERS){

                        }
                    }
                }
            }
        }
    }
}