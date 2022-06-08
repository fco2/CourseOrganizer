package com.app.courseorganizer.domain.models

import com.app.courseorganizer.data.local.entities.CourseEntity

data class Course(
    val title: String,
    val courseCode: String,
    val notes: String? = null,
    val courseId: Long? = null
){
    fun toCourseEntity(): CourseEntity {
        return CourseEntity(
            title = this.title,
            courseCode = this.courseCode,
            notes = notes,
            courseId = courseId
        )
    }
}
