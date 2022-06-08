package com.app.courseorganizer.presentation.course_summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 10.dp,
                    modifier = modifier.padding(5.dp),
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(Color.Transparent),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text = course.title, fontSize = 14.sp)
                        Text(text = course.courseCode, fontSize = 14.sp)
                        Text(text = course.notes!!, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}