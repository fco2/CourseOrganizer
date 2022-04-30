package com.app.courseorganizer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.courseorganizer.data.local.entities.CourseEntity
import com.app.courseorganizer.data.local.entities.UserEntity

@Database(
    entities = [CourseEntity::class, UserEntity::class],
    version = 1
)
abstract class CourseOrganizerDatabase: RoomDatabase() {
    abstract val dao: CourseOrganizerDao
}