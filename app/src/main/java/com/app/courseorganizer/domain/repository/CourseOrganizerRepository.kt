package com.app.courseorganizer.domain.repository

import com.app.courseorganizer.data.local.CourseOrganizerDatabase
import com.app.courseorganizer.domain.models.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseOrganizerRepository @Inject constructor(private val db: CourseOrganizerDatabase) {

    fun getAllCourses(): Flow<List<Course>> = flow {
        val result = db.dao.getAllCourses().map { courseEntity -> courseEntity.toCourse() }
        emit(result)
    }

    suspend fun insertACourse(course: Course): Unit {
        db.dao.insertACourse(course.toCourseEntity())
    }

    suspend fun insertMultipleCourses(courseEntities: List<Course>){
        db.dao.insertMultipleCourses(courseEntities.map { it.toCourseEntity() })
    }
}