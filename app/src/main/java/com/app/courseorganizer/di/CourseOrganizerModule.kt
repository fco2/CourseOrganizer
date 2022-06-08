package com.app.courseorganizer.di

import android.app.Application
import androidx.room.Room
import com.app.courseorganizer.data.local.CourseOrganizerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CourseOrganizerModule {

    @Singleton
    @Provides
    fun providesDatabase(application: Application): CourseOrganizerDatabase =
         Room.databaseBuilder(application, CourseOrganizerDatabase::class.java, CourseOrganizerDatabase.name).build()
}