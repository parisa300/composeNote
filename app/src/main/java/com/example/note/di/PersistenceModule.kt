
package com.example.note.di

import android.app.Application
import androidx.room.Room
import com.example.note.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) =
        Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "database"
        ).build()

    @Provides
    @Singleton
    fun provideTagDao(appDatabase: AppDatabase) = appDatabase.tagDao()

    @Provides
    @Singleton
    fun provideTaskDao(appDatabase: AppDatabase) = appDatabase.taskDao()

    @Provides
    @Singleton
    fun provideProjectDao(appDatabase: AppDatabase) = appDatabase.projectDao()

    @Provides
    @Singleton
    fun provideTaskProjectDao(appDatabase: AppDatabase) = appDatabase.taskProjectDao()
}
