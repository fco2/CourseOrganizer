package com.app.courseorganizer.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users"
)
data class UserEntity(
    @ColumnInfo(name="first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    val username: String,
    val email: String,
    val role: String, //Student, Lecturer
    val avatar: String? = null,
    @PrimaryKey val id: Long? = null
)
