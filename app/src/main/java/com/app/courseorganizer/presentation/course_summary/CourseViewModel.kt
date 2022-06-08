package com.app.courseorganizer.presentation.course_summary

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.courseorganizer.domain.models.Course
import com.app.courseorganizer.domain.repository.CourseOrganizerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(private val repository: CourseOrganizerRepository): ViewModel() {

    init {
        getAllCourses()
    }

    private var _courses = emptyList<Course>().toMutableStateList()
    val courses : List<Course> = _courses

    private fun getAllCourses(){
        /*viewModelScope.launch {
            repository.insertMultipleCourses(
                listOf(
                    Course(
                        title = "Speaking 101",
                        courseCode = "S101",
                        notes = "This is a course for speaking"
                    ),
                    Course(
                        title = "Listening 301",
                        courseCode = "L301",
                        notes = "This is a course for listening"
                    ),
                    Course(
                        title = "Writing 221",
                        courseCode = "W221",
                        notes = "This is a course for writing"
                    )
                )
            )
        }*/
        repository.getAllCourses().onEach {
            _courses.addAll(it)
        }.launchIn(viewModelScope)
    }
}