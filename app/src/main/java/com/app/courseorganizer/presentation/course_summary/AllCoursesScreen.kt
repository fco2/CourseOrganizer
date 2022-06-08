package com.app.courseorganizer.presentation.course_summary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AllCoursesScreen(
    modifier: Modifier = Modifier,
    viewModel: CourseViewModel = hiltViewModel()
){
    Box(modifier = modifier
        .fillMaxSize()
        .padding(10.dp)){

        LazyColumn {
            items(viewModel.courses){ course ->
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = course.title)
                    Text(text = course.courseCode)
                    Text(text = course.notes!!)
                }
            }
        }
    }
}