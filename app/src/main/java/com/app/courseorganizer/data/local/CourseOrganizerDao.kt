package com.app.courseorganizer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.courseorganizer.data.local.entities.CourseEntity
import com.app.courseorganizer.data.local.entities.UserEntity

@Dao
interface CourseOrganizerDao {

    //insert user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAUser(userEntity: UserEntity)

    //insert course
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertACourse(courseEntity: CourseEntity)

    //get all users
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    //get all courses
    @Query("SELECT * FROM courses")
    suspend fun getAllCourses(): List<CourseEntity>

    //get a given user
    @Query("SELECT * FROM users WHERE username = :name LIMIT 1")
    suspend fun getAUser(name: String): UserEntity?

    //get a given course
    @Query("SELECT * FROM courses WHERE course_id = :courseId LIMIT 1")
    suspend fun getACourse(courseId: Long): CourseEntity?

    //search courses
    @Query("SELECT * FROM courses WHERE LOWER(course_code) LIKE '%'|| LOWER(:query) || '%' ")
    suspend fun searchCourse(query: String): List<CourseEntity>
}