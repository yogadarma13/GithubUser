package com.yogadarma.githubuser.di

import android.app.Application
import androidx.room.Room
import com.yogadarma.githubuser.data.db.AppDatabase
import com.yogadarma.githubuser.data.db.dao.FavoriteDao
import org.koin.android.ext.koin.androidApplication
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.KoinComponent
import org.koin.dsl.module

internal object MyKoinContext {
    lateinit var koinApplication: KoinApplication
}

interface MyKoinComponent : KoinComponent {
    override fun getKoin(): Koin {
        return MyKoinContext.koinApplication.koin
    }
}

val appDatabaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "favorite_database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: AppDatabase): FavoriteDao {
        return database.favoriteDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}