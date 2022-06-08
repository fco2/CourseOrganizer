package com.app.courseorganizer.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.courseorganizer.domain.models.Course

@Entity(
    tableName = "courses"
)
data class CourseEntity(
    val title: String,
    @ColumnInfo(name = "course_code")
    val courseCode: String,
    val notes: String? = null,
    @ColumnInfo(name = "course_id")
    @PrimaryKey val courseId: Long? = null
){
    fun toCourse(): Course {
        return Course(
            title = this.title,
            courseCode = this.courseCode,
            notes = notes,
            courseId = courseId
        )
    }
}
