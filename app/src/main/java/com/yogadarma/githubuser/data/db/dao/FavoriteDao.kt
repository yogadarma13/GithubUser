package com.yogadarma.githubuser.data.db.dao

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yogadarma.githubuser.domain.entity.UserData

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    fun getAllFavorite(): Cursor

    @Query("SELECT * FROM favorite WHERE id = :id")
    fun getFavoriteById(id: Int?): Cursor

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavorite(favorite: UserData?): Long

    @Query("DELETE FROM favorite WHERE id = :id")
    fun deleteFavorite(id: Int?): Int
}