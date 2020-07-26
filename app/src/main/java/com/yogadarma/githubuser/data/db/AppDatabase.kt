package com.yogadarma.githubuser.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yogadarma.githubuser.data.db.dao.FavoriteDao
import com.yogadarma.githubuser.domain.entity.UserData

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val favoriteDao: FavoriteDao

}