package com.app.courseorganizer.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
)
